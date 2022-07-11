// transaction이 무엇을 할 수 있을지를 생각해보자
// 1. 거래 내역을 만들 수 있어야 함 -> 완료
// 2. 거래내역에 대한 비교(입금인지, 잔액인지, 출금인지)
// 3. 금액을 여기서 관리해줄 것인지? 금액 변경?
// 4. 잔액을 변하게 한 결과를 도출 -> transactionsresults와도 관련있는거 아닌가?

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
}
