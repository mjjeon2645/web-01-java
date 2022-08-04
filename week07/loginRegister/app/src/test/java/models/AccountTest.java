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

  @Test
  void toCsvRow() {
    Account account = new Account("전민지", "mjjeon2645", "1234", "angel2645@naver.com");
    Account account2 = new Account("공유", "gongyoo", "1234", "gongyoo@naver.com");
    Account account3 = new Account("이정재", "ljj", "1234", "ljj@naver.com");

    assertEquals("전민지,mjjeon2645,1234,angel2645@naver.com", account.toCsvRow());
    assertEquals("공유,gongyoo,1234,gongyoo@naver.com", account2.toCsvRow());
    assertEquals("이정재,ljj,1234,ljj@naver.com", account3.toCsvRow());
  }
}
