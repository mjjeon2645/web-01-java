public class CoreCalculator {
  public static final String[] OPERATORS = new String[]{
      "+", "-", "*", "/", "="
  };

  private long currentNumber = 0;
  private long accumulator = 0;
  private String currentOperator = "";

  public long currentNumber() {
    return this.currentNumber;
  }

  public long accumulator() {
    return this.accumulator;
  }

  public void addNumberToCurrentNumber(int number) {
    currentNumber = currentNumber * 10 + number;
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

  public void setCurrentOperator(String operator) {
    currentOperator = operator;
  }
}
