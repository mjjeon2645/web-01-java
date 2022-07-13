import models.Transaction;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MakaoBankTest {
  @Test
  void loadTransaction() throws FileNotFoundException {
    MakaoBank makaoBank = new MakaoBank();

    List<Transaction> transactions = makaoBank.loadTransactions();

    assertNotNull(transactions);

    Transaction transaction = new Transaction("잔액", 1000);

    assertEquals(transaction, transactions.get(0));
  }

  @Test
  void parseTransaction() {
    MakaoBank makaoBank = new MakaoBank();

    Transaction transaction = makaoBank.parseTransaction("잔액,1000");

    assertEquals(new Transaction("잔액", 1000), transaction);
  }

  @Test
  void processWithCases() throws FileNotFoundException {
    MakaoBank makaoBank = new MakaoBank();

    List<Transaction> transactions = makaoBank.loadTransactions();

    Transaction transaction1 = new Transaction("잔액", 1000);
    Transaction transaction2 = new Transaction("입금", 2000);

    assertEquals(transaction1, transactions.get(0));
    assertEquals(transaction2, transactions.get(1));

    assertEquals(5, transactions.size());
  }
}
