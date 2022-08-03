import com.sun.net.httpserver.HttpServer;
import models.Account;
import services.TransferService;
import utils.AccountPageGenerator;
import utils.FormParser;
import utils.GreetingPageGenerator;
import utils.MessageWriter;
import utils.PageGenerator;
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

  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() throws IOException {
    List<Account> accounts = List.of(
        new Account("1234", "Ashal", 3000),
        new Account("2345", "JOKER", 1000)
    );
    account = accounts.get(0);

    transferService = new TransferService(accounts);

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {

      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      String method = exchange.getRequestMethod();

      RequestBodyReader requestBodyReader = new RequestBodyReader(exchange);
       String requestBody = requestBodyReader.body();

      FormParser formParser = new FormParser();
      Map<String, String> formData = formParser.parse(requestBody);


      PageGenerator pageGenerator = process(path, method,formData);

      String content = pageGenerator.html();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);
    });
    httpServer.start();
    System.out.println("http://localhost:8000");
  }

  private PageGenerator process(String path, String method,
                                Map<String,String> formData) {

    return switch (path) {
      case "/account" -> processAccount();
      case "/transfer" -> processTransfer(method,formData);
      default -> new GreetingPageGenerator();
    };
  }

  private PageGenerator processTransfer(String method,
                                        Map<String,String> formData) {
    if (method.equals("GET")) {
      return processTransferGet();
    }
    return processTransferPost(formData);
  }

  private AccountPageGenerator processAccount() {
    return new AccountPageGenerator(account);
  }

  private TransferPageGenerator processTransferGet() {
    return new TransferPageGenerator(account);
  }

  private TransferSuccessPageGenerator processTransferPost(
      Map<String,String> formData) {
    transferService.transfer(account.identifier(),
        formData.get("to") ,
        Long.parseLong(formData.get("amount")));

    return new TransferSuccessPageGenerator(account);
  }
}
