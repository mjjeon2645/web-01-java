package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("잔액", 3000);
  }

  @Test
  void equals() {
    Transaction transaction1 = new Transaction("잔액", 10000000);
    Transaction transaction2 = new Transaction("잔액", 10000000);

    assertEquals(transaction1, transaction2);
  }

  @Test
  void processBalance() {
    Transaction transaction = new Transaction("잔액", 10000000);

    assertEquals(10000000, transaction.process(0));
    assertEquals(10000000, transaction.process(1200));
  }

  @Test
  void processTransfer() {
    Transaction transaction = new Transaction("출금", 10000000);

    assertEquals(2000000, transaction.process(12000000));
  }

  @Test
  void processDeposit() {
    Transaction transaction = new Transaction("입금", 10000000);

    assertEquals(10000200, transaction.process(200));
  }

  @Test
  void processError() {
    Transaction transaction = new Transaction("해킹", 20);

    assertEquals(10000000, transaction.process(10000000));
  }
}
