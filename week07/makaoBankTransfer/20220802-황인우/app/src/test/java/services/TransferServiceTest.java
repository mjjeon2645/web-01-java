package services;

import Repositories.AccountRepository;
import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {
  @Test
  void transfer() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("352");
    Account receiver = accountRepository.find("179");

    long oldSenderAmount = sender.amount();
    long oldReceiverAmount = receiver.amount();

    TransferService transferService = new TransferService(accountRepository);

    transferService.transfer(sender.identifier(), receiver.identifier(), 500);

    long newSenderAmount = sender.amount();
    long newReceiverAmount = receiver.amount();

    assertEquals(500, oldSenderAmount - newSenderAmount);
    assertEquals(500, newReceiverAmount - oldReceiverAmount);
  }
}
