package utils;

import models.Account;

public class AccountPageGenerator extends PageGenerator {
  private Account account;

  public AccountPageGenerator(Account account) {
    this.account = account;
  }

  @Override
  public String html() {
    return "<!DOCTYPE html>\n" +
        "<html lang=\"ko\">\n" +
        "<head>\n" +
        "<title>마카오 뱅크</title>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "</head>\n" +
        "<body>\n" +
        "<p>계좌번호: " + account.identifier() + "</p>\n" +
        "<p>이름: " + account.name() + "</p>\n" +
        "<p>잔액: " + account.amount() + "원</p>\n" +
        "</body>\n" +
        "</html>\n";
  }
}
