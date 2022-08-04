package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("1234", "Ashal", 3000);

    assertEquals("1234", account.identifier());
    assertEquals("Ashal", account.name());
    assertEquals(3000, account.amount());
  }

  @Test
  void transfer() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 500);

    int oldSenderTransactionsCount = sender.transactionsCount();
    int oldReceiverTransactionsCount = receiver.transactionsCount();

    sender.transfer(receiver, 100);
    sender.transfer(receiver, 200);
    receiver.transfer(sender, 300);

    int newSenderTransactionsCount = sender.transactionsCount();
    int newReceiverTransactionsCount = receiver.transactionsCount();

    assertEquals(3000, sender.amount());
    assertEquals(500, receiver.amount());

    assertEquals(3, newSenderTransactionsCount - oldSenderTransactionsCount);
    assertEquals(3, newReceiverTransactionsCount - oldReceiverTransactionsCount);
  }

  @Test
  void transferError() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 500);

    sender.transfer(receiver, -10000000);

    assertEquals(3000, sender.amount());
    assertEquals(500, receiver.amount());
  }

  @Test
  void transactions() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 500);

    sender.transfer(receiver, 100);
    sender.transfer(receiver, 200);
    receiver.transfer(sender, 300);

    List<Transaction> transactions = sender.transactions();

    assertEquals(3, transactions.size());
  }
}
