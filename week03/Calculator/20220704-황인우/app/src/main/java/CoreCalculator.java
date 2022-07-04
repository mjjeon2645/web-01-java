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

  public void setCurrentOperator(String operator) {
    currentOperator = operator;
  }

  public void setAccumulator() {
    switch (currentOperator) {
      case "+" -> accumulator += currentNumber;
      case "-" -> accumulator -= currentNumber;
      case "*" -> accumulator *= currentNumber;
      case "/" -> accumulator /= currentNumber;
      default -> accumulator += currentNumber;
    }
  }

  public void setCurrentNumber(long number) {
    currentNumber = this.currentNumber() * 10 + number;
  }

  public void setCurrentNumberZero() {
    currentNumber = 0;
  }
}
