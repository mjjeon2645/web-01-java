import java.math.BigInteger;

public class CoreCalculator {
  public static final String[] OPERATORS = new String[]{"+", "-", "/", "*", "="};

  private String currentOperator = "";
  private long currentNumber = 0;
  private long accumulator= 0;


  public String getAccumulator() {
    return Long.toString(accumulator);
  }

  public String getCurrentNumber() {
    return Long.toString(currentNumber);
  }

  public void addNumber(String number) {
    currentNumber *= 10;
    currentNumber += Integer.valueOf(number);
  }

  public void calculate() {
    switch (currentOperator) {
      case "+" -> accumulator += currentNumber;
      case "/" -> accumulator /= currentNumber;
      case "-" -> accumulator -= currentNumber;
      case "*" -> accumulator *= currentNumber;
      case "" -> accumulator = currentNumber;
    }
    currentNumber = 0;
  }

  public void updateOperator(String operator) {
    currentOperator = operator;
  }
}
