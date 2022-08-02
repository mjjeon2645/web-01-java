package services;

import models.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {
  @Test
  void transfer() {
    List<Account> accounts = List.of(
        new Account("352", "치코리타", 10000),
        new Account("179", "파이리", 10000)
    );

    Account sender = accounts.get(0);
    Account receiver = accounts.get(1);

    long oldSenderAmount = sender.amount();
    long oldReceiverAmount = receiver.amount();

    TransferService transferService = new TransferService(accounts);

    transferService.transfer(sender.identifier(), receiver.identifier(), 500);

    long newSenderAmount = sender.amount();
    long newReceiverAmount = receiver.amount();

    assertEquals(500, oldSenderAmount - newSenderAmount);
    assertEquals(500, newReceiverAmount - oldReceiverAmount);
  }
}
