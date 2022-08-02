package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    Account sender = new Account("110", "구구", 1000);
    Account receiver = new Account("305", "밀탱크", 3000);

    Transaction transaction = new Transaction(sender, receiver, 100);

    assertEquals(sender, transaction.sender());
    assertEquals(receiver, transaction.receiver());
    assertEquals(100, transaction.amount());
  }

  @Test
  void command() {
    Account sender = new Account("110", "구구", 1000);
    Account receiver = new Account("305", "밀탱크", 3000);

    Transaction transaction = new Transaction(sender, receiver, 100);

    assertEquals("송금", transaction.command(sender));
    assertEquals("입금", transaction.command(receiver));
  }

  @Test
  void other() {
    Account sender = new Account("110", "구구", 1000);
    Account receiver = new Account("305", "밀탱크", 3000);

    Transaction transaction = new Transaction(sender, receiver, 100);

    assertEquals(receiver, transaction.other(sender));
    assertEquals(sender, transaction.other(receiver));
  }
}
