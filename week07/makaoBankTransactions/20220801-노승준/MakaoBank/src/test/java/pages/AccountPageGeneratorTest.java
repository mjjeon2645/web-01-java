package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import pages.AccountPageGenerator;
import pages.PageGenerator;

import static org.junit.jupiter.api.Assertions.*;

class AccountPageGeneratorTest {
  @Test
  void html() {
    Account account = new Account("1234", "ashal", 3000);

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("계좌번호: 1234"), "계좌 문제");
    assertTrue(html.contains("이름: ashal"), "이름 문제");
    assertTrue(html.contains("잔액: 3000"), "잔액 문제");

  }
}
