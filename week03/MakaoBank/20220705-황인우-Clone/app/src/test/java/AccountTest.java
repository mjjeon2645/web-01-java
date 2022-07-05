import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
  @Test
  void transferTest() {
    Account account = new Account();

    account.transfer(100);

    assertEquals(4900, account.getAmount());

    account.transfer(50);

    assertEquals(4850, account.getAmount());
  }

  @Test
  void getTransactionsTest() {
    Account account = new Account();

    account.transfer(100);
    account.transfer(50);

    List<String> transactions = account.getTransactions();

    assertEquals("송금: 100원", transactions.get(0));
    assertEquals("송금: 50원", transactions.get(1));
  }
}
