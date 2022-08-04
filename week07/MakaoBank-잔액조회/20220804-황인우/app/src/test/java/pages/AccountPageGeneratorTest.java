package pages;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountPageGeneratorTest {
  @Test
  void content() {
    Account account = new Account("110", "신태일", 2000);

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String content = pageGenerator.content();

    assertTrue(
        content.contains("계좌번호: 110"),
        "계좌번호 안내 문제\n" + content);
    assertTrue(
        content.contains("이름: 신태일"),
        "이름 안내 문제\n" + content);
    assertTrue(
        content.contains("잔액: 2000원"),
        "잔액 안내 문제\n" + content);
  }
}
