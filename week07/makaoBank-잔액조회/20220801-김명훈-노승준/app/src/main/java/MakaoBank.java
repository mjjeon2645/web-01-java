import com.sun.net.httpserver.*;
import models.*;
import utils.*;

import java.io.*;
import java.net.*;

public class MakaoBank {
  private Account account;

  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() throws IOException {
    account = new Account("1234", "Ashal", 3000);

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      PageGenerator pageGenerator = new GreetingPageGenerator();
      if (path.equals("/account")) {
        pageGenerator = new AccountPageGenerator(account);
      }

      String content = pageGenerator.html();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });

    System.out.print("Server is Listening .. " + "http://localhost:8000");
    httpServer.start();
  }
}
