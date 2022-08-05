package services;

import models.User;
import repositories.UserRepository;

import java.io.IOException;
import java.util.Map;

public class UserService {
  public static final String LOGIN_INFORMATION_MISSED = "LOGIN_INFORMATION_MISSED";
  public static final String LOGIN_ID_NOT_FOUND = "LOGIN_ID_NOT_FOUND";
  public static final String LOGIN_PASSWORD_WRONG = "LOGIN_PASSWORD_WRONG";
  public static final String LOGIN_APPROVED = "LOGIN_APPROVED";

  public static final String REGISTER_INFORMATION_MISSED = "REGISTER_INFORMATION_MISSED";
  public static final String REGISTER_PASSWORDS_DIFFERENT = "REGISTER_PASSWORDS_DIFFERENT";
  public static final String REGISTER_ID_ALREADY_EXISTED = "REGISTER_ID_ALREADY_EXISTED";
  public static final String REGISTER_APPROVED = "REGISTER_APPROVED";

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public String loginValidator(Map<String, String> formData) {
    User findById = userRepository.find(formData.get("id"));

    // 입력정보 누락
    if (!(formData.size() == 2)) {
      return UserService.LOGIN_INFORMATION_MISSED;
    }

    // 사용자 아이디가 존재하지 않을 경우
    if (findById == null) {
      return UserService.LOGIN_ID_NOT_FOUND;
    }

    // 비밀번호가 틀렸을 경우
    if (!findById.password().equals((formData.get("password")))) {
      return UserService.LOGIN_PASSWORD_WRONG;
    }

    // 문제 없음!
    return UserService.LOGIN_APPROVED;
  }

  public String registerValidator(Map<String, String> formData) {

    // 입력정보 누락
    if (!(formData.size() == 5)) {
      return UserService.REGISTER_INFORMATION_MISSED;
    }

    // 비밀번호 재확인이 다를 떄
    if (!(formData.get("password").equals(formData.get("check-password")))) {
      return UserService.REGISTER_PASSWORDS_DIFFERENT;
    }

    // 이미 등록되어 있는 아이디일 때
    if (!(userRepository.find(formData.get("id")) == null)) {
      return UserService.REGISTER_ID_ALREADY_EXISTED;
    }

    // 문제 없음!
    return REGISTER_APPROVED;
  }

  public User initUser(Map<String, String> formData) {
    return new User(
        formData.get("name"),
        formData.get("id"),
        formData.get("password"),
        formData.get("email"));
  }

  public void register(User user) throws IOException {
    userRepository.add(user);
  }
}
