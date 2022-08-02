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
    Account account1 = new Account("1234", "ashal", 3000);
    Account account2 = new Account("2345", "joker", 500);

    account1.transfer(account2, 1000);
    assertEquals(2000, account1.amount());
    assertEquals(1500, account2.amount());
  }
}
