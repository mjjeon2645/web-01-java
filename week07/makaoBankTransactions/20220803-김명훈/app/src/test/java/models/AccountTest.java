package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("1234", "ashal", 3000);
    assertEquals("1234", account.identifier());
    assertEquals("ashal", account.name());
    assertEquals(3000, account.amount());
  }

  @Test
  void transfer() {
    Account sender = new Account("1234", "ashal", 3000);
    Account receiver = new Account("2345", "joker", 500);

    int oldSenderTransactionCount = sender.transactionsCount();
    int oldReceiverTransactionCount = receiver.transactionsCount();

    sender.transfer(receiver, 1000);
    assertEquals(2000, sender.amount());
    assertEquals(1500, receiver.amount());

    int newSenderTransactionCount = sender.transactionsCount();
    int newReceiverTransactionCount = receiver.transactionsCount();

    assertEquals(1, newSenderTransactionCount - oldSenderTransactionCount);
    assertEquals(1, newReceiverTransactionCount - oldReceiverTransactionCount);
  }

  @Test
  void transactions() {
    Account sender = new Account("1234", "ashal", 3000);
    Account receiver = new Account("2345", "joker", 500);

    sender.transfer(receiver, 1000);

    assertEquals(1, sender.transactions().size());
    assertEquals(1, receiver.transactions().size());
  }

  @Test
  void equals() {
    Account account1 = new Account("1234", "ashal", 3000);
    Account account2 = new Account("2345", "joker", 500);
    Account account3 = new Account("1234", "ashal", 3000);

    assertTrue(account1.equals(account1));
    assertFalse(account1.equals(account2));
    assertTrue(account1.equals(account3));
  }
}
