package services;

import models.Account;
import org.junit.jupiter.api.Test;
import repositories.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {

  @Test
  void transfer() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("352-0528");
    Account receiver = accountRepository.find("179-20");

    TransferService transferService = new TransferService(accountRepository);

    long oldSenderAmount = sender.amount();
    long oldReceiverAmount = receiver.amount();

    transferService.transfer(sender.identifier(), receiver.identifier(), 2000);

    long newSenderAmount = sender.amount();
    long newReceiverAmount = receiver.amount();

    assertEquals(2000, oldSenderAmount - newSenderAmount);
    assertEquals(2000, newReceiverAmount - oldReceiverAmount);
  }
}
