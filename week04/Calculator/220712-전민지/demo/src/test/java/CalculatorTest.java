import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void simpleTest() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0 + 0"));
    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("1 + 1"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("4 - 2"));
    assertEquals(5, calculator.compute("7 - 2"));
    assertEquals(-3, calculator.compute("1 - 4"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("1 * 2"));
    assertEquals(6, calculator.compute("2 * 3"));
    assertEquals(-3, calculator.compute("-1 * 3"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("2 / 1"));
    assertEquals(6, calculator.compute("18 / 3"));
    assertEquals(7, calculator.compute("49 / 7"));
  }

  @Test
  void inputSingleNumber() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("2"));
    assertEquals(15, calculator.compute("15"));
  }
}
