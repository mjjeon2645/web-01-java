package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import pages.PageGenerator;
import pages.TransferPageGenerator;

import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {
  @Test
  void form() {
    Account account = new Account("1234","2345", 3000);

    PageGenerator pageGenerator = new TransferPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("잔액: 3000원"), "잔액 문제" + html);
    assertTrue(html.contains("보낼 계좌: <input"), "계좌 입력 문제" + html);
    assertTrue(html.contains("보낼 금액: <input"), "금액 입력 문제" + html);
    assertTrue(html.contains("<button type=\"submit\">확인</button>"),
        "계좌 입력 문제" + html);
  }
}
