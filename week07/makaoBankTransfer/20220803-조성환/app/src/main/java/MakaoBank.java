import com.sun.net.httpserver.HttpServer;
import models.Account;
import utils.AccountPageGenerator;
import utils.GreetingPageGenerator;
import utils.MessageWriter;
import utils.PageGenerator;
import utils.TransferPageGenerator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

public class MakaoBank {
  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {

      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      PageGenerator pageGenerator = new GreetingPageGenerator();

      Account account = new Account("1234", "Ashal", 3000);

      if (path.equals("/account")) {
        pageGenerator = new AccountPageGenerator(account);
      }

      if (path.equals("/transfer")) {
        pageGenerator = new TransferPageGenerator(account);
      }

      String content = pageGenerator.html();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });
    httpServer.start();
    System.out.println("http://localhost:8000");
  }
}
