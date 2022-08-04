package services;

import models.Account;
import org.junit.jupiter.api.Test;
import repositories.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {
  @Test
  void transfer() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("110");
    Account receiver = accountRepository.find("179");

    TransferService transferService = new TransferService(accountRepository);

    long oldSenderAmount = sender.amount();
    long oldReceiverAmount = receiver.amount();

    assertEquals(2000, oldSenderAmount);
    assertEquals(500, oldReceiverAmount);

    transferService.transfer(
        sender.identifier(),
        receiver.identifier(),
        10);

    long newSenderAmount = sender.amount();
    long newReceiverAmount = receiver.amount();

    assertEquals(2000 - 10, newSenderAmount);
    assertEquals(500 + 10, newReceiverAmount);
  }
}
