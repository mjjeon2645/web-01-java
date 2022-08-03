package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import pages.PageGenerator;
import pages.TransferPageGenerator;

import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {
  @Test
  void form() {
    Account account = new Account("1234", "Ashal", 3000);
    PageGenerator pageGenerator = new TransferPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(html.contains("<p>잔액: 3000원"), "잔액 문제" + html);
    assertTrue(html.contains("<p>보낼 계좌: <input"), "보낼 게좌 문제" + html);
    assertTrue(html.contains("<p>보낼 금액: <input"), "보낼 금액 문제" + html);
    assertTrue(html.contains("확인</button>"), "확인 버튼 문제" + html);
  }
}
