package utils;

import models.Account;

public class TransferProcessSuccessPageGenerator extends PageGenerator {
  private Account account;

  public TransferProcessSuccessPageGenerator(Account account) {
    super();
    this.account = account;
  }

  @Override
  public String content() {
    return "계좌 이체 성공!";
  }
}
