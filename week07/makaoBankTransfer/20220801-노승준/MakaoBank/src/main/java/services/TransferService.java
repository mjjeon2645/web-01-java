package services;

import Repositories.AccountRepository;
import models.Account;

import java.util.ArrayList;
import java.util.List;

public class TransferService {
  private String from;
  private String to;
  private long amount;
  private AccountRepository accountRepository;

  public TransferService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public void transfer(String from, String to, long amount) {
    Account sender = accountRepository.find(from);
    Account receiver = accountRepository.find(to);

    sender.transfer(receiver, amount);
  }
}
