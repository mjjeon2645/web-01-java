package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("110", "신태일", 2000);

    assertEquals("110", account.identifier());
    assertEquals("신태일", account.name());
    assertEquals(2000, account.amount());
  }
}
