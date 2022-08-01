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
}
