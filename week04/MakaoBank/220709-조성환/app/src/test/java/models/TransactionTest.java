// 거래 정보 만들기 clear
// 거래 정보 비교하기 ? 거래 정보를 왜 비교하는 거지? 타입이나 amount에 따라서 결과를 다르게 하기 위해서?
// 객체끼리의 값을 비교하기 위해서  테스트 결과에서 내용이 잘 보이면 좋겠다. 통과
// 잔액 변동?
// 잔액 변하게 한 결과 도출?

//  toString -> 익 객체의 정보를 내가 원하는 문자열로 출력할 수 있다.

// 동일성 == ( 둘이 같은 객체다) 프리미티브 타입은 값이 같다
// 동등 실제로 객체가 같은게 아니라 값이 같은 경우는 euqlas를 사용한다. (둘이 같다고 취급을 하고 싶다 ->
// 객체를 값으로 취급 ( 값 객체 Vaule Object)
package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    // 입금 출금 금액이 필요하기 때문에 매개변수로 타입과 어마운트를 넣어준다.
    Transaction transaction = new Transaction("입금", 1000);
  }
  // 거래 정보를 왜 비교하지? 테스트 코드에서 값을 알아보기 위해서?

  @Test
  void equals() {
    // 이게 다른 이유는 객체를 인스턴스 할떄 메모리에 데이터의 주소값을 할당해주는데
    // equals는 주소값을 비교 하기 때문에 테스트결과가 다르게 나옴 같게 해주려면
    // equals메소드를 override를 해줘야 한다.
    // 내가 만들어준 method만 override를 해줄 수 있는 줄알았는데 이번 경우는 라이브러리에있는
    // equals메소드를 재정의를 해준다. 오버라이딩은 부모클래스에 있는 메소드를 자식클래스에서
    // 재정의를 해주는 역할이여서 상속도 안받고 equals라는 메소드를 안만들어 줬는데 어떻게 override를 해주는 건지 궁금
    // 했는데 이런 이유 떄문이구나 객체끼리 논리적으로 맞다고 우리가 생각하기 떄문에 실제로 컴퓨터는 다르다고 처리를 하지만
    // 재정의를 해준다.
    Transaction transaction = new Transaction("입금", 1000);
    Transaction transaction2 = new Transaction("입금", 1000);

    assertEquals(transaction, transaction2);
  }
  @Test
  void string() {
    Transaction transaction = new Transaction("입금", 1000);

    assertEquals("Transaction(입금: 1000)", transaction.toString());
  }

  @Test
  void process() {
    assertEquals(1000, new Transaction("잔액", 1000).process(0));
    assertEquals(1000, new Transaction("잔액", 1000).process(100));

    assertEquals(1000, new Transaction("입금", 1000).process(0));
    assertEquals(1100, new Transaction("입금", 1000).process(100));

    assertEquals(900, new Transaction("출금", 100).process(1000));

    assertEquals(1000, new Transaction("오류", 100).process(1000));
  }
}