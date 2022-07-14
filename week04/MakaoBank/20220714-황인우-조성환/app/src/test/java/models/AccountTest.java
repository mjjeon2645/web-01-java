package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void process() {
    Account account = new Account();

    List<Transaction> transactions = List.of();

    List<TransactionResult> transactionResults = account.process(transactions);

    assertNotNull(transactionResults);
  }

  @Test
  void processOneTransaction() {
    Account account = new Account();

    Transaction transaction = new Transaction("잔액", 1000);

    List<Transaction> transactions = List.of(transaction);

    TransactionResult transactionResult = new TransactionResult(transaction, 1000);

    assertEquals(List.of(transactionResult), account.process(transactions));
  }

  @Test
  void processTransactions() {
    Account account = new Account();

    List<Transaction> transactions = List.of(
        new Transaction("잔액", 1000),
        new Transaction("입금", 100),
        new Transaction("출금", 1100)
    );

    List<TransactionResult> transactionResults = List.of(
        new TransactionResult(transactions.get(0), 1000),
        new TransactionResult(transactions.get(1), 1100),
        new TransactionResult(transactions.get(2), 0)
    );

    assertEquals(transactionResults, account.process(transactions));
  }
}
