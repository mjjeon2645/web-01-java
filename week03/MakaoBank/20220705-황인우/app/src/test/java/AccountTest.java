import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

  @Test
  void transactionsTest() {
    Account account = new Account();

    account.transfer(100);
    account.transfer(500);
    account.transfer(700);
    account.transfer(300);

    assertEquals(3400, account.amount());
  }

  @Test
  void transferTest() {
    Account account = new Account();

    account.transfer(100);
    account.transfer(500);
    account.transfer(700);
    account.transfer(300);

    List<String> transactions = account.transactions();

    assertEquals("송금: 100원", transactions.get(0));
    assertEquals("송금: 500원", transactions.get(1));
    assertEquals("송금: 700원", transactions.get(2));
    assertEquals("송금: 300원", transactions.get(3));
  }
}