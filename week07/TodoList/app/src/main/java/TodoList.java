import com.sun.net.httpserver.HttpServer;
import models.Task;
import pages.PageGenerator;
import pages.TasksPageGenerator;
import utils.MessageWriter;
import utils.RequestBodyReader;
import utils.TasksLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

public class TodoList {
  private List<Task> tasks;
  private TasksLoader tasksLoader;

  public static void main(String[] args) throws IOException {
    TodoList application = new TodoList();
    application.run();
  }

  public TodoList() throws FileNotFoundException {
    tasksLoader = new TasksLoader();
    tasks = tasksLoader.load();
  }

  public void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);

    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {

      // 입력
      String method = exchange.getRequestMethod();

      RequestBodyReader requestBodyReader = new RequestBodyReader(exchange);

      String text = requestBodyReader.body();

      // 처리
      processWithMethod(method, text);

      PageGenerator pageGenerator = new TasksPageGenerator(tasks);

      // 출력
      new MessageWriter(exchange).write(pageGenerator.html());
    });

    httpServer.start();

    System.out.println("http://localhost:8000");
  }

  public void processWithMethod(String method, String text) throws IOException {
    if (method.equals("POST")) {
      tasks.add(new Task(text));
      tasksLoader.save(tasks);
    }
  }
}
