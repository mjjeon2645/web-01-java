package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account();

    assertEquals("123-456-7890", account.myAccountNumber());
    assertEquals("345-678-9012", account.otherAccountNumber());
  }

  @Test
  void amount() {
    Account account = new Account();

    assertEquals(1000, account.myAmount());
    assertEquals(3000, account.otherAmount());
  }

  @Test
  void transfer() {
    Account account = new Account();
    account.myTransfer(100);

    assertEquals(900, account.myAmount());

    account.otherTransfer(300);
    assertEquals(2800, account.otherAmount());
  }

}
