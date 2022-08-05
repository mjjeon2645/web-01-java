import repositories.AccountRepository;
import com.sun.net.httpserver.HttpServer;
import models.Account;
import services.TransferService;
import utils.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

public class MakaoBankTransfer {
  private final AccountRepository accountRepository;
  private String myIdentifier;

  private TransferService transferService;

  public static void main(String[] args) throws IOException {
    MakaoBankTransfer application = new MakaoBankTransfer();
    application.run();
  }

  public MakaoBankTransfer() {
    accountRepository = new AccountRepository();
    myIdentifier = "110";

    transferService = new TransferService(accountRepository);
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      URI uri = exchange.getRequestURI();
      String path = uri.getPath();
      String name = path.substring(1);

      String method = exchange.getRequestMethod();

      RequestBodyReader requestBodyReader = new RequestBodyReader(exchange);
      String requestBody = requestBodyReader.body();

      FormParser formParser = new FormParser();
      Map<String, String> formData = formParser.parse(requestBody);

      PageGenerator pageGenerator = process(path, name, method, formData);
      String html = pageGenerator.html();

      exchange.sendResponseHeaders(200, html.getBytes().length);

      new MessageWriter(exchange).write(html);
    });

    httpServer.start();

    System.out.println("Server is listening... http://localhost:8000/");
  }

  public PageGenerator process(
      String path, String name, String method, Map<String, String> formData) {
    String[] steps = path.substring(1).split("/");

    return switch (steps[0]) {
      case "Account" -> processAccount(steps.length > 1 ? steps[1] : "");
      case "Transfer" -> processTransfer(method, formData);
      default -> processGreeting(name);
    };
  }

  public PageGenerator processAccount(String identifier) {
    Account found = accountRepository.find(identifier, myIdentifier);

    return new AccountPageGenerator(found);
  }

  public PageGenerator processTransfer(
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
        Long.parseLong(formData.get("amount")));

    return new TransferSuccessPageGenerator();
  }

  public PageGenerator processGreeting(String name) {
    return new GreetingPageGenerator(name);
  }
}
