import com.sun.net.httpserver.*;
import models.*;
import pages.*;
import utils.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class MakaoBank {
  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() throws IOException {
    Account account = new Account("1234", "ashal", 3000);
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
      String method = exchange.getRequestMethod();
      String name = path.substring(1);

      RequestBodyReader requestBodyReader = new RequestBodyReader(exchange);

      String requestBody = requestBodyReader.body();
      FormParser formParser = new FormParser();

      Map<String,String> formData = formParser.parse(requestBody);

      PageGenerator pageGenerator = new GreetingPageGenerator(name);
      if (path.equals("/account")) {
        pageGenerator = new AccountPageGenerator(account);
      }
      if (path.equals("/transfer")) {
        pageGenerator = method.equals("GET")
            ? new TransferPageGenerator(account)
            : new TransferSuccessPageGenerator(account);
      }

      String content = pageGenerator.html();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);

    });

    System.out.println("http://localhost:8000");
    httpServer.start();

  }
}
