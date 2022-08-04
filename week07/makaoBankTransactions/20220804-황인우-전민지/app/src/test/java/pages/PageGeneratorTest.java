package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageGeneratorTest {
  @Test
  void navigation() {
    PageGenerator pageGenerator = new PageGenerator() {
      @Override
      public String content() {
        return "";
      }
    };

    String html = pageGenerator.html();

    assertTrue(html.contains("홈으로"), "홈으로 버튼 문제" + html);
    assertTrue(html.contains("잔액 조회"), "잔액 조회 버튼 문제" + html);
    assertTrue(html.contains("송금"), "송금 버튼 문제" + html);
    assertTrue(html.contains("거래 내역"), "거래내역 메뉴 문제" + html);
  }
}
