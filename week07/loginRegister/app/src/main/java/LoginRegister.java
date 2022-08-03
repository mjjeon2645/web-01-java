import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import pages.GreetingPageGenerator;
import pages.LoginPageGenerator;
import pages.PageGenerator;
import pages.RegisterPageGenerator;
import utils.MessageWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Scanner;

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
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
      String[] steps = path.substring(1).split("/");

      // 리퀘스트 바디 내용 확인을 위해 임시 작성
      InputStream inputStream = exchange.getRequestBody();
      Scanner scanner = new Scanner(inputStream);
      if (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(line);
      }

      // 처리
      PageGenerator pageGenerator = new GreetingPageGenerator();

      if (steps[0].equals("login")) {
        pageGenerator = new LoginPageGenerator();
      }

      if (steps[0].equals("registration")) {
        pageGenerator = new RegisterPageGenerator();
      }

      String content = pageGenerator.html();

      // 출력
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });

    httpServer.start();

    System.out.println("http://localhost:8000/");
  }
}
