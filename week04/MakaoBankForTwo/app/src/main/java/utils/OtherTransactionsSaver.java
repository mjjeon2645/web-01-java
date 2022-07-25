package utils;

import models.Account;

import java.io.FileWriter;
import java.io.IOException;

public class OtherTransactionsSaver {
  public OtherTransactionsSaver(Account otherAccount) throws IOException {
    FileWriter fileWriter = new FileWriter("othertransactions.csv");

    fileWriter.write("계좌번호," + otherAccount.identifier()+ "\n");

    fileWriter.write("잔액," + otherAccount.amount()+ "\n");

    for (String transaction : otherAccount.transactions()) {
      fileWriter.write(transaction + "\n");
    }

    fileWriter.close();
  }
}
