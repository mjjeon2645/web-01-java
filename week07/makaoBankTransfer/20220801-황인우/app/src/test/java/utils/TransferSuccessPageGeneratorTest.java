package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferSuccessPageGeneratorTest {
  @Test
  void html() {
    Account account = new Account("352-0528", "Chikorita", 10000);

    PageGenerator pageGenerator = new TransferSuccessPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("계좌이체 성공!!!"), "html에 성공 메세지 없음\n" + html);
  }
}
