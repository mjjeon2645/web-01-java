package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("잔액",1000);
    int amount = 1000;
    TransactionResult transactionResult = new TransactionResult(transaction,amount);
  }

  @Test
  void compareTransactonResults() {
    Transaction transaction = new Transaction("잔액",1000);
    TransactionResult transactionResult1 = new TransactionResult(transaction,1000);
    TransactionResult transactionResult2 = new TransactionResult(transaction,1000);

    assertEquals(transactionResult1,transactionResult2);
  }



}