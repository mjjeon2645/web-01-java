// 트랜잭션의 역할 / 상태?
// 1. 거래정보 - done
// 2. type, amount 비교 -done , tostring - done
// 3. 거래금액 변동??
// 4. 처리 -> 결과물 도출할것?

package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    Transaction transaction = new Transaction("잔액", 1000);
  }

  @Test
  void compare() {
    Transaction transaction = new Transaction("janack",100);

    assertEquals(new Transaction("janack",100),transaction);
  }

  @Test
  void string() {
    Transaction transaction = new Transaction("janack",100);

    assertEquals("Transaction(janack: 100)",transaction.toString());
  }
}
