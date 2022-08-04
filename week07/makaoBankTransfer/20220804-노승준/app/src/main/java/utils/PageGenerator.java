package utils;

public abstract class PageGenerator {

  public String html() {
    return "<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
        "<meta charset=\"UTF-8\">" +
        "<title>Makao Bank</title>" +
        "</head>" +
        "<body>" +
        navigation() +
        content() +
        "</body>" +
        "</html>";
  }

  public abstract String content();

  private String navigation() {
    return "<nav>" +
        "<a href=\"/\">홈으로</a>\n" +
        "<a href=\"/account\">잔액 조회</a>\n" +
        "<a href=\"/transfer\">송금</a>\n" +
        "<a href=\"transaction\">거래 내역</a>\n" +
        "</nav>\n";
  }
}
