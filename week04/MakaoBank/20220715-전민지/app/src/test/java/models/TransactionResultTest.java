package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("잔액", 1000);

    TransactionResult transactionResult
        = new TransactionResult(transaction, 1000);

    assertArrayEquals(new String[]{"잔액", "1000", "1000"}, transactionResult.values());
  }

  @Test
  void toCsvRow() {
    Transaction transaction = new Transaction("잔액", 1000);

    TransactionResult transactionResult
        = new TransactionResult(transaction, 1000);

    assertEquals("잔액,1000,1000", transactionResult.toCsvRow());
  }
}
