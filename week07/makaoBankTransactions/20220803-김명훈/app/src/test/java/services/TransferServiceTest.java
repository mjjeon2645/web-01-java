package services;

import models.*;
import org.junit.jupiter.api.*;
import repository.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {
  @Test
  void transfer() {
    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);
    transferService.transfer("1234", "2345", 1000);

    Account sender = accountRepository.find("1234");
    Account receiver = accountRepository.find("2345");
    assertEquals(2000, sender.amount());
    assertEquals(2000, receiver.amount());
  }
}
