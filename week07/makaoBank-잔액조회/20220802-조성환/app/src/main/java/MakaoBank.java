import com.sun.net.httpserver.HttpServer;
import models.Account;
import services.TransferService;
import utils.AccountPageGenerator;
import utils.FormParser;
import utils.GreetingPageGenerator;
import utils.PageGenerator;
import utils.MessageWriter;
import utils.RequestBodyReader;
import utils.TransferPageGenerator;
import utils.TransferSuccessPageGenerator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class MakaoBank {
  private Account account;
  private TransferService transferService;
  private FormParser formParser;
  private List<Account> accounts;

  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public MakaoBank() {
    formParser = new FormParser();

    accounts = List.of(
        new Account("1234", "ashal", 3000),
        new Account("2345", "Joker", 1000)
    );
    account = accounts.get(0);

    transferService = new TransferService(accounts);
  }

  private void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);

    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {

      //입력

      URI requestURI = exchange.getRequestURI();

      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      String requestBody = new RequestBodyReader(exchange).body();
      Map<String, String> formData = formParser.parse(requestBody);


      // 처리
      PageGenerator pageGenerator = process(path, method, formData);

      //출력

      new MessageWriter(exchange).write(pageGenerator.html());
    });

    httpServer.start();
    System.out.println("http://localhost:8000/");
  }

  private PageGenerator process(String path, String method,
                                Map<String, String> formData) {
    String[] steps = path.substring(1).split("/");

    return switch (steps[0]) {
      case "/account" ->
          processAccount(steps.length > 1 ? steps[1] : account.identifier());
      case "/transfer" -> processTransfer(method, formData);
      default -> new GreetingPageGenerator();
    };
  }

  private AccountPageGenerator processAccount(String identifier) {
    Account found = accounts.stream()
        .filter(account -> account.identifier().equals(identifier))
        .findFirst()
        .orElse(account);

    return new AccountPageGenerator(found);
  }

  private PageGenerator processTransfer(String method,
                                        Map<String, String> formData) {
    if (method.equals("GET")) {
      return processTransferGet();
    }
    return processTransferPost(formData);
  }

  private TransferPageGenerator processTransferGet() {
    return new TransferPageGenerator(account);
  }

  private TransferSuccessPageGenerator processTransferPost(Map<String, String> formData) {
    transferService.transfer(account.identifier(),
        formData.get("to"),
        Long.parseLong(formData.get("amount")));
    //post로 받은 입력 값을 알아야한다.
    //RequestBody로 post의 값을 얻을 수 있었나?
    return new TransferSuccessPageGenerator(account);
  }
}
