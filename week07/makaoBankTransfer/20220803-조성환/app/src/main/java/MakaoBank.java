import com.sun.net.httpserver.HttpServer;
import models.Account;
import services.TransferService;
import utils.AccountPageGenerator;
import utils.GreetingPageGenerator;
import utils.MessageWriter;
import utils.PageGenerator;
import utils.TransferPageGenerator;
import utils.TransferSuccessPageGenerator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

public class MakaoBank {
  private Account account;
  private TransferService transferService;

  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() throws IOException {
    List<Account> accounts = List.of(
        new Account("1234", "Ashal", 3000),
        new Account("2345", "JOKER", 1000)
    );
    account = accounts.get(0);

    transferService = new TransferService(accounts);

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {

      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      PageGenerator pageGenerator = process(path, method);

      String content = pageGenerator.html();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });
    httpServer.start();
    System.out.println("http://localhost:8000");
  }

  private PageGenerator process(String path, String method) {

    return switch (path) {
      case "/account" -> processAccount();
      case "/transfer" -> processTransfer(method);
      default -> new GreetingPageGenerator();
    };
  }

  private PageGenerator processTransfer(String method) {
    if (method.equals("GET")) {
      return processTransferGet();
    }
    return processTransferPost();
  }

  private AccountPageGenerator processAccount() {
    return new AccountPageGenerator(account);
  }

  private TransferPageGenerator processTransferGet() {
    return new TransferPageGenerator(account);
  }

  private TransferSuccessPageGenerator processTransferPost() {
    transferService.transfer(account.identifier(), "2345",1000);

    return new TransferSuccessPageGenerator(account);
  }
}
