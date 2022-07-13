package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("잔액", 1000);
    TransactionResult transactionResult =
        new TransactionResult(transaction, 1000);
  }

  @Test
  void equals() {
    TransactionResult transactionResult
        = new TransactionResult(new Transaction("잔액", 1000), 1000);

    assertEquals(new TransactionResult(new Transaction("잔액", 1000), 1000),
        transactionResult);
  }

  @Test
  void equals2() {
    Transaction transaction1 = new Transaction("잔액", 1000);
    Transaction transaction2 = new Transaction("잔액", 1000);
    TransactionResult transactionResult1
        = new TransactionResult(transaction1, 1000);

    TransactionResult transactionResult2
        = new TransactionResult(transaction2, 1000);

    assertEquals(transactionResult1, transactionResult2);

  }
}
