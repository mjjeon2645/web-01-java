import models.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MakaoBankTest {
  @Test
  void notNull() throws FileNotFoundException {
    MakaoBank makaoBank = new MakaoBank();
    List<Transaction> transactions = makaoBank.loadTransactions();

    assertNotNull(makaoBank.loadTransactions());
  }

  @Test
  void loadTransactions() throws FileNotFoundException {
    MakaoBank makaoBank = new MakaoBank();
    List<Transaction> transactions = makaoBank.loadTransactions();
    Transaction transaction1 = new Transaction("잔액",1000);
    Transaction transaction2 = new Transaction("입금",1000);

    assertEquals(5, transactions.size());
    assertEquals(transaction1,transactions.get(0));
    assertEquals(transaction2,transactions.get(1));

  }


}