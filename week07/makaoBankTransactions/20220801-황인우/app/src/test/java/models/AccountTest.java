package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("352-0528", "Chikorita", 10000);

    assertEquals("352-0528", account.identifier());
    assertEquals("Chikorita", account.name());
    assertEquals(10000, account.amount());
  }

  @Test
  void transfer() {
    Account sender = new Account("352-0528", "Chikorita", 10000);
    Account receiver = new Account("179-20", "Eevee", 5000);

    int oldSenderTransactionsCount = sender.transactionsCount();
    int oldReceiverTransactionsCount = receiver.transactionsCount();

    sender.transfer(receiver, 2000);

    assertEquals(8000, sender.amount());
    assertEquals(7000, receiver.amount());

    int newSenderTransactionsCount = sender.transactionsCount();
    int newReceiverTransactionsCount = receiver.transactionsCount();

    assertEquals(1, newSenderTransactionsCount - oldSenderTransactionsCount);
    assertEquals(1, newReceiverTransactionsCount - oldReceiverTransactionsCount);
  }

  @Test
  void transferError() {
    Account sender = new Account("352-0528", "Chikorita", 10000);
    Account receiver = new Account("179-20", "Eevee", 5000);

    sender.transfer(receiver, -2000);

    assertEquals(10000, sender.amount());
    assertEquals(5000, receiver.amount());
  }

  @Test
  void transactions() {
    Account sender = new Account("352-0528", "Chikorita", 10000);
    Account receiver = new Account("179-20", "Eevee", 5000);

    sender.transfer(receiver, 2000);

    assertEquals(1, sender.transactions().size());
    assertEquals(1, receiver.transactions().size());
  }

  @Test
  void equals() {
    Account account1 = new Account("352-0528", "Chikorita", 10000);
    Account account2 = new Account("352-0528", "Chikorita", 10000);

    assertEquals(account1, account2);
  }
}
