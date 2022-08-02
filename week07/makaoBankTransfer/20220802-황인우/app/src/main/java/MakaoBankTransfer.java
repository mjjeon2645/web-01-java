import com.sun.net.httpserver.HttpServer;
import models.Account;
import utils.AccountPageGenerator;
import utils.GreetingPageGenerator;
import utils.MessageWriter;
import utils.PageGenerator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

public class MakaoBankTransfer {
  private String name;

  public static void main(String args[]) throws IOException {
    MakaoBankTransfer application = new MakaoBankTransfer();
    application.run();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      // 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
      name = path.substring(1);

      //처리
      PageGenerator pageGenerator = new GreetingPageGenerator(name);

      if (path.equals("/Account")) {
        Account account = new Account("352", "치코리타", 10000);
        pageGenerator = new AccountPageGenerator(account);
      }

      String content = pageGenerator.html();

      exchange.sendResponseHeaders(200, content.getBytes().length);

      // 출력
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });

    httpServer.start();

    System.out.println("Server is listening... http://localhost:8000/");
  }
}
