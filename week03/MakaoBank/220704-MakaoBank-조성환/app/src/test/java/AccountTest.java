import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  Account account = new Account();
  @Test
  void amount() {
    assertEquals(1000, account.getAmount()) ;
  }
  @Test
  void transfer() {
    account.transfer(100);
    account.transfer(500);


    assertEquals(400, account.getAmount());
  }
  @Test
  void trnasactions() {


    account.transfer(100);
    account.transfer(500);


  }

}