package pages;

import models.*;

public class TransferSuccessPageGenerator extends PageGenerator {
  public TransferSuccessPageGenerator(Account account) {
    super();
  }

  @Override
  public String content() {
    return "<p>계좌이체 성공!</p>";
  }
}
