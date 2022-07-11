import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
  @Test
  void creation() {
    Transaction transaction1 = new Transaction("잔액", 5000);
    Transaction transaction2 = new Transaction("잔액", 5000);

    assertEquals(transaction1, transaction2);
  }

  @Test
  void processBalance() {
    Transaction transaction = new Transaction("잔액", 5000);

    TransactionResult transactionResult = transaction.process(2000);

    TransactionResult expectedTransactionResult
        = new TransactionResult(new Transaction("잔액", 5000), 5000);

    assertEquals(expectedTransactionResult, transactionResult);
  }

  @Test
  void processTransfer() {
    Transaction transaction= new Transaction("출금", 2000);

    TransactionResult transactionResult= transaction.process(5000);

    TransactionResult expectedTransactionResult
        = new TransactionResult(new Transaction("출금", 2000), 3000);

    assertEquals(expectedTransactionResult, transactionResult);
  }

  @Test
  void processDeposit() {
    Transaction transaction= new Transaction("입금", 2500);

    TransactionResult transactionResult = transaction.process(5000);

    TransactionResult expectedTransactionResult
        = new TransactionResult(new Transaction("입금", 2500), 7500);

    assertEquals(expectedTransactionResult, transactionResult);
  }
}
