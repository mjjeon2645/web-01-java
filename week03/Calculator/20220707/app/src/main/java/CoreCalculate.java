public class CoreCalculate {
  private long currentNumber = 0 ;
  private String currentOperator = "";
  private long accumulator = 0;


 public static final String[] OPERATORS = new String[] {"+","-","*","/","="};

  public long getCurrentNumber() {
    return currentNumber;
  }

  public String getCurrentOperator() {
    return currentOperator;
  }

  public long getAccumulator() {
    return accumulator;
  }

  public void coreCalculate(String operator) {
    switch (getCurrentOperator()) {
      case "" -> accumulator = currentNumber;
      case "+" -> accumulator += currentNumber;
      case "-" -> accumulator -= currentNumber;
      case "*" -> accumulator *= currentNumber;
      case "/" -> accumulator /= currentNumber;
    }
    currentOperator = operator;
    currentNumber = 0;


  }

  public void addNumber(long number) {
    currentNumber *= 10;
    currentNumber += number;
  }
}


