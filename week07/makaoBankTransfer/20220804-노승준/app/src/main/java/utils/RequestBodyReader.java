package utils;

import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;
import java.util.Scanner;

public class RequestBodyReader {
  private HttpExchange exchange;

  public RequestBodyReader(HttpExchange exchange) {

    this.exchange = exchange;
  }

  public String body() {
    InputStream requestBody = exchange.getRequestBody();
    Scanner scanner = new Scanner(requestBody);
    if (!scanner.hasNextLine()) {
      return "";
    }

    return scanner.nextLine();
  }
}
