package pages;

import services.UserService;

public class LoginErrorPageGenerator extends PageGenerator {
  private final String status;

  public LoginErrorPageGenerator(String status) {
    this.status = status;
  }

  @Override
  public String content() {
    if (status.equals(UserService.LOGIN_INFORMATION_MISSED)) {
      return InformationMissedMessage();
    }

    if (status.equals(UserService.LOGIN_ID_NOT_FOUND)) {
      return IdNotFoundMessage();
    }

    if (status.equals(UserService.LOGIN_PASSWORD_WRONG)) {
      return wrongPasswordMessage();
    }
    return "";
  }

  public String InformationMissedMessage() {
    return "<h1>입력되지 않은 정보가 있습니다. 다시 확인해주세요.</h1>\n" +
        "<a href =\"/login\">되돌아가기</a>\n";
  }

  public String wrongPasswordMessage() {
    return "<h1>비밀번호가 일치하지 않습니다. 다시 확인해주세요</h1>\n" +
        "<a href =\"/login\">되돌아가기</a>\n";
  }

  public String IdNotFoundMessage() {
    return "<h1>사용자를 찾을 수 없습니다. 다시 시도해주세요.</h1>\n" +
        "<a href =\"/login\">되돌아가기</a>\n";
  }
}
