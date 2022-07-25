package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void process() {
    Account account = new Account();

    List<Transaction> transactions = List.of(
        new Transaction("잔액", 3000),
        new Transaction("입금", 500),
        new Transaction("출금", 1200),
        new Transaction("입금", 700),
        new Transaction("출금", 2500),
        new Transaction("입금", 100)
    );

    List<TransactionResult> transactionResults = account.process(transactions);

    assertNotNull(transactionResults);

    List<TransactionResult> otherTransactionResults = List.of(
        new TransactionResult(new Transaction("잔액", 3000), 3000),
        new TransactionResult(new Transaction("입금", 500), 3500),
        new TransactionResult(new Transaction("출금", 1200), 2300),
        new TransactionResult(new Transaction("입금", 700), 3000),
        new TransactionResult(new Transaction("출금", 2500), 500),
        new TransactionResult(new Transaction("입금", 100), 600)
    );

    for (int i = 0; i < transactionResults.size(); i += 1) {
      assertEquals(otherTransactionResults.get(i), transactionResults.get(i));
    }
  }
}
