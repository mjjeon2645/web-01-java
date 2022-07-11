import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  @Test
  void inputWrongExpression() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("1 +"));
    assertEquals(0, calculator.compute("1+1"));
    assertEquals(0, calculator.compute("+ 1 1"));
    assertEquals(0, calculator.compute("1 + 1 + 1"));
    assertEquals(0, calculator.compute("1 1 1"));
    assertEquals(0, calculator.compute("*"));
    assertEquals(0, calculator.compute("12+"));
    assertEquals(0, calculator.compute("123 + 2 *"));
    assertEquals(0, calculator.compute("123 * $"));
    assertEquals(0, calculator.compute("# * $"));
    assertEquals(0, calculator.compute("43 + @"));
  }

  @Test
  void onlyOne() {
    Calculator calculator = new Calculator();

    assertEquals(3, calculator.compute("3"));
  }
  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("2 + 0"));
    assertEquals(4, calculator.compute("2 + 2"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 - 0"));
    assertEquals(2, calculator.compute("3 - 1"));
    assertEquals(0, calculator.compute("2 - 2"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("1 * 0"));
    assertEquals(3, calculator.compute("3 * 1"));
    assertEquals(4, calculator.compute("2 * 2"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("4 / 2"));
    assertEquals(1, calculator.compute("3 / 3"));
  }
}
