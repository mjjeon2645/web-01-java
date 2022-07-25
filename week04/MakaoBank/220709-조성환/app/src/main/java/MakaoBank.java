// main -run
// 입력 처리 출력 형태
// 제목이 파일읽고쓰기 이니까 어떤 파일을 쓸 것이냐? CSV-> ,로 나누어진 데이터이다. (엑셀에서
// 데이터를 텍스트로 내보낼 떄 사용)
// output.csv가 우리가 원하는 결과이다.
// 처리하려는 게 뭔가? -> 무언가 .. 객체
// 객체지향 프로그래밍 -> 도메인 모델(실제 개념 도입)
// 계좌 , 거래 , 거래 결과라는 모델이 필요하다
// 계좌가 거래 내역을 가지고 있지 않다. (csv파일이 거래결과를 가지고 있지 않다는게 아님 저번주는 account가
// 거래 결과를 가지고 있었다.)
// null => 객체 없음 위험하다=> NullpointerException 이라는 문제가 발생

import models.Account;
import models.Transaction;
import models.TransactionResult;

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

  private void run() throws IOException {
    //입력
    Account account = new Account();
    // 거래내역이라는 타입을 담고 있는 리스트는 account를 매개변수로 받는 loadtransactions라는 메서드이다?..
    List<Transaction> transactions = loadTransactions();

    for (Transaction transaction : transactions) {
      System.out.println(transaction);
    }

    //처리
    // account 안에 있는 process라는 메서드가 거래내역을 받아서 처리를 해준다.
    // 송금이냐 출금이냐 타입에 따라서 amount를 처리해주는게 이 처리과정?
    List<TransactionResult> transactionResults = account.process(transactions);

    //출력
    // 송금 결과를 받아서 그 결과를 저장해주는 역
    saveTransacttionResult(transactionResults);
  }

  public List<Transaction> loadTransactions() throws FileNotFoundException {
    List<Transaction> transactions = new ArrayList<>();

    File file = new File("/Users/seonghwan/Desktop/web01java/week04/MakaoBank/220709-조성환/input.csv");

    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();
      System.out.println(line);

      //문자열을 객체로 변환하는 작업이 필요하다 -> Parsing

      Transaction transaction = parseTransaction(line);
      transactions.add(transaction);
    }
      return transactions;
  }

  public Transaction parseTransaction(String text) {
    String[] words = text.split(",");
    int amount = Integer.parseInt(words[1]);
    return new Transaction(words[0], amount);
  }

  public void saveTransacttionResult(
      List<TransactionResult> transactionResults) throws IOException {
    FileWriter fileWriter = new FileWriter("/Users/seonghwan/Desktop/web01java/" +
        "week04/MakaoBank/220709-조성환/output.csv");
    for(TransactionResult transactionResult : transactionResults){
      String line = transactionResult.toCsvRow();
      fileWriter.write(line + "\n");
    }


    fileWriter.close();
  }
}
