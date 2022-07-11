package models;

import org.junit.jupiter.api.Test;

import javax.annotation.processing.AbstractProcessor;
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
    Transaction transaction = new Transaction("잔액", 100);
    TransactionResult transactionResult = new TransactionResult(transaction, 100);

    Account account = new Account();

    List<Transaction> transactions = List.of(transaction);

    assertEquals(List.of(transactionResult), account.process(transactions));
  }

  @Test
  void processTwoTransactions() {
    List<Transaction> transactions = List.of(
        new Transaction("잔액", 100),
        new Transaction("입금", 200)
    );

    List<TransactionResult> transactionResults = List.of(
        new TransactionResult(transactions.get(0), 100),
        new TransactionResult(transactions.get(1), 100 + 200)
    );

    Account account = new Account();

    assertEquals(transactionResults, account.process(transactions));
  }
}
