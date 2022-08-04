package models;

public class Account {

  private String name;
  private String id;
  private String password;
  private String email;

  public Account(String name, String id, String password, String email) {
    this.name = name;
    this.id = id;
    this.password = password;
    this.email = email;
  }

  public String name() {
    return name;
  }

  public String id() {
  return id;
  }

  public String password() {
    return password;
  }

  public String email() {
    return email;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    Account otherAccount = (Account) other;
    return this.name().equals(otherAccount.name())
        && this.id().equals(otherAccount.id())
        && this.password().equals(otherAccount.password())
        && this.email().equals(otherAccount.email());
  }

  public String toCsvRow() {
    return String.join(",", name, id, password, email);
  }
}
