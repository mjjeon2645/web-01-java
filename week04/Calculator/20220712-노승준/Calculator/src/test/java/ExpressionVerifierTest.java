import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionVerifierTest {
  @Test
  void inputWrongExpression() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    assertEquals("수식 오류: 1 +", expressionVerifier.exceptionHandling("1 +"));
    assertEquals("수식 오류: 1+1", expressionVerifier.exceptionHandling("1+1"));
    assertEquals("수식 오류: + 1 1", expressionVerifier.exceptionHandling("+ 1 1"));
    assertEquals("수식 오류: 1 + 1 + 1", expressionVerifier.exceptionHandling("1 + 1 + 1"));
    assertEquals("수식 오류: 1 1 1", expressionVerifier.exceptionHandling("1 1 1"));
    assertEquals("수식 오류: *", expressionVerifier.exceptionHandling("*"));
    assertEquals("수식 오류: 12+", expressionVerifier.exceptionHandling("12+"));
    assertEquals("수식 오류: 123 + 2 *", expressionVerifier.exceptionHandling("123 + 2 *"));
    assertEquals("수식 오류: 123 * $", expressionVerifier.exceptionHandling("123 * $"));
    assertEquals("수식 오류: # * $", expressionVerifier.exceptionHandling("# * $"));
    assertEquals("수식 오류: 43 + @", expressionVerifier.exceptionHandling("43 + @"));
  }

  @Test
  void splitWords() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    expressionVerifier.splitWords("1 + 1");

    assertArrayEquals(new String[]{"1", "+", "1"}, expressionVerifier.words());
  }

  @Test
  void isKeepCalculate() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    expressionVerifier.stopCalculate();

    assertFalse(expressionVerifier.keepCalculate);
  }

  @Test
  void displayWrongExpression() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    assertEquals("수식 오류: 1 +", expressionVerifier.displayWrongExpression("1 +"));
    assertEquals("수식 오류: 123 + 2 *", expressionVerifier.displayWrongExpression("123 + 2 *"));
  }
}
