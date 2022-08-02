package pages;

import models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsPageGeneratorTest {
  @Test
  void content() {
    Account account = new Account("1234", "ashal", 3000);
    Account account2 = new Account("2345", "joker", 1000);
    PageGenerator pageGenerator = new TransactionsPageGenerator(account);

    account.transfer(account2, 500);
    account2.transfer(account, 100);

    String content = pageGenerator.content();

    assertTrue(content.contains("거래 내역 페이지"), "페이지 제목 문제" + content);
    assertTrue(content.contains("송금: joker 500원"), "송금 문제" + content);
    assertTrue(content.contains("입금: joker 100원"), "입금 문제" + content);
  }
}
