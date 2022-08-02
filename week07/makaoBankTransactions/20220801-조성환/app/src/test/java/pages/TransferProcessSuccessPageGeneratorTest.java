package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import pages.PageGenerator;
import pages.TransferProcessSuccessPageGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TransferProcessSuccessPageGeneratorTest {
  @Test
  void message() {
    Account account = new Account("1234", "2345", 3000);

    PageGenerator pageGenerator = new TransferProcessSuccessPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("계좌 이체 성공!"), "메시지 문제 " + html);
  }
}
