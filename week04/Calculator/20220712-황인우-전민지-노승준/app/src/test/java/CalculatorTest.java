import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void simpleTest() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("2 + 0"));
  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("1 + 1"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(3, calculator.compute("5 - 2"));
    assertEquals(-5, calculator.compute("2 - 7"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(10, calculator.compute("5 * 2"));
    assertEquals(14, calculator.compute("2 * 7"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(3, calculator.compute("6 / 2"));
    assertEquals(3, calculator.compute("12 / 4"));
  }

  @Test
  void onlyOne() {
    Calculator calculator = new Calculator();

    assertEquals(6, calculator.compute("6"));
    assertEquals(12, calculator.compute("12"));
  }
}
