package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    Account sender = new Account("110", "한지우", 10000);
    Account receiver = new Account("179", "오바람", 5000);

    Transaction transaction = new Transaction(sender, receiver, 300);

    assertEquals(sender, transaction.sender());
    assertEquals(receiver, transaction.receiver());
    assertEquals(300, transaction.amount());
  }

  @Test
  void command() {
    Account sender = new Account("110", "한지우", 10000);
    Account receiver = new Account("179", "오바람", 5000);

    Transaction transaction = new Transaction(sender, receiver, 300);

    assertEquals("송금", transaction.command(sender));
    assertEquals("입금", transaction.command(receiver));
  }

  @Test
  void name() {
    Account sender = new Account("110", "한지우", 10000);
    Account receiver = new Account("179", "오바람", 5000);

    Transaction transaction = new Transaction(sender, receiver, 300);

    assertEquals("오바람", transaction.name(sender));
    assertEquals("한지우", transaction.name(receiver));
  }
}
