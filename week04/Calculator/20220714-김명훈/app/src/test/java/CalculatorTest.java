import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void creation() {
    Calculator calculator = new Calculator();
    assertEquals(4,calculator.compute("3 + 1"));
    assertEquals(2,calculator.compute("3 - 1"));
    assertEquals(3,calculator.compute("3 * 1"));
    assertEquals(3,calculator.compute("6 / 2"));
  }

}