import models.Transaction;
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

    Transaction transaction = transactions.get(0);
    Transaction transaction2 = transactions.get(1);
    // 이렇게 할 수는 없다 할수는 있지만 이상하다
    assertEquals(new Transaction("잔액", 1000) , transaction);
    assertEquals(new Transaction("입금", 2000) , transaction2);
  }

}