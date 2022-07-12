package utils;

public class ExpressionValidityChecker {
  private String expression;
  private String[] words;

  public String expression() {
    return this.expression;
  }

  public String[] words() {
    return this.words;
  }

  public void setAndSplitExpression(String expression) {
    this.expression = expression;
    this.words = expression.split(" ");
  }

  public boolean checkValidity(String expression) {
    setAndSplitExpression(expression);

    if (checkNumberOfWords() == false) {
      return false;
    }

    if (checkIllegalWord() == false) {
      return false;
    }

    return true;
  }

  public boolean checkNumberOfWords() {
    return words.length == 1 || words.length == 3;
  }

  public boolean checkIllegalWord() {
    //words[0], words[2]에 숫자가 아닌 문자가 있으면 false
    if (words[0].matches("[0-9]+") == false) {
      return false;
    }

    //
    if (words.length == 3) {
      if (words[2].matches("[0-9]+") == false) {
        return false;
      }

      //words[1]에 사칙연산자가 아닌 문자가 있으면 false
      if ((words[1].equals("+") || words[1].equals("-") ||
          words[1].equals("*") || words[1].equals("/")) == false) {
        return false;
      }
    }

    return true;
  }
}
