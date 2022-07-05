import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//currentNumber 13 , currentoperator + , currentNumber 7 , ->
// + 13 + 7
// - 13 + 7
// =  13 + 7
// case 1  13 (+ , 7) -> current

// 1) 1, 3  currentNumber 13, , accumulator 0 , currentOperator ""
// 2)  +    currentNumber 0, accumulator 13, currentO +
// 3) 7    currentNum  7, accumulator 13, currentO +
// 4) =      currentNum 0 accumulator 13 + 7 = 20, currentO =
// 4-1)  +     currentNum 0 accumulator 13 + 7 = 20, currentO +


class CalculatorTest {
  private String currentOperator = "";
  private long accumulator = 0;
  //private long currentNumber = 0;

  @Test
  void test() {
    Calculator calculator = new Calculator();


      String[] operators = new String[]{"+", "-", "*", "/", "="};
      long currentNumber = 13;
      String operator = "+";


          currentOperator = operator;
          if (currentOperator.equals("")) {
            accumulator += currentNumber;
          }
          accumulator + current


          System.out.println("actual value: " + (Long.toString(accumulator)));
          currentNumber = 0;
        });
      }
    }
