package utils;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class MessageWriter {
  private HttpExchange exchange;

  public MessageWriter(HttpExchange exchange) {
    this.exchange = exchange;
  }

  public void write(String html) throws IOException {
    OutputStream outputStream = exchange.getResponseBody();
    outputStream.write(html.getBytes());
    outputStream.flush();
    outputStream.close();
  }
}
