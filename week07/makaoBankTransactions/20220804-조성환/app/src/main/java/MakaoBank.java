import com.sun.net.httpserver.HttpServer;
import models.Account;
import pages.AccountPageGenerator;
import pages.GreetingPageGenerator;
import pages.TransactionsPageGenerator;
import pages.TransferPageGenerator;
import pages.TransferSuccessPageGenerator;
import repositories.AccountRepository;
import services.TransferService;
import utils.FormParser;
import utils.MessageWriter;
import pages.PageGenerator;
import utils.RequestBodyReader;

import java.io.IOException;
import java.net.InetSocketAddress;

import java.util.Map;

public class MakaoBank {

  private TransferService transferService;
  private AccountRepository accountRepository;
  private final String accountIdentifier = "1234";

  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() throws IOException {
    accountRepository = new AccountRepository();

    transferService = new TransferService(accountRepository);

    InetSocketAddress address = new InetSocketAddress(8000);

    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {

      String path = exchange.getRequestURI().getPath();

      String method = exchange.getRequestMethod();

      RequestBodyReader requestBodyReader = new RequestBodyReader(exchange);
      String requestBody = requestBodyReader.body();

      FormParser formParser = new FormParser();
      Map<String, String> formData = formParser.parse(requestBody);

      PageGenerator pageGenerator = process(path, method, formData);

      String content = pageGenerator.html();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });
    httpServer.start();
    System.out.println("http://localhost:8000");
  }

  private PageGenerator process(String path,
                                String method,
                                Map<String, String> formData) {
    String[] steps = path.substring(1).split("/");
    return switch (steps[0]) {
      case "/account" -> processAccount(steps.length > 1 ? steps[1] : "");
      case "/transfer" -> processTransfer(method, formData);
      case "/transactions" -> processTransactions();
      default -> new GreetingPageGenerator();
    };
  }

  private PageGenerator processTransactions() {
    Account account = accountRepository.find(accountIdentifier);

    return new TransactionsPageGenerator(account);
  }

  private PageGenerator processAccount(String identifier) {
    Account account = accountRepository.find(identifier, accountIdentifier);
    return new AccountPageGenerator(account);
  }

  private PageGenerator processTransfer(String method, Map<String, String> formData) {
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

    transferService.transfer(
        accountIdentifier
        , formData.get("to")
        , Long.parseLong(formData.get("amount")));

    Account account = accountRepository.find(accountIdentifier);
    return new TransferSuccessPageGenerator(account);
  }
}
