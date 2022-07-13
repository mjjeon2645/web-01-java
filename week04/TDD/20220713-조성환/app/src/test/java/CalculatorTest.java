import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void simpleTest() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(3, calculator.compute("0 + 3"));
  }
  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(5, calculator.compute("4 + 1"));
    assertEquals(7, calculator.compute("5 + 2"));
  }
  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("4 - 3"));
    assertEquals(3, calculator.compute("10 - 7"));
  }
  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(20, calculator.compute("5 * 4"));
    assertEquals(9, calculator.compute("3 * 3"));
  }
  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(7, calculator.compute("28 / 4"));
    assertEquals(3, calculator.compute("99 / 33"));
  }
}
