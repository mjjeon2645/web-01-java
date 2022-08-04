package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("1234", "ashal", 3000);

    assertEquals("1234", account.identifier());
    assertEquals("ashal", account.name());
    assertEquals(3000, account.amount());
  }

  @Test
  void transfer() {
    Account sender = new Account("1234", "ashal", 3000);
    Account receiver = new Account("2345", "joker", 2000);

    sender.transfer(receiver, 1000);
    Transaction transaction = new Transaction(sender,receiver,1000);
    assertEquals(2000, sender.amount());
    assertEquals(3000, receiver.amount());
  }

  @Test
  void count() {
    Account sender = new Account("1234","ashal",3000);
    Account receiver = new Account("2345","joker",2000);

    int oldSenderTransactionsCount = sender.transactions().size();
    int oldReceiverTransactionsCount = receiver.transactions().size();
    sender.transfer(receiver,500);

    int newSenderTransactionsCount = sender.transactions().size();
    int newReceiverTransactionsCount = receiver.transactions().size();

    assertEquals(1,newSenderTransactionsCount - oldSenderTransactionsCount);
    assertEquals(1,newReceiverTransactionsCount - oldReceiverTransactionsCount);
  }
}
