import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
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
    assertEquals(2, calculator.compute("1 + 1"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("3 - 1"));
    assertEquals(0, calculator.compute("4 - 4"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(3, calculator.compute("3 * 1"));
    assertEquals(16, calculator.compute("4 * 4"));
  }

  @Test
  void divides() {
    Calculator calculator = new Calculator();

    assertEquals(3, calculator.compute("3 / 1"));
    assertEquals(1, calculator.compute("4 / 4"));
  }
}