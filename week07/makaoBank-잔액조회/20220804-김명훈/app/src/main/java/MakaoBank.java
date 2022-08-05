import com.sun.net.httpserver.HttpServer;
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
    account = new Account("1234","ashal",3000);
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
      PageGenerator pageGenerator = process(path);

      new MessageWriter(exchange).write(pageGenerator.html());

    });
    System.out.println("http://localhost:8000");
    httpServer.start();
  }

  private PageGenerator process(String path) {
    if(path.equals("/account")) {
      return new AccountPageGenerator(account);
    }
    return new GreetingPageGenerator();
  }
}
