package models;

import org.junit.jupiter.api.Test;
import repositories.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("1234");
    Account receiver = accountRepository.find("2345");

    long amount = 1000;

    Transaction transaction = new Transaction(sender, receiver, amount);

    assertEquals(sender, transaction.sender());
    assertEquals(receiver, transaction.receiver());
    assertEquals(1000, transaction.amount());
  }

  @Test
  void command() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("1234");
    Account receiver = accountRepository.find("2345");

    Transaction transaction = new Transaction(sender, receiver, 500);
    assertEquals("송금", transaction.command(sender));
    assertEquals("입금", transaction.command(receiver));
  }

  @Test
  void other() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("1234");
    Account receiver = accountRepository.find("2345");

    Transaction transaction = new Transaction(sender, receiver, 500);

    assertEquals(sender, transaction.other(receiver));
    assertEquals(receiver, transaction.other(sender));
  }
}
