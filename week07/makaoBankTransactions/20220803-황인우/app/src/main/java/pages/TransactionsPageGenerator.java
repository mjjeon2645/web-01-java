package pages;

import models.Account;

import java.util.stream.Collectors;

public class TransactionsPageGenerator extends PageGenerator {
  private Account account;

  public TransactionsPageGenerator(Account account) {
    super();

    this.account = account;
  }

  @Override
  public String content() {
    return "<h1>" + account.name() + " 거래 내역</h1>\n" +
        account.transactions().stream()
            .map(transaction -> "<p>" +
                  transaction.command(account) + ": " +
                  transaction.name(account) + " " +
                  transaction.amount() + "원</p>\n")
            .collect(Collectors.joining());
  }
}
