import com.sun.net.httpserver.HttpServer;
import pages.*;
import repositories.AccountRepository;
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

  public static void main(String[] args) throws IOException {
    LoginRegister application = new LoginRegister();
    application.run();
  }

  public LoginRegister() throws FileNotFoundException {
    accountRepository = new AccountRepository();
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
      case "login" -> processLogin(method, formData);
      case "registration" -> processRegistration(method, formData, accountRepository);
      default -> new GreetingPageGenerator();
    };
  }

  public PageGenerator processLogin(String method, Map<String, String> formData) {
    if (method.equals("GET")) {
      return new LoginPageGenerator();
    }
//    if (비밀번호가 틀렸을 경우) {
//      return new WrongPasswordPageGenerator();
//    }
//     사용자 아이디가 존재하지 않을 경우
    return new LoginSuccessPageGenerator();
  }

  public PageGenerator processRegistration(String method, Map<String, String> formData,
                                           AccountRepository accountRepository) {
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

    // TODO. 구현 필요. 아이디 중복 -> 레포지토리에서 관리하는 accounts 데이터의 상태가 Map<id, account>라면 가능할듯!
    // formData.get("id")와 map의 아이디를 비교해서 동일한 것이 있다면 중복된 아이디라는 말이니까 얘를 뱉어내주면 되겠다.
    if ((formData.get("id"))) {
      return new DuplicatedIdPageGenerator();
    }

    // TODO. 성공 페이지를 출력해주기 전에 "진짜 처리". 즉 성공 뿐만이 아니라 해당 폼데이터에서 받아온 값을 (1)csv 파일에도 써주고, (2) 어카운츠 리스트에도 넣어주고!
    return new RegisterSuccessPageGenerator();
  }
}
