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
  void checkFirstWordNumber() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    expressionVerifier.splitWords("1 + 1");
    assertTrue(expressionVerifier.isMatchesFirstWordNumber());

    expressionVerifier.splitWords("% + 1");
    assertFalse(expressionVerifier.isMatchesFirstWordNumber());
  }

  @Test
  void checkLastWordNumber() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    expressionVerifier.splitWords("1 + 1");
    assertTrue(expressionVerifier.isMatchesLastWordNumber());

    expressionVerifier.splitWords("1 + %");
    assertFalse(expressionVerifier.isMatchesLastWordNumber());
  }

  @Test
  void checkRightOperator() {
    ExpressionVerifier expressionVerifier = new ExpressionVerifier();

    assertTrue(expressionVerifier.isRightOperator("+"));
    assertTrue(expressionVerifier.isRightOperator("-"));
    assertTrue(expressionVerifier.isRightOperator("*"));
    assertTrue(expressionVerifier.isRightOperator("/"));

    assertFalse(expressionVerifier.isRightOperator("&"));
    assertFalse(expressionVerifier.isRightOperator("("));
  }
}
