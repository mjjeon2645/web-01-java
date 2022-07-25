import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0 + 0"));
    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("1 + 1"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("2 - 1"));
    assertEquals(-2, calculator.compute("1 - 3"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(8, calculator.compute("2 * 4"));
    assertEquals(16, calculator.compute("4 * 4"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(8, calculator.compute("16 / 2"));
    assertEquals(4, calculator.compute("8 / 2"));
  }

  @Test
  void singleNumber() {
    Calculator calculator = new Calculator();

    assertEquals(127, calculator.compute("127"));
    assertEquals(36, calculator.compute("36"));
  }
}
