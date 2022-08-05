package services;

import models.*;

import java.util.*;

public class TransferService {
  private final List<Account> accounts;


  public TransferService(List<Account> accounts) {
    this.accounts = new ArrayList<>(accounts);

  }

  public void transfer(String from, String to, int amount) {

    Account sender = accounts.stream()
        .filter(account -> account.identifier().equals(from))
            .findFirst().get();

    Account receiver = accounts.stream()
            .filter(account -> account.identifier().equals(to))
                .findFirst().get();

       sender.transfer(receiver,amount);
  }
}
