package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("잔액", 1000);
    int amount = 1000 + 100;

    TransactionResult transactionResult = new TransactionResult(transaction, amount);
  }
}