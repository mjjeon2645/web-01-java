package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("잔액", 1000);
  }

  @Test
  void equals() {
    Transaction transaction1 = new Transaction("잔액", 1000);
    Transaction transaction2 = new Transaction("잔액", 1000);

    assertEquals(transaction1, transaction2);
  }

  @Test
  void string() {
    Transaction transaction = new Transaction("잔액", 1000);
    assertEquals("Transaction(잔액: 1000)", transaction.toString());
  }

  @Test
  void process() {
    assertEquals(1000, new Transaction("잔액", 1000).process(100));

    assertEquals(3000, new Transaction("입금", 2000).process(1000));

    assertEquals(2900, new Transaction("출금", 100).process(3000));

    assertEquals(3000, new Transaction("오류", 1000).process(3000));
  }
}
