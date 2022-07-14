import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  @Test
  void simple() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0 + 0"));
    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(444, calculator.compute("444 + 0"));
  }

  @Test
  void oneWord() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0"));
    assertEquals(1, calculator.compute("1"));
    assertEquals(444, calculator.compute("444"));
  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(3, calculator.compute("0 + 3"));
    assertEquals(10, calculator.compute("1 + 9"));
    assertEquals(1000, calculator.compute("444 + 556"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(-3, calculator.compute("0 - 3"));
    assertEquals(-8, calculator.compute("1 - 9"));
    assertEquals(-112, calculator.compute("444 - 556"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0 * 3"));
    assertEquals(9, calculator.compute("1 * 9"));
    assertEquals(246864, calculator.compute("444 * 556"));
  }

  @Test
  void divides() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0 / 3"));
    assertEquals(3, calculator.compute("9 / 3"));
    assertEquals(111, calculator.compute("444 / 4"));
  }
}
