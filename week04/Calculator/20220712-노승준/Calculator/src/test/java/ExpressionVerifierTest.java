import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionVerifierTest {
  @Test
  void inputWrongExpression() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    assertFalse(expressionVerifier.verifyException("1 +"));
    assertFalse(expressionVerifier.verifyException("1+1"));
    assertFalse(expressionVerifier.verifyException("+ 1 1"));
    assertFalse(expressionVerifier.verifyException("1 + 1 + 1"));
    assertFalse(expressionVerifier.verifyException("1 1 1"));
    assertFalse(expressionVerifier.verifyException("*"));
    assertFalse(expressionVerifier.verifyException("12+"));
    assertFalse(expressionVerifier.verifyException("123 + 2 *"));
    assertFalse(expressionVerifier.verifyException("123 * $"));
    assertFalse(expressionVerifier.verifyException("# * $"));
    assertFalse(expressionVerifier.verifyException("43 + @"));
  }

  @Test
  void onlyOneNumber() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    assertTrue(expressionVerifier.isNumber("1"));

    assertFalse(expressionVerifier.isNumber("%"));
  }

  @Test
  void RightOperator() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    assertTrue(expressionVerifier.isRightOperator("+"));
    assertTrue(expressionVerifier.isRightOperator("-"));
    assertTrue(expressionVerifier.isRightOperator("*"));
    assertTrue(expressionVerifier.isRightOperator("/"));

    assertFalse(expressionVerifier.isRightOperator("&"));
    assertFalse(expressionVerifier.isRightOperator("("));
  }
}
