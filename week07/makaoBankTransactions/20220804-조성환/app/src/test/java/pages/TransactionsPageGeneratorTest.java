package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import repositories.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsPageGeneratorTest {
  @Test
  void content() {
    AccountRepository accountRepository = new AccountRepository();

    Account account1 = accountRepository.find("1234");
    Account account2 = accountRepository.find("2345");

    account1.transfer(account2, 500);
    account2.transfer(account1, 100);

    PageGenerator pageGenerator = new TransactionsPageGenerator(account1);

    String html = pageGenerator.html();

    assertTrue(html.contains("거래 내역"), "메시지 문제 " + html);
    assertTrue(html.contains("송금: JOKER 500원"), "송금 내역 문제 " + html);
    assertTrue(html.contains("입금: JOKER 100원"), "입금 내역 문제 " + html);
  }
}
