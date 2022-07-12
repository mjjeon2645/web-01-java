import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionCalculateTest {
  @Test
  void inputWrongExpression() {
    ExceptionCalculate exceptionCalculate = new ExceptionCalculate();

    assertEquals("수식 오류: 1 +", exceptionCalculate.exceptionHandling("1 +"));
    assertEquals("수식 오류: 1+1", exceptionCalculate.exceptionHandling("1+1"));
    assertEquals("수식 오류: + 1 1", exceptionCalculate.exceptionHandling("+ 1 1"));
    assertEquals("수식 오류: 1 + 1 + 1", exceptionCalculate.exceptionHandling("1 + 1 + 1"));
    assertEquals("수식 오류: 1 1 1", exceptionCalculate.exceptionHandling("1 1 1"));
    assertEquals("수식 오류: *", exceptionCalculate.exceptionHandling("*"));
    assertEquals("수식 오류: 12+", exceptionCalculate.exceptionHandling("12+"));
    assertEquals("수식 오류: 123 + 2 *", exceptionCalculate.exceptionHandling("123 + 2 *"));
    assertEquals("수식 오류: 123 * $", exceptionCalculate.exceptionHandling("123 * $"));
    assertEquals("수식 오류: # * $", exceptionCalculate.exceptionHandling("# * $"));
    assertEquals("수식 오류: 43 + @", exceptionCalculate.exceptionHandling("43 + @"));

  }
}
