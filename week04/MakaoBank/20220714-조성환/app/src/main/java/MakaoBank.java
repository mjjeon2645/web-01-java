import models.Account;
import models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MakaoBank {
  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() {
    //준비
    Account account = new Account();

    //입력
    List<Transaction> transactions = loadTransaction();

    //처리
    //List<TransactionResult> transactionResults = account.process(transactions);

    //출력
    //saveTransactionResult(transactionResults);
  }

  public List<Transaction> loadTransaction() {
    List<Transaction> transactions = new ArrayList<>();
    return transactions;
  }
}
