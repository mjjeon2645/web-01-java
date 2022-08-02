package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import pages.PageGenerator;
import pages.TransactionsPageGenerator;
import repositories.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsPageGeneratorTest {
  @Test
  void content() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("1234");
    Account account2 = accountRepository.find("2345");

    account.transfer(account2, 500);

    PageGenerator pageGenerator = new TransactionsPageGenerator(account);

    String html = pageGenerator.content();

    assertTrue(html.contains("거래 내역"), "페이지 제목 문제:" + html);
    assertTrue(html.contains("송금: Joker 500원"), "송금 내역 문제:" + html);
    assertTrue(html.contains("입금: Joker 100원"), "입금 내역 문제:" + html);
  }
}