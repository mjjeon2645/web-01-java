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

    sender.transfer(receiver, 5000);

    assertEquals(5000, sender.amount());
    assertEquals(15000, receiver.amount());
  }
}
