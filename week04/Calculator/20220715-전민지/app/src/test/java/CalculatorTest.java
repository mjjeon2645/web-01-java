import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0 + 0"));
    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("1 + 1"));
    assertEquals(13, calculator.compute("12 + 1"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("2 - 1"));
    assertEquals(2, calculator.compute("5 - 3"));
    assertEquals(-4, calculator.compute("1 - 5"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("2 * 1"));
    assertEquals(8, calculator.compute("2 * 4"));
    assertEquals(26, calculator.compute("13 * 2"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("2 / 1"));
    assertEquals(2, calculator.compute("6 / 3"));
    assertEquals(5, calculator.compute("25 / 5"));
  }

  @Test
  void singleNumber() {
    Calculator calculator = new Calculator();

    assertEquals(23, calculator.compute("23"));
    assertEquals(5, calculator.compute("5"));
    assertEquals(179, calculator.compute("179"));
  }
}
