package services;

import repositories.AccountRepository;
import models.Account;

public class TransferService {
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
