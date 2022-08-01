package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import pages.PageGenerator;
import pages.TransferSucessPageGenerator;

import static org.junit.jupiter.api.Assertions.*;

class TransferSucessPageGeneratorTest {
  @Test
  void message() {
    Account account = new Account("1234", "ashal", 3000);
    PageGenerator pageGenerator = new TransferSucessPageGenerator(account);

    String html = pageGenerator.html();
    assertTrue(html.contains("계좌 이체 성공!"));
  }
}
