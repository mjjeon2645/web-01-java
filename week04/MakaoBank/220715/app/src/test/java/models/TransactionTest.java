package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("잔액",1000);
  }

  @Test
  void compareTransactions() {
    Transaction transaction1 = new Transaction("잔액",1000);
    Transaction transaction2 = new Transaction("잔액",1000);
    assertEquals(transaction1,transaction2);
  }

  @Test
  void String() {
    Transaction transaction1 = new Transaction("잔액", 1000);
    Transaction transaction2 = new Transaction("잔액", 1000);
    assertEquals(transaction1, transaction2);
  }
}