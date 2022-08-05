import com.sun.net.httpserver.*;
import models.*;
import utils.*;

import java.io.*;
import java.net.*;

public class MakaoBank {
  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() throws IOException {
    Account account = new Account("1234","Ashal",3000);

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address,0);

    httpServer.createContext("/",exchange -> {
      //입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      String name = path.substring(1);
      //처리
      PageGenerator pageGenerator = new GreetingPageGenerator(name);

      if(path.equals("/account")) {
        pageGenerator = new AccountPageGenerator(account);
      }
      if(path.equals("/transfer")) {
       //pageGenerator = new TransferPageGenerator
      }

      String content = pageGenerator.html();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);

    });

    System.out.println("http://localhost:8000/");
    httpServer.start();

  }
}
