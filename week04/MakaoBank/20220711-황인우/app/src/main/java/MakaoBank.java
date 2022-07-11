//입력 파일 예시
//잔액,5000
//입금,500
//출금,1500
//출금,2000
//
//출력 파일 예시
//잔액,5000,5000
//입금,500,5500
//출금,1500,4000
//출금,2000,2000

public class MakaoBank {
  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() {
    //거래내역을 별도로 받은 뒤, Account가 해당 거래내역을 받아 처리해
    //거래내역 결과를 생성하는 구조 구성

    //준비
    //Account account = new Account();

    //입력
    List<Transaction> transactions = loadTransactions();

    //처리
    //List<TransactionResult> transactionResults = account.process(transactions);

    //출력
    //saveTransactionResults(transactionResults);
  }
}
