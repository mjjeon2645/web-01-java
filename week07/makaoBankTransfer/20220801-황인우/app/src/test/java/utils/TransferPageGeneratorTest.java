package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {
  @Test
  void html() {
    Account account = new Account("352-0528", "Chikorita", 10000);

    PageGenerator pageGenerator = new TransferPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(
        html.contains("잔액: 10000원"), "html 내용에 잔액 표시 없음\n" + html
    );
    assertTrue(
        html.contains("보낼 계좌: <input"), "html 내용에 보낼 게좌 입력창 없음\n" + html
    );
    assertTrue(
        html.contains("보낼 금액: <input"), "html 내용에 보낼 금액 입력창 없음\n" + html
    );
    assertTrue(
        html.contains("<button"), "html 내용에 송금 버튼 없음\n" + html
    );
  }
}
