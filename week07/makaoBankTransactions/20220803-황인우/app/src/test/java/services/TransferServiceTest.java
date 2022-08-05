package services;

import models.Account;
import org.junit.jupiter.api.Test;
import repositories.AccountRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransferServiceTest {
  @Test
  void Transfer() {
    AccountRepository accountRepository = new AccountRepository();

    Account account1 = accountRepository.find("110");
    Account account2 = accountRepository.find("179");

    TransferService transferService = new TransferService(accountRepository);

    assertEquals(10000, account1.amount());
    assertEquals(5000, account2.amount());

    transferService.transfer(account1.identifier(), account2.identifier(), 300);

    assertEquals(10000 - 300, account1.amount());
    assertEquals(5000 + 300, account2.amount());
  }
}
