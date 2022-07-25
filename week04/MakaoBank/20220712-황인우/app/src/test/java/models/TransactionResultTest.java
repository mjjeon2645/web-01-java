package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {
  @Test
  void creation() {
    TransactionResult transactionResult
        = new TransactionResult(new Transaction("잔액", 50000), 50000);
  }

  @Test
  void equals() {
    TransactionResult transactionResult1
        = new TransactionResult(new Transaction("잔액", 50000), 50000);
    TransactionResult transactionResult2
        = new TransactionResult(new Transaction("잔액", 50000), 50000);

    assertEquals(transactionResult1, transactionResult2);
  }

  @Test
  void values() {
    TransactionResult transactionResult
        = new TransactionResult(new Transaction("출금", 200), 2000);

    String[] values = transactionResult.values();

    assertArrayEquals(new String[]{"출금", "200", "2000"}, values);
  }

  @Test
  void getCsvRow() {
    TransactionResult transactionResult
        = new TransactionResult(new Transaction("입금", 5000000), 5000500);

    assertEquals("입금,5000000,5000500", transactionResult.getCsvRow());
  }
}
