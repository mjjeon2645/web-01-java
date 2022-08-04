package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    Account sender = new Account("1234","ashal",3000);
    Account receiver = new Account("2345","joker",2000);

    sender.transfer(receiver,500);
    Transaction transaction = new Transaction(sender,receiver,500);
    assertEquals(sender, transaction.sender());
    assertEquals(receiver, transaction.receiver());
    assertEquals(1000, transaction.amount());
  }

  @Test
  void command() {
    Account sender = new Account("1234","ashal",3000);
    Account receiver = new Account("2345","joker",2000);

    sender.transfer(receiver,1000);
    Transaction transaction = new Transaction(sender,receiver,1000);
    receiver.transfer(sender,500);

  }

}