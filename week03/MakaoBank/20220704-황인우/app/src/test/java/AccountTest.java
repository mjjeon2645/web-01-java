import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

  @Test
  void transferTest() {
    Account account = new Account();

    account.transfer(300);

    assertEquals(4700, account.amount());
  }

  @Test
  void transactionsTest() {
    Account account = new Account();

    account.transfer(300);
    account.transfer(1000);

    List<String> transactions = account.transactions();

    assertEquals("송금: 300원", transactions.get(0));
    assertEquals("송금: 1000원", transactions.get(1));
  }
}