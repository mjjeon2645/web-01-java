package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("전민지", "mjjeon2645", "1234", "angel2645@naver.com");

    assertEquals("전민지", account.name());
    assertEquals("mjjeon2645", account.id());
    assertEquals("1234", account.password());
    assertEquals("angel2645@naver.com", account.email());
  }

  @Test
  void equals() {
    Account account = new Account("전민지", "mjjeon2645", "1234", "angel2645@naver.com");

    assertEquals(account, new Account("전민지", "mjjeon2645", "1234", "angel2645@naver.com"));
  }
}
