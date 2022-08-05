package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("110", "레드", 10000);

    assertEquals("110", account.identifier());
    assertEquals("레드", account.name());
    assertEquals(10000, account.amount());
  }

  @Test
  void transfer() {
    Account sender = new Account("110", "한지우", 10000);
    Account receiver = new Account("110", "오바람", 5000);

    sender.transfer(receiver, 300);

    assertEquals(10000 - 300, sender.amount());
    assertEquals(5000 + 300, receiver.amount());
  }

  @Test
  void transactions() {
    Account sender = new Account("110", "한지우", 10000);
    Account receiver = new Account("110", "오바람", 5000);

    assertEquals(0, sender.transactionsCount());
    assertEquals(0, receiver.transactionsCount());

    sender.transfer(receiver, 300);
    sender.transfer(receiver, 500);
    receiver.transfer(sender, 700);

    assertEquals(3, sender.transactionsCount());
    assertEquals(3, receiver.transactionsCount());
  }

  @Test
  void equals() {
    Account account1 = new Account("110", "한지우", 10000);
    Account account2 = new Account("110", "한지우", 10000);

    assertEquals(account1, account1);
    assertEquals(account1, account2);
  }
}
