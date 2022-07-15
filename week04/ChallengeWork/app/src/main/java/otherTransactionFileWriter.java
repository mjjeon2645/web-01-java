import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class otherTransactionFileWriter {
  public otherTransactionFileWriter(List<String> transactions) throws IOException {
    FileWriter fileWriter = new FileWriter("otherAccount.csv");

    for(String transaction : transactions){
      fileWriter.write(transaction + "\n");
    }
    fileWriter.close();
  }
}
