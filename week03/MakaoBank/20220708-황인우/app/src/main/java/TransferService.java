public class TransferService {
  private final AccountRepository accountRepository;

  public TransferService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public void transfer(
      String myIdentifier, String otherIdentifier, long transferAmount) {
    Account myAccount = this.accountRepository.find(myIdentifier);
    Account otherAccount = this.accountRepository.find(otherIdentifier);

    myAccount.transfer(otherAccount, transferAmount);
  }
}
