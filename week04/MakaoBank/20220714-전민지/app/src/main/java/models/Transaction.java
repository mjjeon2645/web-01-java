// 1. 거래정보 만들기
// 2. 비교 -> 타입, 금액
// 3. 잔액을 변경??
// 4. 변경내용 도출
package models;

import java.util.Objects;

public class Transaction {
  private String type;
  private int amount;

  public Transaction(String type, int amount) {
    this.type = type;
    this.amount = amount;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    Transaction otherTransaction = (Transaction) other;
    return Objects.equals(this.type, otherTransaction.type)
        && this.amount == otherTransaction.amount;
  }

  @Override
  public String toString() {
    return "Transaction(" + type + ": " + amount +")";
  }

  public String type() {
    return type;
  }

  public Integer amount() {
    return amount;
  }

  public int process(int amount) {
    if (type.equals("잔액")) {
      return this.amount;
    }

    if (type.equals("입금")) {
      return amount + this.amount;
    }

    if (type.equals("출금")) {
      return amount - this.amount;
    }
    return amount;
  }
}
