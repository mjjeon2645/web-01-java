import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import pages.GreetingPageGenerator;
import pages.PageGenerator;
import utils.MessageWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class LoginRegister {
  public static void main(String[] args) throws IOException {
    LoginRegister application = new LoginRegister();
    application.run();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);
    httpServer.createContext("/", exchange -> {

      // 입력

      //TODO. 입력란 추후 작성

      // 처리
      PageGenerator pageGenerator = new GreetingPageGenerator();

      String content = pageGenerator.html();

      // 출력
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });

    httpServer.start();

    System.out.println("http://localhost:8000/");
  }
}
