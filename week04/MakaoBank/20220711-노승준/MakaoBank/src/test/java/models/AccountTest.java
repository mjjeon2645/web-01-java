package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void processWithoutTransaction() {
    Account account = new Account();

    assertEquals(List.of(), account.process(List.of()));
  }

  @Test
  void processOneTransaction() {
    Transaction transaction = new Transaction("잔액", 1000);
    TransactionResult transactionResult = new TransactionResult(transaction, 1000);

    Account account = new Account();

    List<Transaction> transactions = List.of(transaction);

    assertEquals(List.of(transactionResult), account.process(transactions));
  }

  @Test
  void processTwoTransaction() {
    List<Transaction> transactions = List.of(
        new Transaction("잔액", 1000),
        new Transaction("입금", 1000)
    );

    List<TransactionResult> transactionResult = List.of(
        new TransactionResult(transactions.get(0), 1000),
        new TransactionResult(transactions.get(1), 2000)
    );

    Account account = new Account();

    assertEquals(transactionResult, account.process(transactions));
  }

  @Test
  void processTransaction() {
    List<Transaction> transactions = List.of(
        new Transaction("잔액", 1000),
        new Transaction("입금", 1000),
        new Transaction("출금", 2000)
    );

    List<TransactionResult> transactionResult = List.of(
        new TransactionResult(transactions.get(0), 1000),
        new TransactionResult(transactions.get(1), 2000),
        new TransactionResult(transactions.get(2), 0)
    );

    Account account = new Account();

    assertEquals(transactionResult, account.process(transactions));
  }

}