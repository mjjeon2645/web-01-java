import com.sun.net.httpserver.HttpServer;
import models.Account;
import utils.AccountPageGenerator;
import utils.GreetingPageGenerator;
import utils.PageGenerator;
import utils.MessageWriter;
import utils.TransferPageGenerator;
import utils.TransferProcessPageGenerator;

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
      // 1. 입력

      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      // 2. 처리

      PageGenerator pageGenerator = new GreetingPageGenerator();

      Account account = new Account("1234", "ashal", 3000);

      switch (path) {
        case "/account" -> new AccountPageGenerator(account);
        case "/transfer" -> method.equals("GET") ?
            new TransferPageGenerator(account) :
            new TransferProcessPageGenerator(account);
        default -> new GreetingPageGenerator();
      }

      String content = pageGenerator.html();

      // 3. 출력

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });

    System.out.println("켜저라! http://localhost:8000");
    httpServer.start();
  }
}
