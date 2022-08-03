package utils;

import models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersLoaderTest {
  @Test
  void parse() {
    UsersLoader usersLoader = new UsersLoader();

    String line = "전민지,mjjeon2645,1234,angel2645@naver.com";

    User user = usersLoader.parse(line);

    assertEquals(user, new User("전민지", "mjjeon2645", "1234", "angel2645@naver.com"));
  }
}
