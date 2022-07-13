package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {
  @Test
  void simple() {
    Transaction transaction = new Transaction("입금", 1000);

    int amount = 1000 + 1000;

    TransactionResult transactionResult = new TransactionResult(transaction,amount);

    assertArrayEquals(new String[] {"입금","1000","2000"},transactionResult.values());
  }

  @Test
  void toCSV() {
    Transaction transaction = new Transaction("입금",100);

    int amount = 1000;

    TransactionResult transactionResult =
        new TransactionResult(transaction, amount);

    assertEquals("입금,100,1000",transactionResult.toCsvRow());
  }
}