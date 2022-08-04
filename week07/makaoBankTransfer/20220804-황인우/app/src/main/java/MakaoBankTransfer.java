import com.sun.net.httpserver.HttpServer;
import models.Account;
import pages.*;
import repositories.AccountRepository;
import services.TransferService;
import utils.FormParser;
import utils.MessageWriter;
import utils.RequestBodyReader;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

public class MakaoBankTransfer {
  private AccountRepository accountRepository;
  private String myIdentifier = "110";

  private TransferService transferService;

  public static void main(String[] args) throws IOException {
    MakaoBankTransfer application = new MakaoBankTransfer();
    application.run();
  }

  public MakaoBankTransfer() {
    accountRepository = new AccountRepository();

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

      String requestBody = new RequestBodyReader(exchange).body();
      Map<String, String> formData = new FormParser().parse(requestBody);

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
    String function = steps[0];
    String identifier = "";

    if (steps.length > 1) {
      identifier = steps[1];
    }

    return switch (function) {
      case "account" -> processAccount(identifier);
      case "transfer" -> processTransfer(method, identifier, formData);
      default -> new GreetingPageGenerator(name);
    };
  }

  public PageGenerator processAccount(String identifier) {
    Account found = accountRepository.find(identifier, myIdentifier);

    return new AccountPageGenerator(found);
  }

  public PageGenerator processTransfer(
      String method, String identifier, Map<String, String> formData) {
    if (method.equals("GET")) {
      return processTransferGet(identifier);
    }

    return processTransferPost(identifier, formData);
  }

  public PageGenerator processTransferGet(String identifier) {
    Account found = accountRepository.find(identifier, myIdentifier);

    return new TransferPageGenerator(found);
  }

  private PageGenerator processTransferPost(
      String identifier, Map<String, String> formData) {
    Account found = accountRepository.find(identifier, myIdentifier);

    transferService.transfer(
        found.identifier(),
        formData.get("to"),
        Long.parseLong(formData.get("amount")));

    return new TransferSuccessPageGenerator();
  }
}
