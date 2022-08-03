package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageGeneratorTest {
  @Test
  void navigation() {
    PageGenerator pageGenerator = new PageGenerator() {
      @Override
      public String content() {
        return "";
      }
    };

    String navigation = pageGenerator.navigation();

    assertTrue(
        navigation.contains("홈으로</a>"),
        "navigation에 홈으로 링크 없음\n" + navigation);
    assertTrue(
        navigation.contains("잔액 조회</a>"),
        "navigation에 잔액 조회 링크 없음\n" + navigation);
    assertTrue(
        navigation.contains("송금</a>"),
        "navigation에 송금 링크 없음\n" + navigation);
  }
}
