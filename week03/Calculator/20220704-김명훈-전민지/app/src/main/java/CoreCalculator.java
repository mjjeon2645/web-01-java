public class CoreCalculator {
  public final static String[] OPERATORS = new String[]{"+", "-", "*", "/", "="};


  // 핵심
  private long currentNumber = 0;
  private long accumulator = 0;
  private String currentOperator = "";

  public long getCurrentNumber() {
    return currentNumber;
  }

  public long getAccumulator() {
    return accumulator;
  }

  public void calculate() {
    switch (currentOperator) {
      case "" -> accumulator = currentNumber;
      case "+" -> accumulator += currentNumber;
      case "-" -> accumulator -= currentNumber;
      case "*" -> accumulator *= currentNumber;
      case "/" -> accumulator /= currentNumber;
    }
    currentNumber = 0;
  }

  public void addNumbers(int number) {
    currentNumber *= 10;
    currentNumber += number;
  }

  public void updateOperator(String operator) {
    currentOperator = operator;
  }
}
