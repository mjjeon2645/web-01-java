package services;

import models.User;
import org.junit.jupiter.api.Test;
import repositories.UserRepository;
import utils.FormParser;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

  @Test
  void loginInformationMissed() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();

    UserService userService = new UserService(userRepository);

    FormParser formParser = new FormParser();

    String rawData = "id=mjjeon2645&password=";

    Map<String, String> formData = formParser.parse(rawData);

    assertEquals("LOGIN_INFORMATION_MISSED", userService.loginValidator(formData));
  }

  @Test
  void loginIdNotFound() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();

    UserService userService = new UserService(userRepository);

    FormParser formParser = new FormParser();

    String rawData = "id=mjjeon&password=1234";

    Map<String, String> formData = formParser.parse(rawData);

    assertEquals("LOGIN_ID_NOT_FOUND", userService.loginValidator(formData));
  }

  @Test
  void loginPasswordWrong() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();

    UserService userService = new UserService(userRepository);

    FormParser formParser = new FormParser();

    String rawData = "id=mjjeon2645&password=2345";

    Map<String, String> formData = formParser.parse(rawData);

    assertEquals("LOGIN_PASSWORD_WRONG", userService.loginValidator(formData));
  }

  @Test
  void loginApproved() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();

    UserService userService = new UserService(userRepository);

    FormParser formParser = new FormParser();

    String rawData = "id=mjjeon2645&password=1234";

    Map<String, String> formData = formParser.parse(rawData);

    assertEquals("LOGIN_APPROVED", userService.loginValidator(formData));
  }

  @Test
  void registerInformationMissed() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();

    UserService userService = new UserService(userRepository);

    FormParser formParser = new FormParser();

    String rawData = "name=전민지&id=mjjeon2645&password=1234" +
        "&check-password=1234&email=";

    Map<String, String> formData = formParser.parse(rawData);

    assertEquals("REGISTER_INFORMATION_MISSED", userService.registerValidator(formData));
  }

  @Test
  void registerPasswordsDifferent() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();

    UserService userService = new UserService(userRepository);

    FormParser formParser = new FormParser();

    String rawData = "name=전민지&id=mjjeon2645&password=1234" +
        "&check-password=2345&email=angel2645@naver.com";

    Map<String, String> formData = formParser.parse(rawData);

    assertEquals("REGISTER_PASSWORDS_DIFFERENT", userService.registerValidator(formData));
  }

  @Test
  void registerIdAlreadyExisted() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();

    UserService userService = new UserService(userRepository);

    FormParser formParser = new FormParser();

    String rawData = "name=전민지&id=mjjeon2645&password=1234" +
        "&check-password=1234&email=angel2645@naver.com";

    Map<String, String> formData = formParser.parse(rawData);

    assertEquals("REGISTER_ID_ALREADY_EXISTED", userService.registerValidator(formData));
  }

  @Test
  void registerApproved() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();

    UserService userService = new UserService(userRepository);

    FormParser formParser = new FormParser();

    String rawData = "name=전민지&id=mjjeon2646&password=1234" +
        "&check-password=1234&email=angel2645@naver.com";

    Map<String, String> formData = formParser.parse(rawData);

    assertEquals("REGISTER_APPROVED", userService.registerValidator(formData));
  }

  @Test
  void initUser() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();

    UserService userService = new UserService(userRepository);

    FormParser formParser = new FormParser();

    String rawData = "name=전민지&id=mjjeon2646&password=1234" +
        "&check-password=1234&email=angel2645@naver.com";

    Map<String, String> formData = formParser.parse(rawData);

    User user = userService.initUser(formData);

    assertEquals("전민지", user.name());
    assertEquals("mjjeon2646", user.id());
    assertEquals("1234", user.password());
    assertEquals("angel2645@naver.com", user.email());
  }
}
