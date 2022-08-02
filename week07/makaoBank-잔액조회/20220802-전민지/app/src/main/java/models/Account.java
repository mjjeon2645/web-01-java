package models;

public class Account {
  private String identifier;
  private String name;
  private long amount;

  public Account(String identifier, String name, long amount) {
    this.identifier = identifier;
    this.name = name;
    this.amount = amount;
  }

  public String identifier() {
    return identifier;
  }

  public String name() {
    return name;
  }

  public long amount() {
    return amount;
  }

  //TODO. 받는 사람 처리도 필요해
  public void transfer(long amount) {
    this.amount -= amount;
  }
}
