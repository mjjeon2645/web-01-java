import Services.TransferService;
import com.sun.net.httpserver.HttpServer;
import models.Account;
import repositories.AccountRepository;
import utils.AccountPageGenerator;
import utils.FormParser;
import utils.GreetingPageGenerator;
import utils.PageGenerator;
import utils.MessageWriter;
import utils.RequestBodyReader;
import utils.TransferPageGenerator;
import utils.TransferProcessSuccessPageGenerator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

public class MakaoBank {
  private final FormParser formParser;

  private final String accountIdentifier = "1234";
  private final TransferService transferService;
  private final AccountRepository accountRepository;

  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public MakaoBank() {
    formParser = new FormParser();

    accountRepository = new AccountRepository();

    transferService = new TransferService(accountRepository);
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

      //처리
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
      case "/account" -> processAccount(steps.length > 1 ? steps[1] : "");
      case "/transfer" -> processTransfer(method, formData);
      default -> new GreetingPageGenerator();
    };
  }

  private PageGenerator processTransfer(String method,
                                        Map<String, String> formData) {
    if (method.equals("GET")) {
      return processTransferGet();
    }

    return processTransferPost(formData);
  }

  private AccountPageGenerator processAccount(String identifier) {
    Account account = accountRepository.find(identifier, accountIdentifier);

    return new AccountPageGenerator(account);
  }

  private TransferPageGenerator processTransferGet() {
    Account account = accountRepository.find(accountIdentifier);
    return new TransferPageGenerator(account);
  }

  private TransferProcessSuccessPageGenerator processTransferPost(
      Map<String, String> formData) {
    transferService.transfer(
        accountIdentifier,
        formData.get("to"),
        Long.parseLong(formData.get("amount")));

    Account account = accountRepository.find(accountIdentifier);

    return new TransferProcessSuccessPageGenerator(account);
  }
}
