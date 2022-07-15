import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionVerifierTest {
  @Test
  void inputWrongExpression() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    assertFalse(expressionVerifier.handleException("1 +"));
    assertFalse(expressionVerifier.handleException("1+1"));
    assertFalse(expressionVerifier.handleException("+ 1 1"));
    assertFalse(expressionVerifier.handleException("1 + 1 + 1"));
    assertFalse(expressionVerifier.handleException("1 1 1"));
    assertFalse(expressionVerifier.handleException("*"));
    assertFalse(expressionVerifier.handleException("12+"));
    assertFalse(expressionVerifier.handleException("123 + 2 *"));
    assertFalse(expressionVerifier.handleException("123 * $"));
    assertFalse(expressionVerifier.handleException("# * $"));
    assertFalse(expressionVerifier.handleException("43 + @"));
  }

  @Test
  void RightFirstWordNumber() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    assertTrue(expressionVerifier.isMatchesWordNumber("1"));

    assertFalse(expressionVerifier.isMatchesWordNumber("%"));
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
