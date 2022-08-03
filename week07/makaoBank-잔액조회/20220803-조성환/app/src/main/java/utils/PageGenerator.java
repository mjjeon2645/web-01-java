package utils;

public abstract class PageGenerator {
  public String html() {
    return "<!DOCTYPE html>\n" +
        "<html lang=\"ko\">\n" +
        "<head>\n" +
        "<title>마카오 뱅크</title>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "</head>\n" +
        "<body>\n" +
        content() +
        "</body>\n" +
        "</html>\n";
  }

  public abstract String content();
}
