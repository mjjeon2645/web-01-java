import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void verySimple() {
    Calculator calculator = new Calculator();

    assertEquals("0", calculator.process("0 + 0"));
    assertEquals("2", calculator.process("2 + 0"));
    assertEquals("5", calculator.process("5 + 0"));
  }
}