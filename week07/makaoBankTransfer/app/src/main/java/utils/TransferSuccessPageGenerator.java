package utils;

import models.*;

public class TransferSuccessPageGenerator extends PageGenerator {
  private Account account;

  public TransferSuccessPageGenerator(Account account) {
    super();
    this.account = account;
  }

  @Override
  protected String content() {
      return "계좌 이체 성공!";

  }
}
