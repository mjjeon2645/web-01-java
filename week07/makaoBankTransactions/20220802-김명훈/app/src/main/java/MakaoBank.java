import com.sun.net.httpserver.*;
import models.*;
import repositories.*;
import services.*;
import utils.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class MakaoBank {
  private String accountIdentifier = "1234";
  private AccountRepository accountRepository;
  private TransferService transferService;
  private FormParser formParser;

  public static void main(String[] args) throws IOException {
    MakaoBank applicattion = new MakaoBank();
    applicattion.run();
  }

  public MakaoBank() {
    formParser = new FormParser();

    accountRepository = new AccountRepository();

    transferService = new TransferService(accountRepository);
  }

  private void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address,0);

    httpServer.createContext("/",exchange -> {

      String method = exchange.getRequestMethod();

      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      RequestBodyReader requestBodyReader = new RequestBodyReader(exchange);
      String requestBody = requestBodyReader.body();

      Map<String, String> formData = formParser.parse(requestBody);
      PageGenerator pageGenerator = process(method, path, formData);


    String content = pageGenerator.html();

    MessageWriter messageWriter = new MessageWriter(exchange);
    messageWriter.write(content);
    });
    System.out.println("http://localhost:8000");
    httpServer.start();
  }

  private PageGenerator process(String method,
                                String path,
                                Map<String, String> formData) {
    String[] steps = path.substring(1).split("/");

    return switch (steps[0]) {
      case "account" -> processAccount(steps.length > 1 ? steps[1] : "");
      case "transfer" -> processTransfer(method, formData);
      case "transaction" -> processTransaction();
      default -> new GreetingPageGenerator();
    };
  }

  private AccountPageGenerator processAccount(String identifier) {
    Account account = accountRepository.find(identifier, accountIdentifier);
    return new AccountPageGenerator(account);
  }

  private PageGenerator processTransfer(String method,
                                        Map<String,String> formData) {
    if (method.equals("GET")) {
      return processTransferGet();
    }
    return processTransferPost(formData);
  }

  private TransferPageGenerator processTransferGet() {
    Account account = accountRepository.find(accountIdentifier);
    return new TransferPageGenerator(account);
  }

  private TransferSuccessPageGenerator processTransferPost(Map<String,String> formData) {
    transferService.transfer(accountIdentifier, formData.get("to"), Long.parseLong(formData.get("amount")));

    Account account = accountRepository.find(accountIdentifier);
    return new TransferSuccessPageGenerator(account);
  }

  private TransactionPageGenerator processTransaction() {
    Account account = accountRepository.find(accountIdentifier);
    return new TransactionPageGenerator(account);
  }
}
