package models;

import org.junit.jupiter.api.Test;

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
    Account receiver = new Account("2345", "Joker", 1000);

    sender.transfer(receiver, 500);

    assertEquals(2500, sender.amount());
    assertEquals(1500, receiver.amount());
  }

  @Test
  void transactionCount() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 1000);

    int oldSenderTransactionCount = sender.transactionsCount();
    int oldReceiverTransactionCount = receiver.transactionsCount();

    sender.transfer(receiver, 500);

    int newSenderTransactionCount = sender.transactionsCount();
    int newReceiverTransactionCount = receiver.transactionsCount();

    assertEquals(1, newSenderTransactionCount - oldSenderTransactionCount);
    assertEquals(1, newReceiverTransactionCount - oldReceiverTransactionCount);
  }

  @Test
  void transactions() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 1000);

    sender.transfer(receiver, 500);

    assertEquals(1, sender.transactions().size());
    assertEquals(1, receiver.transactions().size());
  }

  @Test
  void equals() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 1000);

    assertTrue(sender.equals(sender));
    assertFalse(sender.equals(receiver));
  }
}
