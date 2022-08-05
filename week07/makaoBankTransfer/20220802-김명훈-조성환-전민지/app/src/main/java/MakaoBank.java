import com.sun.net.httpserver.HttpServer;
import models.Account;
import services.TransferService;
import utils.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

public class MakaoBank {
  private Account account;
  private TransferService transferService;

  public static void main(String[] args) throws IOException {
    MakaoBank makaoBank = new MakaoBank();
    makaoBank.run();
  }

  public void run() throws IOException {
    List<Account> accounts = List.of(
        new Account("1234", "Ashal", 3000),
        new Account("2345", "JOKER", 1000)
    );

    account = accounts.get(0);

    transferService = new TransferService(accounts);

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", (exchange) -> {

      // 1. 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      // 2. 처리      
      PageGenerator pageGenerator = process(path, method);

      String content = pageGenerator.html();

      // 3. 출력
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });

    httpServer.start();

    System.out.println("http://localhost:8000/");
  }

  public PageGenerator process(String path, String method) {
    return switch (path) {
      case "/account" -> processAccount();
      case "/transfer" -> processTransfer(method);
      default -> new GreetingPageGenerator();
    };
  }

  public AccountPageGenerator processAccount() {
    return new AccountPageGenerator(account);
  }

  public PageGenerator processTransfer(String method) {
    if (method.equals("GET")) {
      return processTransferGet();
    }
    return processTransferPost();
  }

  public TransferPageGenerator processTransferGet() {
    return new TransferPageGenerator(account);
  }

  public TransferSuccessPageGenerator processTransferPost() {
    transferService.transfer("1234", "2345", 1000);

    return new TransferSuccessPageGenerator(account);
  }
}
