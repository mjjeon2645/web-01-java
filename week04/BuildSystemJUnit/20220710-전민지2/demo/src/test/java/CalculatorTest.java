import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void verySimple() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0 + 0"));
    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("2 + 0"));
  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(5, calculator.compute("2 + 3"));
    assertEquals(8, calculator.compute("5 + 3"));
    assertEquals(7, calculator.compute("2 + 5"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("2 - 1"));
    assertEquals(2, calculator.compute("5 - 3"));
    assertEquals(-3, calculator.compute("2 - 5"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("2 * 1"));
    assertEquals(15, calculator.compute("5 * 3"));
    assertEquals(6, calculator.compute("2 * 3"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("2 / 1"));
    assertEquals(2, calculator.compute("6 / 3"));
    assertEquals(5, calculator.compute("15 / 3"));
  }
}
