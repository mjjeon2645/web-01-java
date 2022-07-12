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
      new Transaction("잔액, 2000"),
        잔액,3000
        입금,500
        출금,1200
        입금,700
        출금,2500
        입금,100

    );

    assertEquals(otherTransactions, transactions);
  }

  @Test
  void parseTransaction() {

  }
}