package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountPageGeneratorTest {
  @Test
  void html() {
    Account account = new Account("1234", "Ashal", 1000);
    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("<p>계좌번호: "), "계좌번호 문제" + html);
    assertTrue(html.contains("<p>이름: "), "이름 문제" + html);
    assertTrue(html.contains("<p>잔액: "), "잔액 문제" + html);
  }
}
