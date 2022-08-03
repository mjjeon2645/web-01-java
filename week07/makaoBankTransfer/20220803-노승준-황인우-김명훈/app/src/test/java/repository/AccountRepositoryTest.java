package repository;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void find() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("1234");

    assertEquals("1234", account.identifier());
  }

  @Test
  void notFound() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("232347563495");

    assertNull(account);
  }
}
