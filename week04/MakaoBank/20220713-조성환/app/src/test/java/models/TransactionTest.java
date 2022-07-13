package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("잔액", 1000);
  }

  @Test
  void equals() {
    Transaction transaction = new Transaction("잔액", 1000);
    Transaction transaction2 = new Transaction("잔액", 1000);

    assertEquals(transaction, transaction2);
  }
}