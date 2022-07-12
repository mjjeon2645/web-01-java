package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  // 1. 거래 정보 만들기 << creation
  // 2. 거래 정보 비교 << equals, 테스트 결과에서 내용이 잘 보이도록 << toString
  // 3. 잔액 변동? << TODO
  // 4. 잔액 변동 결과 도출
  @Test
  void creation() {
    Transaction transaction = new Transaction("입금", 1000);
  }

  @Test
  void equals() {
    Transaction transaction1 = new Transaction("입금", 1000);
    Transaction transaction2 = new Transaction("입금", 1000);

    assertEquals(transaction1, transaction2);
  }

  @Test
  void string() {
    Transaction transaction = new Transaction("입금", 1000);

    assertEquals("(Transaction) 입금: 1000", transaction.toString());
  }

  @Test
  void process() {
    assertEquals(1000, new Transaction("잔액", 1000).process(0));

    assertEquals(2000, new Transaction("입금", 2000).process(0));
    assertEquals(3000, new Transaction("입금", 2000).process(1000));

    assertEquals(2500, new Transaction("출금", 500).process(3000));

    assertEquals(3000, new Transaction("메롱", 3000000).process(3000));
  }
}