import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void test() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0 + 0"));
    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("1 + 1"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("2 - 2"));
    assertEquals(2, calculator.compute("3 - 1"));
    assertEquals(-4, calculator.compute("1 - 5"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(6, calculator.compute("3 * 2"));
    assertEquals(18, calculator.compute("2 * 9"));
    assertEquals(-4, calculator.compute("-1 * 4"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(7, calculator.compute("49 / 7"));
    assertEquals(2, calculator.compute("4 / 2"));
    assertEquals(3, calculator.compute("15 / 5"));
  }

  @Test
  void inputSingleNumber() {
    Calculator calculator = new Calculator();

    assertEquals(3, calculator.compute("3"));
    assertEquals(127, calculator.compute("127"));
  }
}
