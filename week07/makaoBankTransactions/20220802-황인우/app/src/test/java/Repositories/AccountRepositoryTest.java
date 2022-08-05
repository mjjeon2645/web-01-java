package Repositories;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void find() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("352");

    assertEquals("352", account.identifier());
    assertEquals("치코리타", account.name());
    assertEquals(10000, account.amount());
  }
}
