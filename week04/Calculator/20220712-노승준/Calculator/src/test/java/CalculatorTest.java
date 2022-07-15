import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  @Test
  void onlyOne() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 3", calculator.compute("3"));
    assertEquals("Result: -1", calculator.compute("-1"));
    assertEquals("Result: 123", calculator.compute("123"));
  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 1", calculator.compute("1 + 0"));
    assertEquals("Result: 4", calculator.compute("2 + 2"));
    assertEquals("Result: 14", calculator.compute("12 + 2"));
    assertEquals("Result: 145", calculator.compute("123 + 22"));
    assertEquals("Result: 2234", calculator.compute("1234 + 1000"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 1", calculator.compute("1 - 0"));
    assertEquals("Result: 2", calculator.compute("3 - 1"));
    assertEquals("Result: 0", calculator.compute("2 - 2"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 0", calculator.compute("1 * 0"));
    assertEquals("Result: 3", calculator.compute("3 * 1"));
    assertEquals("Result: 4", calculator.compute("2 * 2"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 2", calculator.compute("4 / 2"));
    assertEquals("Result: 1", calculator.compute("3 / 3"));
  }
}
