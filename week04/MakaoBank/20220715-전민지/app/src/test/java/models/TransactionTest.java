// transaction의 역할 정의
// 1. 거래정보 보유
// 2. 거래내역의 비교(송금/출금과 같은 타입, 금액 등)
// 3. 거래내역에 따른 금액 변화?
// 4. 거래결과 도출

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
    assertEquals(1000, new Transaction("잔액", 1000).process(0));
    assertEquals(1000, new Transaction("잔액", 1000).process(100));

    assertEquals(2000, new Transaction("입금", 2000).process(0));
    assertEquals(2100, new Transaction("입금", 2000).process(100));

    assertEquals(800, new Transaction("출금", 200).process(1000));

    assertEquals(1000, new Transaction("오류", 200).process(1000));
  }
}
