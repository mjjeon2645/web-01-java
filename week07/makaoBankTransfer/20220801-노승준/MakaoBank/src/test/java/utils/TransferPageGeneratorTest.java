package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {
  @Test
  void form() {
    Account account = new Account("1234", "ashal", 3000);
    TransferPageGenerator transferPageGenerator = new TransferPageGenerator(account);

    String html = transferPageGenerator.html();
    assertTrue(html.contains("잔액: 3000원"), "잔액 문제");
    assertTrue(html.contains("보낼 계좌: <input"), "계좌 문제");
    assertTrue(html.contains("보낼 금액: <input"), "금액 문제");
    assertTrue(html.contains("<button type=\"submit\">확인</button>"), "버튼확인 문제" + html);
  }
}
