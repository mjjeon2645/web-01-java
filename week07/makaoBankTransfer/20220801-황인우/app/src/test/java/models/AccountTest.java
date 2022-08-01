package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("352-0528", "Chikorita", 10000);

    assertEquals("352-0528", account.identifier());
    assertEquals("Chikorita", account.name());
    assertEquals(10000, account.amount());
  }

  @Test
  void transfer() {
    Account sender = new Account("352-0528", "Chikorita", 10000);
    Account receiver = new Account("179-20", "Eevee", 5000);

    sender.transfer(receiver, 2000);

    assertEquals(8000, sender.amount());
    assertEquals(7000, receiver.amount());
  }
}
