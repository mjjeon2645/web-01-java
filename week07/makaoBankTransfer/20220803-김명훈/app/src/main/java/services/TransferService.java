package services;

import models.*;
import repository.*;

import java.util.*;

public class TransferService {
  private ArrayList<Account> accounts;
  private AccountRepository accountRepository;

  public TransferService(AccountRepository accountRepository) {

    this.accountRepository = accountRepository;
  }

  public void transfer(String from, String to, long amount) {
    Account sender = accountRepository.find(from);
    Account receiver = accountRepository.find(to);

    sender.transfer(receiver,amount);
  }
}
