package services;

import models.*;

public class TransferService {
  private Account myAccount;
  private Account yourAccount;

  public TransferService() {


  }

  public void transfer(Account from,Account to,int transferAmount,String inputAccountNumber) {
     if (inputAccountNumber.equals(yourAccount.getAccountNumber())) {
       this.myAccount = from;
       this.yourAccount = to;
      myAccount.getCurrentAmount() -= transferAmount;
      yourAccount.getCurrentAmount() += transferAmount;
    }

  }
}
