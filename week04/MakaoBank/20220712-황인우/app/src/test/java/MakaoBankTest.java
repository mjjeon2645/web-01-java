import models.Transaction;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MakaoBankTest {
  @Test
  void loadTransactions() throws FileNotFoundException {
    MakaoBank application = new MakaoBank();

    List<Transaction> transactions = application.loadTransactions();

    assertNotNull(transactions);

    List<Transaction> otherTransactions = List.of(
        new Transaction("잔액", 3000),
        new Transaction("입금", 500),
        new Transaction("출금", 1200),
        new Transaction("입금", 700),
        new Transaction("출금", 2500),
        new Transaction("입금", 100)
    );

    for (int i = 0; i < transactions.size(); i += 1) {
      assertEquals(transactions.get(i), otherTransactions.get(i));
    }
  }

  @Test
  void parseTransaction() {
    MakaoBank application = new MakaoBank();

    Transaction transaction = application.parseTransaction("잔액,30000000");

    assertEquals(new Transaction("잔액", 30000000), transaction);
  }
}
