package pages;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {
  @Test
  void content() {
    Account account = new Account("110", "신태일", 3000);

    PageGenerator pageGenerator = new TransferPageGenerator(account);

    String content = pageGenerator.content();

    assertTrue(
        content.contains("잔액: 3000원"),
        "잔액 안내 문제\n" + content);
    assertTrue(
        content.contains("보낼 계좌: <input"),
        "보낼 계좌 입력창 문제\n" + content);
    assertTrue(
        content.contains("보낼 금액: <input"),
        "보낼 금액 입력창 문제\n" + content);
    assertTrue(
        content.contains("확인</button>"),
        "확인 버튼 문제\n" + content);
  }
}
