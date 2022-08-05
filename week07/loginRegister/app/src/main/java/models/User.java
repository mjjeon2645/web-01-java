package models;

public class User {

  private String name;
  private String id;
  private String password;
  private String email;

  public User(String name, String id, String password, String email) {
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

  public String toCsvRow() {
    return String.join(",", name, id, password, email);
  }
}
