package repositories;

import models.Account;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void find() throws FileNotFoundException {

    AccountRepository accountRepository = new AccountRepository();

    Account account = new Account("전민지", "mjjeon2645", "1234", "angel2645@naver.com");

    assertEquals(account, accountRepository.find("mjjeon2645"));
  }
}
