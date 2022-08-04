package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsPageGeneratorTest {
  @Test
  void content() {
    Account sender = new Account("1234", "ashal", 3000);
    Account receiver = new Account("1234", "joker", 3000);
    PageGenerator pageGenerator = new TransactionsPageGenerator(sender);

    sender.transfer(receiver, 500);
    receiver.transfer(sender, 100);

    String html = pageGenerator.content();
    assertTrue(html.contains("거래 내역"), "거래 내역 문제" + html);
    assertTrue(html.contains("송금: joker 500원"), "송금 내역 문제 " + html);
    assertTrue(html.contains("입금: joker 100원"), "입금 내역 문제 " + html);
  }
}
