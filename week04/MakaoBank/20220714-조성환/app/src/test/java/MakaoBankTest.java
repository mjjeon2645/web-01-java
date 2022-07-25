import models.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MakaoBankTest {
  @Test
  void loadTransaction() {
    MakaoBank makaoBank = new MakaoBank();

    List<Transaction> transactions = makaoBank.loadTransaction();

    assertNotNull(transactions);

    Transaction transaction1 = transactions.get(0);
    Transaction transaction2 = transactions.get(1);
    //거래내역을 비교할 수있게 만들어줘야한다.
    assertEquals(new Transaction("잔액",1000), transaction1);
  }

}