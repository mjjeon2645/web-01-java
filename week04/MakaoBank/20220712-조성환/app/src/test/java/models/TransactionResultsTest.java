package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultsTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("입금", 1000);

    int amount = 1000 + 100;
    TransactionResult transactionResults =
        new TransactionResult(transaction, amount);

    assertArrayEquals(new String[]{"입금", "1000", "1100"},
        transactionResults.values());
  }
}
