package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("입금", 100);
    int amount = 1000 + 100;

    TransactionResult transactionResult
        = new TransactionResult(transaction, amount);

    assertArrayEquals(new String[]{"입금", "100", "1100"},
        transactionResult.values());
  }
}
