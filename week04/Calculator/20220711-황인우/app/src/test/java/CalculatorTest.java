import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void verySimple() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.process("0 + 0"));
    assertEquals(2, calculator.process("2 + 0"));
    assertEquals(5, calculator.process("5 + 0"));
  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(3, calculator.process("0 + 3"));
    assertEquals(7, calculator.process("2 + 5"));
    assertEquals(13, calculator.process("5 + 8"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(-3, calculator.process("0 - 3"));
    assertEquals(0, calculator.process("5 - 5"));
    assertEquals(3, calculator.process("8 - 5"));
  }
}