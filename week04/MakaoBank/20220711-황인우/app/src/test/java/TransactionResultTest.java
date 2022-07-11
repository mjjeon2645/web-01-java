import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {
  @Test
  void creation() {
    TransactionResult transactionResult1
        = new TransactionResult(new Transaction("잔액", 5000), 5000);
    TransactionResult transactionResult2
        = new TransactionResult(new Transaction("잔액", 5000), 5000);

    assertEquals(transactionResult1, transactionResult2);
  }
}