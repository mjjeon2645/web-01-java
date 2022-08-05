import com.sun.net.httpserver.HttpServer;
import models.Account;
import services.TransferService;
import utils.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

public class MakaoBankTransfer {
  private String name;
  private Account account;
  private TransferService transferService;
  private List<Account> accounts;

  public static void main(String[] args) throws IOException {
    MakaoBankTransfer application = new MakaoBankTransfer();
    application.run();
  }

  public void run() throws IOException {
    accounts = List.of(
        new Account("352", "치코리타", 10000),
        new Account("179", "파이리", 10000)
    );
    account = accounts.get(0);

    transferService = new TransferService(accounts);

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      // 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
      name = path.substring(1);

      String method = exchange.getRequestMethod();

      //처리
      PageGenerator pageGenerator = process(path, method);

      String content = pageGenerator.html();

      exchange.sendResponseHeaders(200, content.getBytes().length);

      // 출력
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });

    httpServer.start();

    System.out.println("Server is listening... http://localhost:8000/");
  }

  private PageGenerator process(String path, String method) {
    return switch (path) {
      case "/Account" -> processAccount();
      case "/Transfer" -> processTransfer(method);
      default -> new GreetingPageGenerator(name);
    };
  }

  private PageGenerator processAccount() {
    return new AccountPageGenerator(account);
  }

  private PageGenerator processTransfer(String method) {
    if (method.equals("GET")) {
      return processTransferGet();
    }
    return processTransferPost();
  }

  private PageGenerator processTransferGet() {
    return new TransferPageGenerator(account);
  }

  private PageGenerator processTransferPost() {
    transferService.transfer("352", "179", 1000);

    return new TransferSuccessPageGenerator();
  }
}
