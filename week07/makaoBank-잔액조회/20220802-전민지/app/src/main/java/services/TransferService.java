package services;

import models.Account;

public class TransferService {
  private final Account account;

  public TransferService(Account account) {
    this.account = account;
  }

  //Todo. account는 from과 관련있어야 함
  // TODO. to도 써야함
  public void transfer(String from, String to, long amount) {
    this.account.transfer(amount);
  }
}
