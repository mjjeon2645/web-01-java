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

    accountsLoader = new AccountsLoader();

    formParser = new FormParser();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);
    httpServer.createContext("/", exchange -> {

      // 입력
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      String requestBody = new RequestBodyReader(exchange).body();
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

  public PageGenerator process(String path, String method,
                               Map<String, String> formData) throws IOException {

    return switch (path.substring(1)) {
      case "login" -> processLogin(method, formData);
      case "registration" -> processRegistration(method, formData, accountRepository);
      default -> new GreetingPageGenerator();
    };
  }

  public PageGenerator processLogin(String method, Map<String, String> formData) {
    if (method.equals("GET")) {
      return processLoginGet();
    }
    return processLoginPost(formData);
  }

  public LoginPageGenerator processLoginGet() {
    return new LoginPageGenerator();
  }

  public PageGenerator processLoginPost(Map<String, String> formData) {
    Account loginAccount = accountRepository.find(formData.get("id"));

    // 입력정보 누락
    if (!(formData.size() == 2)) {
      return new LoginDataMissedPageGenerator();
    }

    // 사용자 아이디가 존재하지 않을 경우
    if (loginAccount == null) {
      return new IdNotFoundPageGenerator();
    }

    // 비밀번호가 틀렸을 경우
    if (!loginAccount.password().equals((formData.get("password")))) {
      return new WrongPasswordPageGenerator();
    }

    // 모든게 성공적일 경우, 이름을 넣어 say Hello!
    String name = loginAccount.name();
    return new LoginSuccessPageGenerator(name);
  }

  public PageGenerator processRegistration(String method,
                                           Map<String, String> formData,
                                           AccountRepository accountRepository) throws IOException {
    if (method.equals("GET")) {
      return processRegistrationGet();
    }
    return processRegistrationPost(formData, accountRepository);
  }

  public RegisterPageGenerator processRegistrationGet() {
    return new RegisterPageGenerator();
  }

  public PageGenerator processRegistrationPost(Map<String, String> formData,
                                               AccountRepository accountRepository) throws IOException {
    // 입력정보 누락
    if (!(formData.size() == 5)) {
      return new RegisterDataMissedPageGenerator();
    }

    // 비밀번호 재확인이 다를 떄
    if (!(formData.get("password").equals(formData.get("check-password")))) {
      return new PasswordNotConfirmedPageGenerator();
    }

    // 이미 등록되어 있는 아이디일 때
    if (!(accountRepository.find(formData.get("id")) == null)) {
      return new DuplicatedIdPageGenerator();
    }

    // 성공 페이지를 출력해주기 전에 "진짜 처리". 폼데이터를 활용해 (1) 신규 어카운트 생성,
    // (2) 리파지토리에 넣어주고, (3) 그 리파지토리에서 관리하는  accounts를 csv 파일에 써주고!
    Account account = new Account(
        formData.get("name"),
        formData.get("id"),
        formData.get("password"),
        formData.get("email"));

    accountRepository.accounts().put(account.id(), account);

    accountsLoader.save(accountRepository.accounts());

    return new RegisterSuccessPageGenerator();
  }
}
