package repositories;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void find() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("352-0528");

    assertEquals("352-0528", account.identifier());
    assertEquals("Chikorita", account.name());
    assertEquals(10000, account.amount());
  }

  @Test
  void notFound() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("64872369822");

    assertNull(account);
  }
}
