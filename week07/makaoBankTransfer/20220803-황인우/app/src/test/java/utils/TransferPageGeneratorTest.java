package utils;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {

  @Test
  void html() {
    Account account = new Account("110", "레드", 10000);

    PageGenerator pageGenerator = new TransferPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(
        html.contains("잔액: 10000원"),
        "html에 잔액 안내 메세지 없음\n" + html);
    assertTrue(
        html.contains("보낼 계좌: <input"),
        "html에 보낼 계좌 입력창 없음\n" + html);
    assertTrue(
        html.contains("보낼 금액: <input"),
        "html에 보낼 금액 입력창 없음\n" + html);
    assertTrue(
        html.contains("확인</button>"),
        "html에 확인 버튼 없음\n" + html);
  }
}
