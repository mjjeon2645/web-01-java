package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import repositories.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsPageGeneratorTest {
  @Test
  void content() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("110");

    PageGenerator pageGenerator = new TransactionsPageGenerator(account);

    String html = pageGenerator.html();

    assertTrue(
        html.contains("거래 내역"),
        "html에 거래 내역 제목 없음\n" + html);
  }

  @Test
  void transactions() {
    AccountRepository accountRepository = new AccountRepository();

    Account account1 = accountRepository.find("110");
    Account account2 = accountRepository.find("179");

    account1.transfer(account2, 300);
    account1.transfer(account2, 600);
    account1.transfer(account2, 1700);

    PageGenerator pageGenerator = new TransactionsPageGenerator(account1);

    String html = pageGenerator.html();

    assertTrue(
        html.contains("송금: 오바람 300원"),
        "html에 거래 내역 상세 내용 없음\n" + html);
    assertTrue(
        html.contains("송금: 오바람 600원"),
        "html에 거래 내역 상세 내용 없음\n" + html);
    assertTrue(
        html.contains("송금: 오바람 1700원"),
        "html에 거래 내역 상세 내용 없음\n" + html);
  }
}
