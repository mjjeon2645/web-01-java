package utils;

import models.Account;

import java.util.stream.Collectors;

public class TransactionPageGenerator extends PageGenerator {
  private Account account;

  public TransactionPageGenerator(Account account) {
    super();
    this.account = account;
  }

  @Override
  public String content() {

    return "<h1>거래 내역 페이지</h1>"
        + account.transactions().stream()
        .map(transaction -> "<p>" +
            transaction.command(account) + ": "
            + transaction.other(account).name() + " "
            + transaction.amount() + "원" +
            "</p>\n")
        .collect(Collectors.joining());
  }
}
