import Repositories.AccountRepository;
import com.sun.net.httpserver.HttpServer;
import models.Account;
import services.TransferService;
import utils.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

public class MakaoBankTransactions {
  private FormParser formParser = new FormParser();

  private AccountRepository accountRepository;
  private String myIdentifier = "352";
  private TransferService transferService;

  public static void main(String[] args) throws IOException {
    MakaoBankTransactions application = new MakaoBankTransactions();
    application.run();
  }

  public void run() throws IOException {
    accountRepository = new AccountRepository();

    transferService = new TransferService(accountRepository);

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      // 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
      String name = path.substring(1);

      RequestBodyReader requestBodyReader = new RequestBodyReader(exchange);
      String requestBody = requestBodyReader.body();

      Map<String, String> formData = formParser.parse(requestBody);

      String method = exchange.getRequestMethod();

      //처리
      PageGenerator pageGenerator = process(path, name, method, formData);

      String html = pageGenerator.html();

      exchange.sendResponseHeaders(200, html.getBytes().length);

      // 출력
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(html);
    });

    httpServer.start();

    System.out.println("Server is listening... http://localhost:8000/");
  }

  private PageGenerator process(
      String path, String name, String method, Map<String, String> formData) {
    String[] split = path.substring(1).split("/");

    return switch (split[0]) {
      case "Account" -> processAccount(split.length >= 2 ? split[1] : "");
      case "Transfer" -> processTransfer(method, formData);
      default -> new GreetingPageGenerator(name);
    };
  }

  private PageGenerator processAccount(String identifier) {
    Account found = accountRepository.find(identifier, myIdentifier);

    return new AccountPageGenerator(found);
  }

  private PageGenerator processTransfer(
      String method, Map<String, String> formData) {
    if (method.equals("GET")) {
      return processTransferGet();
    }
    return processTransferPost(formData);
  }

  private PageGenerator processTransferGet() {
    Account found = accountRepository.find(myIdentifier);

    return new TransferPageGenerator(found);
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
