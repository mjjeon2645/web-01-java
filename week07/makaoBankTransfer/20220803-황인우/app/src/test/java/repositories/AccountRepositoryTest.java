package repositories;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void find() {
    AccountRepository accountRepository = new AccountRepository();

    Account account1 = accountRepository.find("179");

    assertEquals("179", account1.identifier());

    Account account2 = accountRepository.find("352");

    assertEquals("352", account2.identifier());
  }
}
