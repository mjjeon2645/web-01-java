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
  void process() {
    assertEquals(1000, new Transaction("잔액", 1000).process(0));
    assertEquals(1000, new Transaction("잔액", 1000).process(500));

    assertEquals(1500, new Transaction("입금", 1000).process(500));

    assertEquals(700, new Transaction("출금", 300).process(1000));

    assertEquals(1000000, new Transaction("해킹", 10).process(1000000));
  }
}
