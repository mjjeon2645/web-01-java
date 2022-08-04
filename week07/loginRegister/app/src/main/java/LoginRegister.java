import com.sun.net.httpserver.HttpServer;
import models.Account;
import pages.*;
import repositories.AccountRepository;
import utils.AccountsLoader;
import utils.FormParser;
import utils.MessageWriter;
import utils.RequestBodyReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

public class LoginRegister {

  private final AccountRepository accountRepository;
  private AccountsLoader accountsLoader;
  private FormParser formParser;

  public static void main(String[] args) throws IOException {
    LoginRegister application = new LoginRegister();
    application.run();
  }

  public LoginRegister() throws FileNotFoundException {
    accountRepository = new AccountRepository();
    formParser = new FormParser();
    accountsLoader = new AccountsLoader();
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

  public PageGenerator process(String path, String method, Map<String, String> formData) throws IOException {
    String[] steps = path.substring(1).split("/");

    return switch (steps[0]) {
      case "login" -> processLogin(method, formData);
      case "registration" -> processRegistration(method, formData, accountRepository);
      default -> new GreetingPageGenerator();
    };
  }

  public PageGenerator processLogin(String method, Map<String, String> formData) {
    if (method.equals("GET")) {
      return new LoginPageGenerator();
    }

    //사용자 아이디가 존재하지 않을 경우
    if (accountRepository.find(formData.get("id")) == null) {
      return new IdNotFoundPageGenerator();
    }

    // 비밀번호가 틀렸을 경우
    if (!(accountRepository.find(formData.get("id")).password().equals((formData.get("password"))))) {
      return new WrongPasswordPageGenerator();
    }

    String name = accountRepository.find(formData.get("id")).name();
    return new LoginSuccessPageGenerator(name);
  }


  public PageGenerator processRegistration(String method, Map<String, String> formData,
                                           AccountRepository accountRepository) throws IOException {
    if (method.equals("GET")) {
      return new RegisterPageGenerator();
    }

    // 정보 미싱
    if (!(formData.size() == 5)) {
      return new MissingInformationPageGenerator();
    }

    // 비밀번호 재확인이 다를 떄
    if (!(formData.get("password").equals(formData.get("check-password")))) {
      return new PasswordNotConfirmedPageGenerator();
    }

    // 이미 등록되어 있는 아이디일 때
   if (!(accountRepository.find(formData.get("id")) == null)) {
      return new DuplicatedIdPageGenerator();
    }

    // 성공 페이지를 출력해주기 전에 "진짜 처리". 즉 성공 뿐만이 아니라 해당 폼데이터에서 받아온 값을
    // (1)리파지토리에 넣어주고, (2) 그 리파지토리의 accounts를 csv 파일에 써주고!
    Account account = new Account(formData.get("name"),
        formData.get("id"),
        formData.get("password"),
        formData.get("email"));
    accountRepository.accounts().put(account.id(), account);
    accountsLoader.save(accountRepository.accounts());

    return new RegisterSuccessPageGenerator();
  }
}
