package utils;

import models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {
  @Test
  void Transfer() {
    Account account = new Account("1234","Ashal",3000);

    PageGenerator pageGenerator = new TransferPageGenerator(account);
    String html = pageGenerator.html();
    assertTrue(html.contains("잔액: "),"잔액 확인 문제" + html);
    assertTrue(html.contains("보낼 계좌:<input"),"계좌 확인 문제" + html);
    assertTrue(html.contains("보낼 금액:<input"),"금액 확인 문제" + html);
    assertTrue(html.contains("<button type="),"버튼 문제" + html);
  }

}