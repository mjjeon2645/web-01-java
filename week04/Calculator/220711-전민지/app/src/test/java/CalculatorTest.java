import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void verySimple() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 4", calculator.compute("1 + 3"));
    assertEquals("Result: 6", calculator.compute("3 * 2"));
    assertEquals("Result: 2", calculator.compute("4 / 2"));
    assertEquals("Result: 3", calculator.compute("5 - 2"));
  }

  @Test
  void inputSingleNumber() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 1", calculator.compute("1"));
    assertEquals("Result: 123", calculator.compute("123"));
    assertEquals("Result: 41", calculator.compute("41"));
  }

  @Test
  void errorExpression() {
    Calculator calculator = new Calculator();

    assertEquals("수식 오류: 1 +", calculator.compute("1 +"));
    assertEquals("수식 오류: *", calculator.compute("*"));
    assertEquals("수식 오류: 1+1", calculator.compute("1+1"));
    assertEquals("수식 오류: 12+", calculator.compute("12+"));
    assertEquals("수식 오류: + 1 1", calculator.compute("+ 1 1"));
    assertEquals("수식 오류: 123 + 2 *", calculator.compute("123 + 2 *"));
    assertEquals("수식 오류: 1 + 1 + 1", calculator.compute("1 + 1 + 1"));
    assertEquals("수식 오류: 123 * $", calculator.compute("123 * $"));
    assertEquals("수식 오류: 1 1 1", calculator.compute("1 1 1"));
  }

  @Test
  void oneErrorExpression() {
    Calculator calculator = new Calculator();

    assertEquals("수식 오류: *", calculator.compute("*"));
  }
}
