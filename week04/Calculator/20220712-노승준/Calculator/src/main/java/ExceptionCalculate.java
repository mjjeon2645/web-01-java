public class ExceptionCalculate {
  public boolean keepCalculate = true;
  private String[] words;

  public boolean isKeepCalculate() {
    return this.keepCalculate;
  }

  public String exceptionHandling(String text) {
    splitWords(text);

    if (words.length != 3) {
      if (words.length == 1) {
        return words[0];
      }
      stopCalculate();
      return displayWrongExpression(text);
    }

    if (!words[0].matches("-?[0-9]{1,5}")) {
      stopCalculate();
      return displayWrongExpression(text);
    }

    String operator = words[1];

    if (!(operator.equals("+") ||
        operator.equals("-") ||
        operator.equals("*") ||
        operator.equals("/"))) {
      stopCalculate();
      return displayWrongExpression(text);
    }

    return "Result: " + text;
  }

  public void splitWords(String text) {
    this.words = text.split(" ");
  }

  public void stopCalculate() {
    this.keepCalculate = false;
  }

  public String displayWrongExpression(String text) {
    return "수식 오류: " + text;
  }
}
