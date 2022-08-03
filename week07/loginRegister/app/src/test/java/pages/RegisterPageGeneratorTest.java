package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterPageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new RegisterPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>회원가입"), "회원가입 타이틀 문제" + html);
    assertTrue(html.contains("<p>이름"), "이름 레이블 문제" + html);
    assertTrue(html.contains("<p>아이디"), "아이디 레이블 문제" + html);
    assertTrue(html.contains("<p>비밀번호"), "비밀번호 레이블 문제" + html);
    assertTrue(html.contains("<p>비밀번호 재확인"), "재확인 레이블 문제" + html);
    assertTrue(html.contains("<p>이메일"), "이메일" + html);
    assertTrue(html.contains("회원가입</button>"), "회원가입 버튼" + html);
  }
}
