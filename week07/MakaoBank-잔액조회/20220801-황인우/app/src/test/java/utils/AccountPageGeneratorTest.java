package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountPageGeneratorTest {
  @Test
  void html() {
    Account account = new Account("352", "Chikorita", 10000);

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("계좌번호: 352"), "html에 계좌번호 없음\n" + html);
    assertTrue(html.contains("예금주: Chikorita"), "html에 예금주 없음\n" + html);
    assertTrue(html.contains("잔액: 10000원"), "html에 잔액 없음\n" + html);
  }
}
