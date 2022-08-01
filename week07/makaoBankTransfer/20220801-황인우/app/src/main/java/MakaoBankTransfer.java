import com.sun.net.httpserver.HttpServer;
import models.Account;
import utils.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

public class MakaoBankTransfer {
  private String name;

  private Account account;

  public static void main(String[] args) throws IOException {
    MakaoBankTransfer application = new MakaoBankTransfer();
    application.run();
  }

  public void run() throws IOException {
    account = new Account("352-0528", "Chikorita", 10000);

    InetSocketAddress address = new InetSocketAddress(8000);

    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
      name = path.substring(1);

      PageGenerator pageGenerator = process(path);

      String html = pageGenerator.html();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(html);
    });

    httpServer.start();

    System.out.println("Server is listening... http://localhost:8000");
  }

  public PageGenerator process(String path) {
    return switch (path) {
      case "/Account" -> new AccountPageGenerator(account);
      case "/Transfer" -> new TransferPageGenerator(account);
      default -> new GreetingPageGenerator(name);
    };
  }
}
