package pages;

import org.junit.jupiter.api.Test;
import services.UserService;

import static org.junit.jupiter.api.Assertions.*;

class LoginErrorPageGeneratorTest {
  @Test
  void informationMissed() {
    String status = UserService.LOGIN_INFORMATION_MISSED;

    PageGenerator pageGenerator = new LoginErrorPageGenerator(status);

    String content = pageGenerator.content();

    assertTrue(content.contains("<h1>입력되지 않은 정보"), "타이틀 문제" + content);
    assertTrue(content.contains("되돌아가기"), "되돌아가는 메뉴 문제" + content);
  }

  @Test
  void idNotFound() {
    String status = UserService.LOGIN_ID_NOT_FOUND;

    PageGenerator pageGenerator = new LoginErrorPageGenerator(status);

    String content = pageGenerator.content();

    assertTrue(content.contains("<h1>사용자를 찾을 수"), "타이틀 문제" + content);
    assertTrue(content.contains("되돌아가기"), "되돌아가기 메뉴 문제" + content);
  }

  @Test
  void wrongPassword() {
    String status = UserService.LOGIN_PASSWORD_WRONG;

    PageGenerator pageGenerator = new LoginErrorPageGenerator(status);

    String content = pageGenerator.content();

    assertTrue(content.contains("<h1>비밀번호가 일치"), "타이틀 문제" + content);
    assertTrue(content.contains("되돌아가기"), "되돌아가는 메뉴 문제" + content);
  }
}
