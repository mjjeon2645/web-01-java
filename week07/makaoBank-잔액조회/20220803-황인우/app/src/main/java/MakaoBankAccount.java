import com.sun.net.httpserver.HttpServer;
import models.Account;
import utils.AccountPageGenerator;
import utils.GreetingPageGenerator;
import utils.MessageWriter;
import utils.PageGenerator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

public class MakaoBankAccount {
  public static void main(String[] args) throws IOException {
    MakaoBankAccount application = new MakaoBankAccount();
    application.run();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      URI uri = exchange.getRequestURI();
      String path = uri.getPath();
      String name = path.substring(1);

      PageGenerator pageGenerator = new GreetingPageGenerator(name);
      if (path.equals("/Account")) {
        Account account = new Account("110", "레드", 10000);
        pageGenerator = new AccountPageGenerator(account);
      }
      String html = pageGenerator.html();

      exchange.sendResponseHeaders(200, html.getBytes().length);

      new MessageWriter(exchange).write(html);
    });

    httpServer.start();

    System.out.println("Server is listening... http://localhost:8000/");
  }
}
