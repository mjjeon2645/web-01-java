import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void onlyOne() {
    Calculator calculator = new Calculator();

    assertEquals(5, calculator.compute("5"));
  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("1 + 1"));
    assertEquals(9, calculator.compute("5 + 4"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("4 - 2"));
    assertEquals(5, calculator.compute("10 - 5"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(8, calculator.compute("4 * 2"));
    assertEquals(18, calculator.compute("6 * 3"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("4 / 2"));
    assertEquals(3, calculator.compute("10 / 3"));
  }
}
