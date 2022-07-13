import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void test() {
    Calculator calculator = new Calculator();

    assertEquals(4,calculator.compute("3 + 1"));
    assertEquals(4,calculator.compute("6 - 2"));
    assertEquals(6,calculator.compute("3 * 2"));
    assertEquals(2,calculator.compute("8 / 4"));

  }

}