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

//    넣어줄 필요가 있을까?
//    if (!scanner.hasNextLine()) {
//      return "";
//    }

    while (scanner.hasNextLine()) {
      line += scanner.nextLine() + "&";
    }

    // 가장 마지막 줄에 붙은 앤드 표시 삭제
    if (!line.isEmpty()) {
      line = line.substring(0, line.length() - 1);
    }

    return line;
  }
}
