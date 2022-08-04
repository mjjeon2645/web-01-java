import com.sun.net.httpserver.HttpServer;
import models.Account;
import pages.*;
import utils.FormParser;
import utils.MessageWriter;
import utils.AccountsLoader;
import utils.RequestBodyReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginRegister {
  private List<Account> accounts = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    LoginRegister application = new LoginRegister();
    application.run();
  }

  public LoginRegister() throws FileNotFoundException {
    accounts = new AccountsLoader().load();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);
    httpServer.createContext("/", exchange -> {

      // 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      RequestBodyReader requestBodyReader = new RequestBodyReader(exchange);
      String requestBody = requestBodyReader.body();

      System.out.println(requestBody);

      FormParser formParser = new FormParser();

      Map<String, String> formData = formParser.parse(requestBody);

      // 처리
      PageGenerator pageGenerator = process(path, method, formData);

      // 출력
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(pageGenerator.html());
    });

    httpServer.start();

    System.out.println("http://localhost:8000/");
  }

  private PageGenerator process(String path, String method, Map<String, String> formData) {
    String[] steps = path.substring(1).split("/");

    return switch (steps[0]) {
      case "login" -> processLogin(method);
      case "registration" -> processRegistration(method);
      default -> new GreetingPageGenerator();
    };
  }

  public PageGenerator processLogin(String method) {
    if (method.equals("GET")) {
      return new LoginPageGenerator();
    }
    if (비밀번호가 틀렸을 경우) {
      return new WrongPasswordPageGenerator();
    }
    // 사용자 아이디가 존재하지 않을 경우
    return new LoginSuccessPageGenerator();
  }

  public PageGenerator processRegistration(String method) {
    if (method.equals("GET")) {
      return new RegisterPageGenerator();
    }

    if (아이디가 중복일 경우) {
      return new DuplicatedIdPageGenerator();
    }

    if (비밀번호 재확인이 비밀번호와 다를 경우) {
      return new PasswordNotConfirmedPageGenerator();
    }

    if (정보를 모두 입력하지 않고 회원가입 한 경우) {
      return new MissingInformationPageGenerator();
    }
    return new RegisterSuccessPageGenerator();
  }
}
