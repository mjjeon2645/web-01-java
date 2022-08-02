package pages;

import models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TransferSuccessGeneratorTest {
  @Test
  void successMessage() {
    Account account = new Account("1234", "ashal", 3000);
    PageGenerator pageGenerator = new TransferSuccessPageGenerator(account);
    String html = pageGenerator.html();
    assertTrue(html.contains("계좌이체 성공!"), "계좌 성공메세지" + html);
  }
}
