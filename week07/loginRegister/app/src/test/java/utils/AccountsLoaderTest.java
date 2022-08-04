package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AccountsLoaderTest {
  @Test
  void parse() {
    AccountsLoader accountsLoader = new AccountsLoader();

    String line = "전민지,mjjeon2645,1234,angel2645@naver.com";

    Account account = accountsLoader.parse(line);

    assertEquals(account, new Account("전민지", "mjjeon2645", "1234", "angel2645@naver.com"));
  }

  @Test
  void load() throws FileNotFoundException {
    AccountsLoader accountsLoader = new AccountsLoader();

    Map<String, Account> accounts = accountsLoader.load();

    assertEquals(new Account("전민지", "mjjeon2645", "1234", "angel2645@naver.com"),
        accounts.get("mjjeon2645"));
    assertEquals(new Account("공유", "gongyoo", "1234", "gongyoo@naver.com"),
        accounts.get("gongyoo"));

    assertEquals("이정재", accounts.get("ljj").name());
    assertEquals("ljj", accounts.get("ljj").id());
  }
}
