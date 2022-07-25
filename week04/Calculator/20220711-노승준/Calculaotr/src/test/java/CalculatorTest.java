import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  @Test
  void inputWrongExpression() {
    Calculator calculator = new Calculator();

    assertEquals("수식 오류: 1 +", calculator.compute("1 +"));
    assertEquals("수식 오류: 1+1", calculator.compute("1+1"));
    assertEquals("수식 오류: + 1 1", calculator.compute("+ 1 1"));
    assertEquals("수식 오류: 1 + 1 + 1", calculator.compute("1 + 1 + 1"));
    assertEquals("수식 오류: 1 1 1", calculator.compute("1 1 1"));
    assertEquals("수식 오류: *", calculator.compute("*"));
    assertEquals("수식 오류: 12+", calculator.compute("12+"));
    assertEquals("수식 오류: 123 + 2 *", calculator.compute("123 + 2 *"));
    assertEquals("수식 오류: 123 * $", calculator.compute("123 * $"));
    assertEquals("수식 오류: # * $", calculator.compute("# * $"));
    assertEquals("수식 오류: 43 + @", calculator.compute("43 + @"));
  }

  @Test
  void onlyOne() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 3", calculator.compute("3"));
    assertEquals("Result: -1", calculator.compute("-1"));
  }
  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 1", calculator.compute("1 + 0"));
    assertEquals("Result: 2", calculator.compute("2 + 0"));
    assertEquals("Result: 4", calculator.compute("2 + 2"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 1", calculator.compute("1 - 0"));
    assertEquals("Result: 2", calculator.compute("3 - 1"));
    assertEquals("Result: 0", calculator.compute("2 - 2"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 0", calculator.compute("1 * 0"));
    assertEquals("Result: 3", calculator.compute("3 * 1"));
    assertEquals("Result: 4", calculator.compute("2 * 2"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals("Result: 2", calculator.compute("4 / 2"));
    assertEquals("Result: 1", calculator.compute("3 / 3"));
  }
}
