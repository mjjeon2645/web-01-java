package services;

import models.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {
  @Test
  void transfer() {
    List<Account> accounts = List.of(
        new Account("2345", "JOKER", 1000),
        new Account("1234", "Ashal", 3000)
    );

    Account sender = accounts.get(1);
    Account receiver = accounts.get(0);

    long oldSenderAmount = sender.amount();
    long oldReceiverAmount = receiver.amount();

    TransferService transferService = new TransferService(accounts);

    transferService.transfer("1234", "2345", 1000);

    long newSenderAmount = sender.amount();
    long newReceiverAmount = receiver.amount();

    assertEquals(1000, oldSenderAmount - newSenderAmount);
    assertEquals(1000, newReceiverAmount - oldReceiverAmount);
  }
}
