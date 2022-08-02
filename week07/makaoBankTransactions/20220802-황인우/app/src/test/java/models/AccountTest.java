package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("352", "치코리타", 10000);

    assertEquals("352", account.identifier());
    assertEquals("치코리타", account.name());
    assertEquals(10000, account.amount());
  }

  @Test
  void transfer() {
    Account sender = new Account("352", "치코리타", 10000);
    Account receiver = new Account("179", "파이리", 10000);

    int oldSenderTransactionsCount = sender.transactionsCount();
    int oldReceiverTransactionsCount = receiver.transactionsCount();

    sender.transfer(receiver, 5000);

    assertEquals(5000, sender.amount());
    assertEquals(15000, receiver.amount());

    int newSenderTransactionsCount = sender.transactionsCount();
    int newReceiverTransactionsCount = receiver.transactionsCount();

    assertEquals(1, newSenderTransactionsCount - oldSenderTransactionsCount);
    assertEquals(1, newReceiverTransactionsCount - oldReceiverTransactionsCount);
  }

  @Test
  void transferError() {
    Account sender = new Account("352", "치코리타", 10000);
    Account receiver = new Account("179", "파이리", 10000);

    sender.transfer(receiver, -5000);

    assertEquals(10000, sender.amount());
    assertEquals(10000, receiver.amount());
  }

  @Test
  void transactions() {
    Account sender = new Account("352", "치코리타", 10000);
    Account receiver = new Account("179", "파이리", 10000);

    sender.transfer(receiver, 5000);

    assertEquals(1, sender.transactions().size());
    assertEquals(1, receiver.transactions().size());
  }

  @Test
  void equals() {
    Account account1 = new Account("352", "치코리타", 300);
    Account account2 = new Account("352", "치코리타", 300);
    Account account3 = new Account("179", "파이리", 300);

    assertTrue(account1.equals(account1));
    assertTrue(account1.equals(account2));
    assertFalse(account1.equals(account3));
  }
}
