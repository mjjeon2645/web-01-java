package models;

import org.junit.jupiter.api.Test;
import repositories.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("352-0528");
    Account receiver = accountRepository.find("179-20");
    long amount = 200;

    Transaction transaction = new Transaction(sender, receiver, amount);

    assertEquals(sender, transaction.sender());
    assertEquals(receiver, transaction.receiver());
    assertEquals(amount, transaction.amount());
  }

  @Test
  void command() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("352-0528");
    Account receiver = accountRepository.find("179-20");
    long amount = 200;

    Transaction transaction = new Transaction(sender, receiver, amount);

    assertEquals("송금", transaction.command(sender));
    assertEquals("입금", transaction.command(receiver));
  }

  @Test
  void other() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("352-0528");
    Account receiver = accountRepository.find("179-20");
    long amount = 200;

    Transaction transaction = new Transaction(sender, receiver, amount);

    assertEquals(receiver, transaction.other(sender));
    assertEquals(sender, transaction.other(receiver));
  }
}
