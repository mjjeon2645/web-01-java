package utils;

import models.*;

public class TransferSuccessPageGenerator extends PageGenerator {
  private Account account;

  public TransferSuccessPageGenerator(Account account) {

    this.account = account;
  }

  @Override
  public String content() {
    return "계좌 이체 성공!";
  }
}
