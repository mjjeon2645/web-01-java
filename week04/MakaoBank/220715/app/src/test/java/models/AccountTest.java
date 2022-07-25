package models;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account();

    assertEquals(List.of(),account.process(List.of()));
  }

  @Test
  void processWithOneTransaction() {
    Account account = new Account();
    Transaction transaction = new Transaction("잔액",1000);
    List<Transaction> transactions = List.of(
        transaction
    );
    TransactionResult transactionResult =
        new TransactionResult(transaction,1000);

    assertEquals(List.of(transactionResult),account.process(transactions));
  }

  @Test
  void processTransactions() {
    Account account = new Account();
    List<Transaction> transactions = List.of(
        new Transaction("잔액",1000),
        new Transaction("입금",1000),
        new Transaction("출금",500)
    );
    List<TransactionResult> transactionResults = List.of(
        new TransactionResult(transactions.get(0),1000),
        new TransactionResult(transactions.get(1),2000),
        new TransactionResult(transactions.get(2),1500)
    );
    assertEquals(transactionResults,account.process(transactions));
  }

}