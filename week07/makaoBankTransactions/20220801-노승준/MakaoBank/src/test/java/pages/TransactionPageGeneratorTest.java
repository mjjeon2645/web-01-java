package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import pages.PageGenerator;
import pages.TransactionPageGenerator;

import static org.junit.jupiter.api.Assertions.*;

class TransactionPageGeneratorTest {
  @Test
  void content() {
    Account account = new Account("1234", "ashal", 3000);
    Account account2 = new Account("2345", "joker", 1000);

    account.transfer(account2, 500);
    account2.transfer(account, 100);

    PageGenerator pageGenerator = new TransactionPageGenerator(account);

    String html = pageGenerator.content();

    assertTrue(html.contains("거래 내역"), "페이지 제목 문제: " + html);
    assertTrue(html.contains("송금: joker 500원"), "송금 내역 문제: " + html);
    assertTrue(html.contains("입금: joker 100원"), "입금 내역 문제: " + html);
  }
}
