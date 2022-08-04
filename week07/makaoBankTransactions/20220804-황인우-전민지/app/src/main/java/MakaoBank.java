import com.sun.net.httpserver.HttpServer;
import models.Account;
import pages.*;
import repositories.AccountRepository;
import services.TransferService;
import utils.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

public class MakaoBank {
  private final FormParser formParser;

  private final String accountIdentifier = "1234";

  private final AccountRepository accountRepository;
  private final TransferService transferService;

  public static void main(String[] args) throws IOException {
    MakaoBank makaoBank = new MakaoBank();
    makaoBank.run();
  }

  public MakaoBank() {
    formParser = new FormParser();

    accountRepository = new AccountRepository();
    transferService = new TransferService(accountRepository);
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", (exchange) -> {

      // 1. 입력
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

    System.out.println("http://localhost:8000/");
  }

  public PageGenerator process(String path, String method,
                               Map<String, String> formData) {

    String[] steps = path.substring(1).split("/");
    return switch (steps[0]) {
      case "account" -> processAccount(steps.length > 1 ? steps[1] : "");
      case "transfer" -> processTransfer(method, formData,
          steps.length > 1 ? steps[1] : "");
      case "transactions" -> processTransactions(steps.length > 1 ? steps[1] : "");
      default -> new GreetingPageGenerator();
    };
  }

  public AccountPageGenerator processAccount(String identifier) {
    Account account = accountRepository.find(identifier, accountIdentifier);
    return new AccountPageGenerator(account);
  }

  public PageGenerator processTransfer(
      String method, Map<String, String> formData, String identifier) {
    if (method.equals("GET")) {
      return processTransferGet(identifier);
    }

    return TransferProcessPost(formData, identifier);
  }

  public TransferPageGenerator processTransferGet(String identifier) {
    Account account = accountRepository.find(identifier, accountIdentifier);
    return new TransferPageGenerator(account);
  }

  public TransferSuccessPageGenerator TransferProcessPost(
      Map<String, String> formData, String identifier) {
    Account found = accountRepository.find(identifier, accountIdentifier);

    transferService.transfer(
        found.identifier(),
        formData.get("to"),
        Long.parseLong(formData.get("amount")));

    Account account = accountRepository.find(accountIdentifier);
    return new TransferSuccessPageGenerator(account);
  }

  public PageGenerator processTransactions(String identifier) {
    Account account = accountRepository.find(identifier, accountIdentifier);
    return new TransactionsPageGenerator(account);
  }
}
