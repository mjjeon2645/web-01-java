package pages;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {
  @Test
  void html() {
    Account account = new Account("352", "치코리타", 10000);

    PageGenerator pageGenerator = new TransferPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("잔액: 10000원"), "잔액 문제\n" + html);
    assertTrue(html.contains("<p>보낼 계좌: <input"), "보낼 계좌 문제\n" + html);
    assertTrue(html.contains("<p>보낼 금액: <input"), "보낼 금액 문제\n" + html);
    assertTrue(html.contains("<button type=\"submit\">확인</button"), "확인 문제\n" + html);
  }
}
