import org.junit.jupiter.api.Test;

import java.io.CharArrayReader;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void simpleTest() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("2 + 0"));
    assertEquals(3, calculator.compute("3 + 0"));
  }
  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(10, calculator.compute("3 + 7"));
    assertEquals(11, calculator.compute("3 + 8"));
    assertEquals(43, calculator.compute("28 + 15"));
  }
  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(5, calculator.compute("8 - 3"));
    assertEquals(3, calculator.compute("5 - 2"));
    assertEquals(8, calculator.compute("15 - 7"));
  }
  @Test
  void time() {
    Calculator calculator = new Calculator();

    assertEquals(24, calculator.compute("8 * 3"));
    assertEquals(10, calculator.compute("5 * 2"));
    assertEquals(105, calculator.compute("15 * 7"));
  }
  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(5, calculator.compute("15 / 3"));
    assertEquals(3, calculator.compute("6 / 2"));
    assertEquals(8, calculator.compute("64 / 8"));
  }
}