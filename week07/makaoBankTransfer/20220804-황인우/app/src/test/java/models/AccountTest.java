package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("110", "신태일", 2000);

    assertEquals("110", account.identifier());
    assertEquals("신태일", account.name());
    assertEquals(2000, account.amount());
  }

  @Test
  void transfer() {
    Account sender = new Account("110", "신태일", 2000);
    Account receiver = new Account("179", "매튜", 500);

    sender.transfer(receiver, 60);

    assertEquals(1940, sender.amount());
    assertEquals(560, receiver.amount());
  }
}
