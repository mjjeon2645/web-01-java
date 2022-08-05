package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountPageGeneratorTest {

  @Test
  void html() {
    Account account = new Account("110", "레드", 10000);

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(
        html.contains("계좌번호: 110"),
        "html에 계좌번호 안내 메세지 없음\n" + html);
    assertTrue(
        html.contains("예금주: 레드"),
        "html에 예금주 안내 메세지 없음\n" + html);
    assertTrue(
        html.contains("잔액: 10000원"),
        "html에 잔액 안내 메세지 없음\n" + html);
  }
}
