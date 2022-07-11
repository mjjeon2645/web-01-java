// 입력 파일 예시
// 잔액,5000
// 입금,500
// 출금,1500
// 출금,2000
//
// 출력 파일 예시
// 잔액,5000,5000
// 입금,500,5500
// 출금,1500,4000
// 출금,2000,2000

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakaoBank {
  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() throws IOException {
    // 거래내역을 별도로 받은 뒤, Account가 해당 거래내역을 받아 처리해
    // 거래내역 결과를 생성하는 구조 구성

    // 준비
    Account account = new Account();

    // 입력
    List<Transaction> transactions = loadTransactions();

    // 처리
    List<TransactionResult> transactionResults = account.process(transactions);

    // 출력
    saveTransactionResults(transactionResults);
  }

  public List<Transaction> loadTransactions() throws FileNotFoundException {
    List<Transaction> transactions = new ArrayList<>();

    File file = new File("/Users/inu/web-01-java/week04/MakaoBank/20220711-황인우/input.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      String[] components = line.split(",");
      String type = components[0];
      int amount = Integer.parseInt(components[1]);

      transactions.add(new Transaction(type, amount));
    }

    return transactions;
  }

  public void saveTransactionResults(
      List<TransactionResult> transactionResults) throws IOException {
    FileWriter fileWriter = new FileWriter("output.csv");

    for (TransactionResult transactionResult : transactionResults) {
      String type = transactionResult.transaction().type();
      Integer amount = transactionResult.transaction().amount();
      Integer result = transactionResult.result();

      String line = String.join(",", type, amount.toString(), result.toString());

      fileWriter.write(line + "\n");
    }

    fileWriter.close();
  }
}
