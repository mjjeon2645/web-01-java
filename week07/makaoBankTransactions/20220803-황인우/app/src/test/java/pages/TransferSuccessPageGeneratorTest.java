package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TransferSuccessPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new TransferSuccessPageGenerator();

    String html = pageGenerator.html();

    assertTrue(
        html.contains("계좌이체 성공!!!"),
        "html 계좌이체 성공 메세지 오류\n" + html);
  }
}
