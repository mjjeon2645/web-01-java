package utils;

import models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountPageGeneratorTest {
  @Test
  void html() {
    Account account = new Account("1234", "Ashal", 3000);
    AccountPageGenerator accountPageGenerator = new AccountPageGenerator(account);

    String html = accountPageGenerator.html();
    assertTrue(html.contains("계좌번호: 1234"), "계좌문제");
    assertTrue(html.contains("이름: Ashal"), "이름문제");
    assertTrue(html.contains("잔액: 3000원"), "잔액문제");
  }
}
