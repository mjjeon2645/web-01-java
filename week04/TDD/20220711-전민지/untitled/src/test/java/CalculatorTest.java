import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void verySimple() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0 + 0"));
    assertEquals(1, calculator.compute("1 + 0"));
  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(5, calculator.compute("2 + 3"));
    assertEquals(3, calculator.compute("2 + 1"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 - 0"));
    assertEquals(1, calculator.compute("2 - 1"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(3, calculator.compute("1 * 3"));
    assertEquals(8, calculator.compute("2 * 4"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("4 / 2"));
    assertEquals(3, calculator.compute("6 / 2"));
  }

  @Test
  void inputSingleNumber() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("2"));
    assertEquals(5, calculator.compute("5"));
  }
}
