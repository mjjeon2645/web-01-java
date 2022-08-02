import com.sun.net.httpserver.HttpServer;
import models.Account;
import reporitories.AccountRepository;
import services.TransferService;
import pages.AccountPageGenerator;
import utils.FormParser;
import pages.GreetingPageGenerator;
import pages.PageGenerator;
import utils.MessageWriter;
import utils.RequestBodyReader;
import pages.TransactionPageGenerator;
import pages.TransferPageGenerator;
import pages.TransferSuccessPageGenerator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

public class MakaoBank {
  private final FormParser formParser;

  private final TransferService transferService;

  private final AccountRepository accountRepository;
  private final String accountIdentifier = "1234";

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

    httpServer.createContext("/", exchange -> {

      //입력

      URI requestURI = exchange.getRequestURI();

      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      String requestBody = new RequestBodyReader(exchange).body();
      Map<String, String> formData = formParser.parse(requestBody);


      // 처리
      PageGenerator pageGenerator = process(path, method, formData);

      //출력

      new MessageWriter(exchange).write(pageGenerator.html());
    });

    httpServer.start();
    System.out.println("http://localhost:8000/");
  }

  private PageGenerator process(String path, String method,
                                Map<String, String> formData) {
    String[] steps = path.substring(1).split("/");

    return switch (steps[0]) {
      case "account" -> processAccount(steps.length > 1 ? steps[1] : "");
      case "transfer" -> processTransfer(method, formData);
      case "transactions" -> processTransactions();
      default -> new GreetingPageGenerator();
    };
  }

  private AccountPageGenerator processAccount(String identifier) {
    Account account = accountRepository.find(identifier, accountIdentifier);
    return new AccountPageGenerator(account);
  }

  private PageGenerator processTransfer(String method,
                                        Map<String, String> formData) {
    if (method.equals("GET")) {
      return processTransferGet();
    }
    return processTransferPost(formData);
  }

  private TransferPageGenerator processTransferGet() {
    Account account = accountRepository.find(accountIdentifier);
    return new TransferPageGenerator(account);
  }

  private TransferSuccessPageGenerator processTransferPost(Map<String, String> formData) {
    transferService.transfer(accountIdentifier,
        formData.get("to"),
        Long.parseLong(formData.get("amount")));

    Account account = accountRepository.find(accountIdentifier);
    return new TransferSuccessPageGenerator(account);
  }

  private PageGenerator processTransactions() {
    Account account = accountRepository.find(accountIdentifier);
    return new TransactionPageGenerator(account);
  }
}
