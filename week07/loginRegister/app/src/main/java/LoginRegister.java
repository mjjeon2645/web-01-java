import com.sun.net.httpserver.HttpServer;
import models.User;
import pages.*;
import repositories.UserRepository;
import services.UserService;
import utils.FormParser;
import utils.MessageWriter;
import utils.RequestBodyReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

public class LoginRegister {
  private final UserRepository userRepository;
  private UserService userService;
  private FormParser formParser;

  public static void main(String[] args) throws IOException {
    LoginRegister application = new LoginRegister();
    application.run();
  }

  public LoginRegister() throws FileNotFoundException {
    userRepository = new UserRepository();
    userService = new UserService(userRepository);
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
      case "registration" -> processRegistration(method, formData, userRepository);
      default -> new GreetingPageGenerator();
    };
  }

  public PageGenerator processLogin(String method, Map<String, String> formData) {
    if (method.equals("GET")) {
      return new LoginPageGenerator();
    }
    return processLoginPost(formData);
  }

  public PageGenerator processLoginPost(Map<String, String> formData) {
    String status = new UserService(userRepository).loginValidator(formData);
    if (status.equals(UserService.LOGIN_APPROVED)) {
      String name = userRepository.find(formData.get("id")).name();
      return new MainPageGenerator(name);
    }
    return new LoginErrorPageGenerator(status);
  }

  public PageGenerator processRegistration(String method, Map<String, String> formData,
                                           UserRepository userRepository) throws IOException {
    if (method.equals("GET")) {
      return new RegisterPageGenerator();
    }
    return processRegistrationPost(formData, userRepository);
  }

  public PageGenerator processRegistrationPost(Map<String, String> formData,
                                               UserRepository userRepository) throws IOException {
    String status = new UserService(userRepository).registerValidator(formData);
    if (status.equals(UserService.REGISTER_APPROVED)) {
      User user = userService.initUser(formData);
      userService.register(user);
      return new RegisterSuccessPageGenerator();
    }
    return new RegisterErrorPageGenerator(status);
  }
}
