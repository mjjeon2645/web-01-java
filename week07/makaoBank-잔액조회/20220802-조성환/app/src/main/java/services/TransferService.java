package services;

import models.Account;

import java.util.ArrayList;
import java.util.List;

public class TransferService {
  private List<Account> accounts;

  public TransferService(List<Account> accounts) {
    this.accounts = new ArrayList<>(accounts);
  }

  public void transfer(String from, String to, long amount) {
    Account sender = accounts.stream()
        .filter(account -> account.identifier().equals(from))
        .findFirst().get();

    Account receiver = accounts.stream()
        .filter(account -> account.identifier().equals(to))
        .findFirst().get();

    sender.transfer(receiver, amount);
  }
}
