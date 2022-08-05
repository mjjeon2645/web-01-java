package pages;

import services.UserService;

public class RegisterErrorPageGenerator extends PageGenerator {
  private final String status;

  public RegisterErrorPageGenerator(String status) {
    this.status = status;
  }

  @Override
  public String content() {
    if (status.equals(UserService.REGISTER_INFORMATION_MISSED)) {
      return informationMissedMessage();
    }

    if (status.equals(UserService.REGISTER_PASSWORDS_DIFFERENT)) {
      return passwordsDifferentMessage();
    }

    if (status.equals(UserService.REGISTER_ID_ALREADY_EXISTED)) {
      return idAlreadyExistedMessage();
    }
    return "";
  }

  public String informationMissedMessage() {
    return "<h1>입력되지 않은 정보가 있습니다. 다시 확인해주세요.</h1>\n" +
        "<a href =\"/registration\">되돌아가기</a>\n";
  }

  public String passwordsDifferentMessage() {
    return "<h1>입력하신 비밀번호가 서로 일치하지 않습니다. 다시 확인해주세요.</h1>\n" +
        "<a href =\"/registration\">되돌아가기</a>\n";
  }

  public String idAlreadyExistedMessage() {
    return "<h1>이미 등록된 아이디입니다.</h1>\n" +
        "<a href =\"/registration\">되돌아가기</a>\n";
  }
}
