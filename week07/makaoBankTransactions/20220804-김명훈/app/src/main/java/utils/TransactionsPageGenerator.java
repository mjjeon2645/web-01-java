package utils;

import models.*;

import java.util.*;
import java.util.stream.*;

public class TransactionsPageGenerator extends PageGenerator {

  private Account account;

  public TransactionsPageGenerator(Account account) {

    this.account = account;
  }

  @Override
  public String content() {
    return "<h1>거래 내역 페이지</h1>\n" +
        account.transactions().stream()
            .map((transaction) -> "<p>" +
                transaction.command(account) + ": "
                + transaction.other(account).name() + " "
                + transaction.amount() + "원</p>")
            .collect(Collectors.joining());
  }
}
