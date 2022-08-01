package pages;

import models.Account;
import org.junit.jupiter.api.Test;
import repositories.AccountRepository;
import services.TransferService;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsPageGeneratorTest {
  @Test
  void content() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("352-0528");
    Account receiver = accountRepository.find("179-20");

    TransferService transferService = new TransferService(accountRepository);

    transferService.transfer(sender.identifier(), receiver.identifier(), 100);
    transferService.transfer(sender.identifier(), receiver.identifier(), 500);
    transferService.transfer(sender.identifier(), receiver.identifier(), 700);
    transferService.transfer(sender.identifier(), receiver.identifier(), 700);
    transferService.transfer(sender.identifier(), receiver.identifier(), 1000);

    PageGenerator pageGenerator = new TransactionsPageGenerator(sender);

    String content = pageGenerator.content();

    assertTrue(content.contains("거래 내역"), "content에 제목 없음\n" + content);
    assertTrue(content.contains(
        "송금: Eevee 100원"), "content에 송금 내역 내용 없음\n" + content);
    assertTrue(content.contains(
        "송금: Eevee 500원"), "content에 송금 내역 내용 없음\n" + content);
    assertTrue(content.contains(
        "송금: Eevee 700원"), "content에 송금 내역 내용 없음\n" + content);
    assertTrue(content.contains(
        "송금: Eevee 700원"), "content에 송금 내역 내용 없음\n" + content);
    assertTrue(content.contains(
        "송금: Eevee 1000원"), "content에 송금 내역 내용 없음\n" + content);

    pageGenerator = new TransactionsPageGenerator(receiver);

    content = pageGenerator.content();

    assertTrue(content.contains(
        "입금: Chikorita 100원"), "content에 입금 내역 내용 없음\n" + content);
    assertTrue(content.contains(
        "입금: Chikorita 500원"), "content에 입금 내역 내용 없음\n" + content);
    assertTrue(content.contains(
        "입금: Chikorita 700원"), "content에 입금 내역 내용 없음\n" + content);
    assertTrue(content.contains(
        "입금: Chikorita 700원"), "content에 입금 내역 내용 없음\n" + content);
    assertTrue(content.contains(
        "입금: Chikorita 1000원"), "content에 입금 내역 내용 없음\n" + content);
  }
}
