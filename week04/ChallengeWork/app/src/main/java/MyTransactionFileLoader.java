import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MyTransactionFileLoader {
  public MyTransactionFileLoader(List<String> myTransactions) throws FileNotFoundException {
    // todo 이렇게 리스트 2개를 받아오면 파일로더랑 파일라이터랑
    //  2개씩 만들어야 하는데 이건 아닌거 같은데 일단은 해보자

    File file = new File("myAccount.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      myTransactions.add(line);
    }
  }
}