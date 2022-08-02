import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import models.Task;
import pages.PageGenerator;
import pages.TasksPageGenerator;
import utils.MessageWriter;
import utils.TasksLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
  private List<Task> tasks;

  public static void main(String[] args) throws IOException {
    TodoList application = new TodoList();
    application.run();
  }

  public TodoList() throws FileNotFoundException {
    TasksLoader tasksLoader = new TasksLoader();
    tasks = tasksLoader.load();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);

    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {

      // 입력

      // 처리
      PageGenerator pageGenerator = new TasksPageGenerator(tasks);

      // 출력
      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(pageGenerator.html());
    });

    httpServer.start();

    System.out.println("http://localhost:8000");
  }
}
