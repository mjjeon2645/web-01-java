import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void simpleTest() {
    Calculator calculator = new Calculator();

  assertEquals(1, calculator.compute("1 + 0") );
    assertEquals(8, calculator.compute("1 + 7") );

  }
  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("3 - 1") );
  }
  @Test
  void multiply() {
    Calculator calculator = new Calculator();

    assertEquals(6, calculator.compute("3 * 2") );
  }
  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(2, calculator.compute("8 / 4") );
  }

}