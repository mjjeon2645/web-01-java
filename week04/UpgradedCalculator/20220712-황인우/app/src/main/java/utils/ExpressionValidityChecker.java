package utils;

public class ExpressionValidityChecker {
  private final String expression;
  private final String[] words;

  public ExpressionValidityChecker(String expression) {
    this.expression = expression;

    this.words = expression.split(" ");
  }

  public String expression() {
    return this.expression;
  }

  public String[] words() {
    return this.words;
  }

  public boolean checkValidity() {
    if (checkNumberOfWordIs1Or3() == false) {
      return false;
    }

    if (checkIllegalWord() == false) {
      return false;
    }

    return true;
  }

  public boolean checkNumberOfWordIs1Or3() {
    return words.length == 1 || words.length == 3;
  }

  public boolean checkIllegalWord() {
    //words[0], words[2]에 숫자가 아닌 문자가 있으면 false
    if (checkNumberWord(words[0]) == false) {
      return false;
    }

    //words.length가 3인 경우만 수행하고, 1인 경우에는 해당 조건문은 건너뜀
    if (words.length == 3) {
      if (checkNumberWord(words[2]) == false) {
        return false;
      }

      //words[1]에 사칙연산자가 아닌 문자가 있으면 false
      if (checkOperator(words[1]) == false) {
        return false;
      }
    }

    return true;
  }

  private boolean checkOperator(String word) {
    return word.equals("+")
        || word.equals("-")
        || word.equals("*")
        || word.equals("/");
  }

  public boolean checkNumberWord(String word) {
    //System.out.println("word: " + word);

    for (int i = 0; i < word.length(); i += 1) {
      char letter = word.charAt(i);

      //System.out.println("i: " + i + ", letter: " + letter);

      if (i == 0 && !(letter == '-' || (letter >= '0' && letter <= '9'))) {
        return false;
      }

      if (i >= 1 && !(letter >= '0' && letter <= '9')) {
        return false;
      }
    }

    return true;
  }
}
