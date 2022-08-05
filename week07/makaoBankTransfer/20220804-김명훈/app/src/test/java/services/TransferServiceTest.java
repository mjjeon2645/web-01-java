package services;

import models.*;
import org.junit.jupiter.api.*;
import repository.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {
  @Test
  void creation() {
    AccountRepository accountRepository = new AccountRepository();
    TransferService transferService = new TransferService(accountRepository);

    transferService.transfer("1234", "2345", 1000);
    Account account = accountRepository.find("1234");
    assertEquals(2000, account.amount());
  }
}
