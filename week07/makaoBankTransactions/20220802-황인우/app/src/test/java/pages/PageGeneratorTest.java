package pages;

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

    assertTrue(navigation.contains("홈으로"), "홈으로 가기 링크 없음\n" + navigation);
    assertTrue(navigation.contains("잔액 조회"), "잔액 조회 링크 없음\n" + navigation);
    assertTrue(navigation.contains("송금"), "송금 링크 없음\n" + navigation);
    assertTrue(navigation.contains("거래내역 조회"), "거래내역 조회 링크 없음\n" + navigation);
  }
}
