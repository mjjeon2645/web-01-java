package utils;

public abstract class PageGenerator {


  public String html() {
    return
    "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>makaoBank</title>\n" +
        "</head>\n" +
        "<body>\n" +
        content() +
        "</body>\n" +
        "</html>";
  }

  public abstract  String content();

}
