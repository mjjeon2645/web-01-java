package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
  @Test
  void creation() {
    User user = new User("전민지", "mjjeon2645", "1234", "angel2645@naver.com");

    assertEquals("전민지", user.name());
    assertEquals("mjjeon2645", user.id());
    assertEquals("1234", user.password());
    assertEquals("angel2645@naver.com", user.email());
  }

  @Test
  void equals() {
    User user = new User("전민지", "mjjeon2645", "1234", "angel2645@naver.com");

    assertEquals(user, new User("전민지", "mjjeon2645", "1234", "angel2645@naver.com"));
  }
}
