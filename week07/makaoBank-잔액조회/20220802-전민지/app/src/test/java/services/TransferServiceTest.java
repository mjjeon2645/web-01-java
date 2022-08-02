package services;

import models.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {
  @Test
  void transfer() {
    List<Account> accounts = List.of(
        new Account("1234", "Ashal", 3000),
        new Account("1234", "Ashal", 3000)
    );

    TransferService transferService = new TransferService(accounts);

    long oldAmount = account.amount();

    transferService.transfer("1234", "2345", 1000);

    long newAmount = account.amount();

    assertEquals(1000, oldAmount - newAmount);
  }
}
