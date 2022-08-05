package repositories;

import models.User;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

  @Test
  void load() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();
    Map<String, User> users = userRepository.load();

    User user1 = new User("전민지", "mjjeon2645", "1234", "angel2645@naver.com");
    User user2 = new User("공유", "gongyoo", "1234", "gongyoo@naver.com");

    assertEquals(user1, users.get("mjjeon2645"));
    assertEquals(user2, users.get("gongyoo"));

    assertEquals("이정재", users.get("ljj").name());
    assertEquals("ljj", users.get("ljj").id());
  }

  @Test
  void parse() throws FileNotFoundException {
    UserRepository userRepository = new UserRepository();

    String line = "전민지,mjjeon2645,1234,angel2645@naver.com";

    User user = userRepository.parse(line);

    assertEquals(user, new User("전민지", "mjjeon2645", "1234", "angel2645@naver.com"));
  }

  @Test
  void find() throws FileNotFoundException {

    UserRepository userRepository = new UserRepository();

    User user = new User("전민지", "mjjeon2645", "1234", "angel2645@naver.com");

    assertEquals(user, userRepository.find("mjjeon2645"));
  }
}
