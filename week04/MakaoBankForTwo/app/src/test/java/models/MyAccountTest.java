package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyAccountTest {
  @Test
  void creation() {
    MyAccount myAccount = new MyAccount();

    assertEquals("123-456-7890", myAccount.identifier());
    assertEquals(1000, myAccount.amount());
  }
}
