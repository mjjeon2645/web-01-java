import com.sun.net.httpserver.HttpServer;
import models.Account;
import repositories.AccountRepository;
import services.TransferService;
import utils.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

public class MakaoBankTransactions {
  private final FormParser formParser = new FormParser();

  private final AccountRepository accountRepository;
  private final String myIdentifier = "352-0528";
  private final TransferService transferService;
  private String name;

  public static void main(String[] args) throws IOException {
    MakaoBankTransactions application = new MakaoBankTransactions();
    application.run();
  }

  public MakaoBankTransactions() {
    accountRepository = new AccountRepository();

    transferService = new TransferService(accountRepository);
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);

    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      // 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
      name = path.substring(1);

      String method = exchange.getRequestMethod();

      String requestBody = new RequestBodyReader(exchange).body();

      Map<String, String> formData = formParser.parse(requestBody);

      // 처리
      PageGenerator pageGenerator = process(path, method, formData);

      // 출력
      new MessageWriter(exchange).write(pageGenerator.html());
    });

    httpServer.start();

    System.out.println("Server is listening... http://localhost:8000");
  }

  public PageGenerator process(
      String path, String method, Map<String, String> formData) {
    String[] steps = path.substring(1).split("/");

    return switch (steps[0]) {
      case "Account" -> processAccount(steps.length == 2 ? steps[1] : "");
      case "Transfer" -> processTransfer(method, formData);
      default -> new GreetingPageGenerator(name);
    };
  }

  public PageGenerator processAccount(String identifier) {
    Account account = accountRepository.find(identifier, myIdentifier);

    return new AccountPageGenerator(account);
  }

  public PageGenerator processTransfer(
      String method, Map<String, String> formData) {
    if (method.equals("GET")) {
      return processTransferGet();
    }

    return processTransferPost(formData);
  }

  private PageGenerator processTransferGet() {
    Account account = accountRepository.find(myIdentifier);

    return new TransferPageGenerator(account);
  }

  private PageGenerator processTransferPost(Map<String, String> formData) {
    transferService.transfer(
        myIdentifier,
        formData.get("to"),
        Long.parseLong(formData.get("amount"))
    );

    return new TransferSuccessPageGenerator();
  }
}
