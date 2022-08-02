package utils;

import com.sun.net.httpserver.*;

import java.io.*;
import java.util.*;

public class RequestBodyReader {
  private HttpExchange exchange;

  public RequestBodyReader(HttpExchange exchange) {

    this.exchange = exchange;
  }

  public String body() {
    InputStream inputStream = exchange.getRequestBody();
    Scanner scanner = new Scanner(inputStream);

    if(!scanner.hasNextLine()) {
      return "";
    }

    return scanner.nextLine();
  }
}
