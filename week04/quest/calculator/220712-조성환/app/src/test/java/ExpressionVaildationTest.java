import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionVaildationTest {
  @Test
  void isNumber() {
    ExpressionVaildator expressionVaildator = new ExpressionVaildator();

    assertFalse(expressionVaildator.isNumber("+_"));
    assertFalse(expressionVaildator.isNumber("+++"));
    assertFalse(expressionVaildator.isNumber("_)+"));
  }

  @Test
  void expressionLengthUnder3() {
    ExpressionVaildator expressionVaildation = new ExpressionVaildator();

    assertFalse(expressionVaildation.checkExpression("1 +"));
    assertFalse(expressionVaildation.checkExpression("1+1"));
    assertFalse(expressionVaildation.checkExpression("*"));
    assertFalse(expressionVaildation.checkExpression("12+"));
  }

  @Test
  void expressionWithWrongOperator() {
    ExpressionVaildator expressionVaildation = new ExpressionVaildator();

    assertFalse(expressionVaildation.checkExpression("+ 1 1"));
    assertFalse(expressionVaildation.checkExpression("1 1 1"));
    assertFalse(expressionVaildation.checkExpression("123 + 2 *"));
  }
  @Test
  void wrongExpression() {
    ExpressionVaildator expressionVaildation = new ExpressionVaildator();

    assertFalse(expressionVaildation.checkExpression("123 + 2 *"));
    assertFalse(expressionVaildation.checkExpression("123 * $"));
    assertFalse(expressionVaildation.checkExpression("# * $"));
    assertFalse(expressionVaildation.checkExpression("43 + @"));
    assertFalse(expressionVaildation.checkExpression("1 + 1 + 1"));
  }
}
