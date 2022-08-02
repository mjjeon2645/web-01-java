package utils;

public abstract class PageGenerator {

  public String html()  {
    return "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title> makaoBank</title>\n" +
        "<body>\n" +
        navigation() +
        content() +
        "</body>\n" +
        "<html>";
  }

  private String navigation() {
    return
        "<nav>" +
        "<a href=\"/\">홈으로</a>\n" +
        "<a href=\"/account\">잔액 조회</a>\n" +
        "<a href=\"/transfer\">송금</a>\n" +
        "</nav>\n";
  }

  protected abstract String content();
}
