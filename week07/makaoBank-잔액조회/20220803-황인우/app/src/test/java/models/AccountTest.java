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
}
