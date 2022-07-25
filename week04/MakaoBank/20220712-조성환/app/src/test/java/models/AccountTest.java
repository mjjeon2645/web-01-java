package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account();

    assertEquals(List.of(), account.process(List.of()));
  }

  @Test
  void processOneTransaction() {
    Transaction transaction = new Transaction("잔액", 1000);
    TransactionResult transactionResult = new TransactionResult(transaction, 1000);

    List<Transaction> transactions = List.of(transaction);

    Account account = new Account();

    assertEquals(List.of(transactionResult), account.process(transactions));
  }

  @Test
  void processTwoTransaction() {
    List<Transaction> transactions = List.of(
        new Transaction("잔액", 100),
        new Transaction("입금", 200),
        new Transaction("출금", 200)
    );
    List<TransactionResult> transactionResults = List.of(
        new TransactionResult(transactions.get(0), 100),
        new TransactionResult(transactions.get(1), 100 + 200),
        new TransactionResult(transactions.get(2), 100 - 200)
    );
    Account account = new Account();

    assertEquals(transactionResults, account.process(transactions));
  }
}
