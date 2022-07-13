import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void onlyOne() {
    Calculator calculator = new Calculator();

    assertEquals(3, calculator.compute("3"));
    assertEquals(-1, calculator.compute("-1"));
  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("2 + 0"));
    assertEquals(2, calculator.compute("1 + 1"));
    assertEquals(21, calculator.compute("10 + 11"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("1 - 1"));
    assertEquals(2, calculator.compute("10 - 8"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(6, calculator.compute("1 * 6"));
    assertEquals(12, calculator.compute("6 * 2"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("14 / 7"));
    assertEquals(3, calculator.compute("6 / 2"));
  }
}
