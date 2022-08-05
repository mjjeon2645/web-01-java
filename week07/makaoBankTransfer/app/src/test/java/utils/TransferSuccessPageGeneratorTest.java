package utils;

import models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TransferSuccessPageGeneratorTest {
  @Test
  void message() {
    Account account = new Account("1234","Ashal",3000);

    PageGenerator pageGenerator = new TransferSuccessPageGenerator(account);
    String html = pageGenerator.html();

    assertTrue(html.contains("계좌 이체 성공!"),"메시지 문제: " + html);
  }

}