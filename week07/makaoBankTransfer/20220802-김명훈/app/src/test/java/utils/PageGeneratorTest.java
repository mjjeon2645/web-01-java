package utils;

import models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PageGeneratorTest {
  @Test
  void navigation() {
    Account account = new Account("1234","Ashal",3000);
    PageGenerator pageGenerator = new PageGenerator() {
      @Override
      public String content() {
        return "";
      }
    };
    String html = pageGenerator.html();
    assertTrue(html.contains("홈으로"),"홈 화면 문제" + html);
    assertTrue(html.contains("잔액 조회"),"잔액 화면 문제" + html);
    assertTrue(html.contains("송금"),"송금 화면 문제" + html);
  }

}