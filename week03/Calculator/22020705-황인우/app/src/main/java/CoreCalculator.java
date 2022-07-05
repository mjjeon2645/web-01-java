public class CoreCalculator {
  public static final String[] OPERATORS = {"+", "-", "*", "/", "="};

  private long currentNumber = 0;
  private long accumulator = 0;
  private String currentOperator = "";

  public long currentNumber() {
    return this.currentNumber;
  }

  public long accumulator() {
    return this.accumulator;
  }

  public void addCurrentNumber(int number) {
    currentNumber = currentNumber * 10 + number;
  }

  public void calculate(String operator) {
    switch (currentOperator) {
      case "+" -> accumulator += currentNumber;
      case "-" -> accumulator -= currentNumber;
      case "*" -> accumulator *= currentNumber;
      case "/" -> accumulator /= currentNumber;
      case "" -> accumulator = currentNumber;
    }

    currentOperator = operator;
    currentNumber = 0;
  }
}
