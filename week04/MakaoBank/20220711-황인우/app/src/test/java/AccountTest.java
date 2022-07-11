import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

  @Test
  void process() {
    Account account = new Account();

    List<Transaction> transactions = List.of(
        new Transaction("잔액", 5000),
        new Transaction("입금", 500),
        new Transaction("출금", 1500),
        new Transaction("출금", 2000)
    );

    List<TransactionResult> transactionResults = account.process(transactions);

    assertNotNull(transactionResults);

    List<TransactionResult> expectedTransactionResults = List.of(
        new TransactionResult(new Transaction("잔액", 5000), 5000),
        new TransactionResult(new Transaction("입금", 500), 5500),
        new TransactionResult(new Transaction("출금", 1500), 4000),
        new TransactionResult(new Transaction("출금", 2000), 2000)
    );

    for (int i = 0; i < expectedTransactionResults.size(); i += 1) {
      assertEquals(expectedTransactionResults.get(i), transactionResults.get(i));
    }
  }
}