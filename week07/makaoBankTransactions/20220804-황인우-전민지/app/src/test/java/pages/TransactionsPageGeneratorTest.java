package pages;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TransactionsPageGeneratorTest {
  @Test
  void content() {
    Account account = new Account("1234", "Ashal", 3000);
    PageGenerator pageGenerator = new TransactionsPageGenerator(account);

    String content = pageGenerator.content();

    assertTrue(content.contains("<h1>Ashal 거래 내역 조회"), "거래내역 제목 문제" + content);
  }

  @Test
  void transactions() {
    Account account = new Account("1234", "Ashal", 3000);
    Account account2 = new Account("2345", "JOKER", 1000);

    account.transfer(account2, 300);
    account.transfer(account2, 150);

    PageGenerator pageGenerator = new TransactionsPageGenerator(account);

    String content = pageGenerator.content();

    assertTrue(content.contains("송금: JOKER 300원"), "송금 내역 문제" + content);
    assertTrue(content.contains("송금: JOKER 150원"), "송금 내역 문제" + content);
  }
}
