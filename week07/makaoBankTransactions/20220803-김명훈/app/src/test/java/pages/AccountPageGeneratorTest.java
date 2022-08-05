package pages;

import models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountPageGeneratorTest {
  @Test
  void account() {
    Account account = new Account("1234", "ashal", 3000);
    PageGenerator pageGenerator = new AccountPageGenerator(account);
    String html = pageGenerator.html();
    assertTrue(html.contains("이름: "), "이름문제" + html);
    assertTrue(html.contains("계좌번호: "), "계좌문제" + html);
    assertTrue(html.contains("잔액"), "잔액문제" + html);
  }
}
