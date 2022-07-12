package models;

import org.junit.jupiter.api.Test;

import javax.annotation.processing.AbstractProcessor;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

  @Test
  void processEmptyTransactions() {
    Account account = new Account();

    assertEquals(List.of(), account.process(List.of()));
  }

  @Test
  void processOneTransaction() {
    Transaction transaction = new Transaction("잔액", 1000);
    TransactionResult transactionResult
        = new TransactionResult(transaction, 1000);

    Account account = new Account();

    List<Transaction> transactions = List.of(transaction);

    assertEquals(List.of(transactionResult), account.process(transactions));
  }

  @Test
  void processTwoTransaction() {
    List<Transaction> transactions = List.of(
        new Transaction("잔액", 1000),
        new Transaction("입금", 2000),
        new Transaction("출금", 500)
    );
    List<TransactionResult> transactionResults = List.of(
        new TransactionResult(transactions.get(0), 1000),
        new TransactionResult(transactions.get(1), 3000),
        new TransactionResult(transactions.get(2), 2500)
    );

    Account account = new Account();


    assertEquals(transactionResults, account.process(transactions));
  }
}