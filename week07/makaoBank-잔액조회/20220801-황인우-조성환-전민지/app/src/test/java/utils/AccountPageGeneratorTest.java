package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountPageGeneratorTest {
  @Test
  void html() {
    Account account = new Account("1234","ashal",3000);

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("<p>계좌번호: 1234"));
    assertTrue(html.contains("<p>이름: ashal"));
    assertTrue(html.contains("<p>잔액: 3000원"));
  }
}
