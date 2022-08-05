package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import reporitories.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransactionPageGeneratorTest {
  @Test
  void content() {
    AccountRepository accountRepository = new AccountRepository();

    Account account1 = accountRepository.find("1234");
    Account account2 = accountRepository.find("2345");

    account1.transfer(account2, 500);
    account1.transfer(account1, 100);

    PageGenerator pageGenerator = new TransactionPageGenerator(account1);

    String html = pageGenerator.content();

    assertTrue(html.contains("거래 내역"), "페이지 제목 문제" + html);
    assertTrue(html.contains("송금: Joker 500원"), "송금 내역 문제" + html);
    assertTrue(html.contains("입금: Joker 100"), "입금 내역 문제" + html);
  }
}
