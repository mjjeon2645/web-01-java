package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
