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
  private Account account;
  private String accountIdentifier = "1234";
  private TransferService transferService;
  private AccountRepository accountRepository;
  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() throws IOException {
    accountRepository = new AccountRepository();

    account = accountRepository.find(accountIdentifier);
    transferService = new TransferService(accountRepository);
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
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

    System.out.println("http://localhost:8000");
    httpServer.start();
  }

  private PageGenerator process(String path, String method, Map<String, String> formData) {
    String[] steps = path.substring(1).split("/");
    return switch (steps[0]) {
      case "account" -> processAccount(steps.length > 1 ? steps[1] : "" );
      case "transfer" -> processTransfer(method,formData);
      default -> new GreetingPageGenerator();
    };
  }
  // (주어)무엇이 무엇으로 바뀐다
  private AccountPageGenerator processAccount(String identifier) {
    Account found = accountRepository.find(identifier,accountIdentifier);
    return new AccountPageGenerator(found);
  }

  private PageGenerator processTransfer(String method, Map<String, String> formData) {
    if (method.equals("GET")) {
      return processTransferGet();
    }
    return processTransferPost(formData);
  }

  private TransferPageGenerator processTransferGet() {
    return new TransferPageGenerator(account);
  }

  private TransferSuccessPageGenerator processTransferPost(Map<String, String> formData) {
    transferService.transfer(account.identifier(),
        formData.get("to"),
        Long.parseLong(formData.get("amount")));
    return new TransferSuccessPageGenerator(account);
  }
}
