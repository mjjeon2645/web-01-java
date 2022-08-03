package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new LoginPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>로그인"), "로그인 타이틀 문제" + html);
    assertTrue(html.contains("아이디"), "아이디 레이블 문제" + html);
    assertTrue(html.contains("비밀번호"), "비밀번호 레이블 문제" + html);
    assertTrue(html.contains("로그인</button>"), "로그인 버튼 문제" + html);
  }
}
