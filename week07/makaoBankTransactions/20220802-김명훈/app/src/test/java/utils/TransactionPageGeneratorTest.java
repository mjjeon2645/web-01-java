package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionPageGeneratorTest {
  @Test
  void content() {
    Account account = new Account("1234", "ashal", 3000);
    Account account2 = new Account("2345", "joker", 1000);


    PageGenerator pageGenerator = new TransactionPageGenerator(account);

    account.transfer(account2, 500);
    account2.transfer(account, 100);

    String html = pageGenerator.html();
    assertTrue(html.contains("거래 내역 페이지"), "페이지 제목 문제" + html);
    assertTrue(html.contains("송금: joker 500원"), "송금 내역 문제" + html);
    assertTrue(html.contains("입금: joker 100원"), "입금 내역 문제" + html);
  }
}