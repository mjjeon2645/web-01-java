package pages;

public abstract class PageGenerator {
  public String html() {
   return "" +
        "<!DOCTYPE html>\n" +
        "<html lang=\"ko\">\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>마카오 뱅크</title>\n" +
        "</head>\n" +
        "<body>\n" +
        content() +
        "</body>\n" +
        "</html>";
  }

  public abstract String content();
}
