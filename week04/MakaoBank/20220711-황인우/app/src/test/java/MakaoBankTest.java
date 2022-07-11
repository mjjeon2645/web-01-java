import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MakaoBankTest {
  @Test
  void loadTransactions() throws FileNotFoundException {
    MakaoBank makaoBank = new MakaoBank();

    List<Transaction> transactions = makaoBank.loadTransactions();

    assertNotNull(transactions);

    List<Transaction> expectedTransactions = List.of(
        new Transaction("잔액", 5000),
        new Transaction("입금", 500),
        new Transaction("출금", 1500),
        new Transaction("출금", 2000)
    );

    for (int i = 0; i < expectedTransactions.size(); i += 1) {
      assertEquals(expectedTransactions.get(i), transactions.get(i));
    }
  }
}
