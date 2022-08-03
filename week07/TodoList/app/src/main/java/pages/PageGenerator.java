package pages;

public abstract class PageGenerator {
  public String html() {
    return "" +
        "<!DOCTYPE html>\n" +
        "<html lang=\"ko\">\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>Todo List</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h1>Todo List</h1>\n" +
        "<form method=\"POST\" enctype=\"text/plain\">\n" +
        "<p>\n" +
        "할 일: \n" +
        "<input type=\"text\" name=\"todo\" />\n" +
        "<button type=\"submit\">등록 </button>\n" +
        "</p>\n" +
        "</form>\n" +
        showTasks() +
        "</body>\n" +
        "</html>";
  }

  public abstract String showTasks();
}
