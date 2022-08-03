import com.sun.net.httpserver.HttpServer;
import models.Account;
import repositories.AccountRepository;
import services.TransferService;
import utils.AccountPageGenerator;
import utils.FormParser;
import utils.GreetingPageGenerator;
import utils.PageGenerator;
import utils.MessageWriter;
import utils.RequestBodyReader;
import utils.TransferPageGenerator;
import utils.TransferSucessPageGenerator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class MakaoBank {
  private final String accountIdentifier = "1234";
  private final TransferService transferService;
  private final FormParser formParser;
  private final AccountRepository accountRepository;


  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public MakaoBank() {
    formParser = new FormParser();

    accountRepository = new AccountRepository();
    transferService = new TransferService(accountRepository);
  }

  private void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);

    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", (exchange) -> {
      // 1. 입려 확인
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      String requestBody = new RequestBodyReader(exchange).body();

      Map<String, String> formData = formParser.parse(requestBody);

      // 2. 처리

      PageGenerator pageGenerator = process(path, method, formData);

      // 3. 출력

      new MessageWriter(exchange).write(pageGenerator.html());
    });

    httpServer.start();
    System.out.println("Server is listening!!!!! " + "http://localhost:8000");
  }

  private PageGenerator process(String path,
                                String method,
                                Map<String, String> formData) {

    String[] steps = path.substring(1).split("/");
    return switch (steps[0]) {
      case "account" -> processAccount(steps.length > 1 ? steps[1] : "");
      case "transfer" -> processTransfer(method, formData);
      default -> new GreetingPageGenerator();
    };
  }

  private PageGenerator processAccount(String identifier) {
    Account account = accountRepository.find(identifier, accountIdentifier);
    return new AccountPageGenerator(account);
  }

  private PageGenerator processTransfer(String method,
                                        Map<String, String> formData) {
    if (method.equals("GET")) {
      return processTransferGet();
    }

    return prcessTransferPost(formData);
  }

  private TransferPageGenerator processTransferGet() {
    Account account = accountRepository.find(accountIdentifier);
    return new TransferPageGenerator(account);
  }

  private TransferSucessPageGenerator prcessTransferPost(
      Map<String, String> formData) {

    transferService.transfer(
        accountIdentifier, formData.get("to"),
        Long.parseLong(formData.get("amount")));

    Account account = accountRepository.find(accountIdentifier);
    return new TransferSucessPageGenerator(account);
  }
}
