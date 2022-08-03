package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import pages.PageGenerator;
import pages.TransactionsPageGenerator;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsPageGeneratorTest {
  @Test
  void content() {
    Account account = new Account("1234", "Ashal", 3000);
    Account account2 = new Account("2345", "JOKER", 1000);
    long amount = 500;

    account.transfer(account2, amount);
    account2.transfer(account, 100);

    PageGenerator pageGenerator = new TransactionsPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>거래 내역"), "제목 문제" + html);
    assertTrue(html.contains("송금: JOKER 500"), "송금 내역 문제" + html);
    assertTrue(html.contains("입금: JOKER 100"), "입금 내역 문제" + html);
  }
}
