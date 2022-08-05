package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import pages.AccountPageGenerator;
import pages.PageGenerator;

import static org.junit.jupiter.api.Assertions.*;

class AccountPageGeneratorTest {
  @Test
  void html() {
    Account account = new Account("1234", "Ashal", 3000);

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("<p>계좌번호: 1234"), "계좌번호 문제");
    assertTrue(html.contains("<p>이름: Ashal"), "이름 문제");
    assertTrue(html.contains("<p>잔액: 3000"), "잔액 문제");
  }
}
