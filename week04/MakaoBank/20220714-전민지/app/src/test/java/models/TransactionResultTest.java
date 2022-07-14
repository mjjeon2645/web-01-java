package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("입금", 2000);
    int amount = 1000 + 2000;

    TransactionResult transactionResult
        = new TransactionResult(transaction, amount);

    assertArrayEquals(new String[]{"입금", "2000", "3000"}, transactionResult.values());
  }

  @Test
  void toCsvRow() {
    Transaction transaction = new Transaction("입금", 2000);
    int amount = 1000 + 2000;

    TransactionResult transactionResult
        = new TransactionResult(transaction,amount);

    assertEquals("입금,2000,3000", transactionResult.toCsvRow());
  }
}
