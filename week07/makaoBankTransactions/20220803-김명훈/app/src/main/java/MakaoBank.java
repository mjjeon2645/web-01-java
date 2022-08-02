import com.sun.net.httpserver.*;
import models.*;
import pages.*;
import repository.*;
import services.*;
import utils.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class MakaoBank {
  private String accountIdentifier = "1234";
  private TransferService transferService;
  private AccountRepository accountRepository;
  private FormParser formParser;

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
      //1. 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      RequestBodyReader requestBodyReader = new RequestBodyReader(exchange);

      String requestBody = requestBodyReader.body();

      Map<String, String> formData = formParser.parse(requestBody);

      //2. 처리
      PageGenerator pageGenerator = process(path, method, formData);

      //3. 출력
      new MessageWriter(exchange).write(pageGenerator.html());
    });

    httpServer.start();
    System.out.println("http://localhost:8000");
  }

  private PageGenerator process(String path,
                                String method,
                                Map<String, String> formData) {
    String[] steps = path.substring(1).split("/");
    return switch (steps[0]) {
      case "account" -> processAccount(steps.length > 1 ? steps[1] : "");
      case "transfer" -> processTransfer(method, formData);
      case "transactions" -> processTransaction();
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

  private TransferSuccessPageGenerator processTransferPost(
      Map<String, String> formData) {

    transferService.transfer(
        accountIdentifier, formData.get("to"),
        Long.parseLong(formData.get("amount")));

    Account account = accountRepository.find(accountIdentifier);
    return new TransferSuccessPageGenerator(account);
  }

  private PageGenerator processTransaction() {
    Account account = accountRepository.find(accountIdentifier);
    return new TransactionsPageGenerator(account);
  }
}
