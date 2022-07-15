package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheOtherAccountTest {
  @Test
  void creation() {
    TheOtherAccount theOtherAccount = new TheOtherAccount();

    assertEquals("123-456-7890", theOtherAccount.identifier());
    assertEquals(1000, theOtherAccount.amount());
  }
}
