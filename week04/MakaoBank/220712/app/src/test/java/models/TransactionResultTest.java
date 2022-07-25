//1. 거래내역을 들고 있게 한다.
//   -> 또는 거래내역을 *참조만하고 , 잔액만 들고 있는다. -> 선택
package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {

  @Test
  void creation() {
    Transaction transaction = new Transaction("입금", 100);

    int amount = 100 + 100;

    TransactionResult transactionResult =
        new TransactionResult(transaction, amount);

    assertArrayEquals(new String[]{"입금", "100", "1000"},
        transactionResult.values());
    ;


  }

  @Test
  void toCsv() {
    Transaction transaction = new Transaction("입금", 100);

    int amount = 1000;

    TransactionResult transactionResult =
        new TransactionResult(transaction, amount);

    assertEquals("입금,100,1000",
        transactionResult.toCsvRow());

  }
}
