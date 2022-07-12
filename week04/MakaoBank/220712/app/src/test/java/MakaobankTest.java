import models.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MakaobankTest {
  @Test
  void simple() {
    Makaobank makaobank = new Makaobank();

    List<Transaction> transactions = makaobank.loadTransactions();

    assertNotNull(transactions);

    assertEquals("잔액 1000원", transaction1);
  }

}