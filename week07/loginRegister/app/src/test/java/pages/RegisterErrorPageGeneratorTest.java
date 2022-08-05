package pages;

import org.junit.jupiter.api.Test;
import services.UserService;

import static org.junit.jupiter.api.Assertions.*;

class RegisterErrorPageGeneratorTest {
  @Test
  void informationMissed() {
    String status = UserService.REGISTER_INFORMATION_MISSED;

    PageGenerator pageGenerator = new RegisterErrorPageGenerator(status);

    String content = pageGenerator.content();

    assertTrue(content.contains("<h1>입력되지 않은 정보"), "타이틀 문제" + content);
    assertTrue(content.contains("되돌아가기"), "되돌아가는 메뉴 문제" + content);
  }

  @Test
  void idNotFound() {
    String status = UserService.REGISTER_ID_ALREADY_EXISTED;

    PageGenerator pageGenerator = new RegisterErrorPageGenerator(status);

    String content = pageGenerator.content();

    assertTrue(content.contains("<h1>이미 등록된 아이디"), "타이틀 문제" + content);
    assertTrue(content.contains("되돌아가기"), "되돌아가기 메뉴 문제" + content);
  }

  @Test
  void wrongPassword() {
    String status = UserService.REGISTER_PASSWORDS_DIFFERENT;

    PageGenerator pageGenerator = new RegisterErrorPageGenerator(status);

    String content = pageGenerator.content();

    assertTrue(content.contains("<h1>입력하신 비밀번호"), "타이틀 문제" + content);
    assertTrue(content.contains("되돌아가기"), "되돌아가기 메뉴 문제" + content);
  }
}
