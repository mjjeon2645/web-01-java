package utils;

public abstract class PageGenerator {
  public String html() {
    return "<!DOCTYPE html>\n" +
        "<html" +
        "<head>\n" +
        "<meta charset=\"UTF-8\" />\n" +
        "<title>Makao Bank</title>\n" +
        "</head>\n" +
        "<body>\n" +
        content() +
        "</body>\n" +
        "</html>";
  }

  public abstract String content();
}
