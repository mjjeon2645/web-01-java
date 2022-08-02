package pages;

import models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsPageGeneratorTest {
  @Test
  void content() {
    Account account1 = new Account("179", "치코리타", 500);
    Account account2 = new Account("305", "피죤", 500);

    account1.transfer(account2, 10);
    account1.transfer(account2, 30);
    account1.transfer(account2, 30);
    account2.transfer(account1, 30);
    account2.transfer(account1, 50);

    PageGenerator pageGenerator = new TransactionsPageGenerator(account1);

    String html = pageGenerator.html();

    assertTrue(html.contains("거래 내역"), "html에 거래 내역 제목 없음\n" + html);
    assertTrue(html.contains("송금: 피죤 10원"), "html에 거래 내역 내용 잘못됨\n" + html);
    assertTrue(html.contains("송금: 피죤 30원"), "html에 거래 내역 내용 잘못됨\n" + html);
    assertTrue(html.contains("송금: 피죤 30원"), "html에 거래 내역 내용 잘못됨\n" + html);
    assertTrue(html.contains("입금: 피죤 30원"), "html에 거래 내역 내용 잘못됨\n" + html);
    assertTrue(html.contains("입금: 피죤 50원"), "html에 거래 내역 내용 잘못됨\n" + html);

    pageGenerator = new TransactionsPageGenerator(account2);

    html = pageGenerator.html();

    assertTrue(html.contains("거래 내역"), "html에 거래 내역 제목 없음\n" + html);
    assertTrue(html.contains("입금: 치코리타 10원"), "html에 거래 내역 내용 잘못됨\n" + html);
    assertTrue(html.contains("입금: 치코리타 30원"), "html에 거래 내역 내용 잘못됨\n" + html);
    assertTrue(html.contains("입금: 치코리타 30원"), "html에 거래 내역 내용 잘못됨\n" + html);
    assertTrue(html.contains("송금: 치코리타 30원"), "html에 거래 내역 내용 잘못됨\n" + html);
    assertTrue(html.contains("송금: 치코리타 50원"), "html에 거래 내역 내용 잘못됨\n" + html);
  }
}
