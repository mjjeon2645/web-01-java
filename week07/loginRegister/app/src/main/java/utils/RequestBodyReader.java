package utils;

import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;
import java.util.Scanner;

public class RequestBodyReader {
  private final HttpExchange exchange;

  public RequestBodyReader(HttpExchange exchange) {
    this.exchange = exchange;
  }

  public String body() {
    InputStream inputStream = exchange.getRequestBody();

    Scanner scanner = new Scanner(inputStream);

    String line = "";

    while (scanner.hasNextLine()) {
      line += scanner.nextLine() + "&";
    }

    if (!line.isEmpty()) {
      line = line.substring(0, line.length() - 1);
    }

    return line;
  }
}
