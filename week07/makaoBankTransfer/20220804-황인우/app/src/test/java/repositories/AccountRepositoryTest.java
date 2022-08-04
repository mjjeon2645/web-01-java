package repositories;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void find() {
    AccountRepository accountRepository = new AccountRepository();

    Account found = accountRepository.find("110");

    assertEquals("110", found.identifier());
    assertEquals("신태일", found.name());
    assertEquals(2000, found.amount());
  }

  @Test
  void notFound() {
    AccountRepository accountRepository = new AccountRepository();

    Account found = accountRepository.find("512342341");

    assertNull(found);
  }
}
