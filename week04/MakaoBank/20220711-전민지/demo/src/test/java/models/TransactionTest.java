// 1. 거래 정보 만들기 -> 완료!
// 2. 타입 비교(입금, 송금, 출금 등) -> 비교 가능하게 만듦. 일단 완료는 했는데 깨졌을 때 알아볼수가 없음.
// 3. 잔액을 변동시켜야 하긴 하는데... 여기서?
// 4. 잔액 변동시킨 결과 도출

package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
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

    assertEquals("Transaction(입금: 1000)", transaction.toString());
  }

  @Test
  void process() {
    int amount = new Transaction("잔액", 1000).process(0);

    assertEquals(1000, new Transaction("잔액", 1000).process(0));
    assertEquals(1000, new Transaction("잔액", 1000).process(100));
  }
}
