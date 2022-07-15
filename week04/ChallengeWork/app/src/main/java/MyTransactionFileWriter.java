import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyTransactionFileWriter {

  public MyTransactionFileWriter(List<String> myTransactions) throws IOException {
    FileWriter fileWriter = new FileWriter("myAccount.csv");

    for(String myTransaction : myTransactions){
      fileWriter.write(myTransaction + "\n");
    }
    fileWriter.close();
  }
}
