package repository;

import models.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void find() {
    AccountRepository accountRepository = new AccountRepository();
    Account account = accountRepository.find("1234");
    assertEquals("1234", account.identifier());
  }

  @Test
  void findWithBlank() {
    AccountRepository accountRepository = new AccountRepository();
    Account account = accountRepository.find("", "1234");
    assertEquals("1234", account.identifier());
  }
}
