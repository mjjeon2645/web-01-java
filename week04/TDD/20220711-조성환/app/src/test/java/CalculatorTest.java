import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void simple() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.compute("0 + 0"));
    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("2 + 0"));
    assertEquals(2, calculator.compute("0 + 2"));
    assertEquals(3, calculator.compute("0 + 3"));
  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(2, calculator.compute("1 + 1"));
    assertEquals(1, calculator.compute("0 + 1"));
  }
  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("3 - 1"));
    assertEquals(3, calculator.compute("5 - 2"));
    assertEquals(-1, calculator.compute("0 - 1"));
  }
  @Test
  void times(){
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 * 1"));
    assertEquals(10, calculator.compute("5 * 2"));
  }
  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("5 / 5"));
    assertEquals(2, calculator.compute("50 / 25"));
  }
}