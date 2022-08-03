package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountsLoaderTest {
  @Test
  void parse() {
    AccountsLoader usersLoader = new AccountsLoader();

    String line = "전민지,mjjeon2645,1234,angel2645@naver.com";

    Account user = usersLoader.parse(line);

    assertEquals(user, new Account("전민지", "mjjeon2645", "1234", "angel2645@naver.com"));
  }
}
