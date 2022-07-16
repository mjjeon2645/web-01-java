public class ExpressionVerifier {
  private String[] words;

  public boolean verifyException(String text) {
    splitWords(text);

    if (!isNumber(words[0])) {
      return false;
    }

    if (words.length == 1) {
      return true;
    }

    if (words.length != 3) {
      return false;
    }

    String operator = words[1];
    if (!isRightOperator(operator)) {
      return false;
    }

    if (!isNumber(words[2])) {
      return false;
    }

    return true;
  }

  public void splitWords(String text) {
    this.words = text.split(" ");
  }

  public boolean isNumber(String word) {
    for(int i = 0; i < word.length(); i += 1) {
      if(!Character.isDigit(word.charAt(i))) {
        return false;
      }
    }
    return true;
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
