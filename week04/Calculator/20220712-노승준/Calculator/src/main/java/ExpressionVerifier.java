public class ExpressionVerifier {
  private String[] words;

  public boolean handleException(String text) {
    splitWords(text);

    if (!isMatchesFirstWordNumber()) {
      return false;
    }

    if (words.length != 3) {
      if (words.length == 1) {
        if (!isMatchesFirstWordNumber()) {
          return false;
        }
        return true;
      }
      return false;
    }

    if (!isMatchesLastWordNumber()) {
      return false;
    }

    String operator = words[1];

    if (!isRightOperator(operator)) {
      return false;
    }

    return true;
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

  public boolean isRightOperator(String symbol) {
    String[] operators = new String[]{"+", "-", "*", "/"};
    for(String operator : operators) {
      if(symbol.equals(operator)) {
        return true;
      }
    }
    return false;
  }
}
