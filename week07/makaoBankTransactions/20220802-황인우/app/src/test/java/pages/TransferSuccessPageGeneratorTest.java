package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferSuccessPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new TransferSuccessPageGenerator();

    String content = pageGenerator.content();

    assertTrue(content.contains("계좌이체 성공!!!"), "계좌이체 성공 안내 없음\n" + content);
  }
}
