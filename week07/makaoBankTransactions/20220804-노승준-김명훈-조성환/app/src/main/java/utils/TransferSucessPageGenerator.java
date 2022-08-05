package utils;

import models.Account;

public class TransferSucessPageGenerator extends PageGenerator {
  private Account account;

  public TransferSucessPageGenerator(Account account) {
    this.account = account;
  }

  @Override
  public String content() {
    return "계좌 이체 성공!";
  }
}
