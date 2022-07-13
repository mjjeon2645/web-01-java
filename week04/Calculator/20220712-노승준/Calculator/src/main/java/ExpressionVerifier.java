public class ExpressionVerifier {
  public boolean keepCalculate = true;
  private String[] words;

  public boolean isKeepCalculate() {
    return this.keepCalculate;
  }

  public String[] words() {
    return words;
  }

  public String exceptionHandling(String text) {
    splitWords(text);

    if (!isMatchesFirstWordNumber()) {
      stopCalculate();
      return displayWrongExpression(text);
    }

    if (isNotWordsLengthThree()) {
      if (isaWordsLengthOne()) {
        return words[0];
      }
      stopCalculate();
      return displayWrongExpression(text);
    }

    if (!isMatchesLastWordNumber()) {
      stopCalculate();
      return displayWrongExpression(text);
    }

    String operator = words[1];

    if (!isRightOperator(operator)) {
      stopCalculate();
      return displayWrongExpression(text);
    }

    return "Result: " + text;
  }

  public void splitWords(String text) {
    this.words = text.split(" ");
  }

  public boolean isMatchesFirstWordNumber() {
    return words[0].matches("-?[0-9]+");
  }

  public boolean isMatchesLastWordNumber() {
    return words[2].matches("-?[0-9]+");
  }

  public boolean isNotWordsLengthThree() {
    return words.length != 3;
  }

  public boolean isaWordsLengthOne() {
    return words.length == 1;
  }

  public boolean isRightOperator(String operator) {
    return operator.equals("+") ||
        operator.equals("-") ||
        operator.equals("*") ||
        operator.equals("/");
  }

  public void stopCalculate() {
    this.keepCalculate = false;
  }

  public String displayWrongExpression(String text) {
    return "수식 오류: " + text;
  }
}
