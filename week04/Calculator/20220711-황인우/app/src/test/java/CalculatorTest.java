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

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(0, calculator.process("0 * 3"));
    assertEquals(25, calculator.process("5 * 5"));
    assertEquals(40, calculator.process("8 * 5"));
  }

  @Test
  void divides() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.process("12452343 / 12452343"));
    assertEquals(2, calculator.process("24 / 12"));
    assertEquals(10, calculator.process("100 / 10"));
  }
}
