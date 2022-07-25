package models;

public class Transaction {
  private final String type;
  private final int amount;

  public Transaction(String type, int amount) {
    this.type = type;
    this.amount = amount;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other){
    //형변환 other의 타입이 Object에서 Transaction으로 바뀜
    // otherTransaction의 타입과 amount가 같으면 같다고 처리해준다.!
    Transaction otherTransaction = (Transaction) other;
    return this.type.equals(otherTransaction.type) &&
            this.amount == otherTransaction.amount;
  }
  @Override
  public String toString() {
    return "Transaction(" + type + ": " + amount + ")";
  }

  public String type() {
    return type;
  }
  // int를 객체로 만들어준다.
  public Integer amount() {
    return amount;
  }

  public int process(int amount) {
    if(type.equals("잔액")){
      return this.amount;
    }
    if(type.equals("입금")){
      return this.amount + amount;
    }
    if(type.equals("출금")){
      return amount - this.amount;
    }
    return amount;
  }
}
