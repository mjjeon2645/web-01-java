package models;

public class User {

  private String name;
  private String id;
  private String password;
  private String email;

  public User(String name, String id, String password, String email) {
    //TODO. 비밀번호 재확인을 위해 입력받은 값도 user에 포함될까?
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
    User otherUser = (User) other;
    return this.name().equals(otherUser.name())
        && this.id().equals(otherUser.id())
        && this.password().equals(otherUser.password())
        && this.email().equals(otherUser.email());
  }
}
