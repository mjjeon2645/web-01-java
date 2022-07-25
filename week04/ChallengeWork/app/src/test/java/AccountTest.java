import models.Account;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AccountTest {
  @Test
  void creation() {
    List<String> transactions = new ArrayList<>();
    Account account =new Account("123-456", 3000, transactions);
  }
  @Test
  void transfer() {
    List<String> transactions = new ArrayList<>();
    Account account =new Account("123-456", 3000, transactions);
    Account otherAccount = new Account("123-456",1000,transactions);
    //account.transfer();
  }
}
