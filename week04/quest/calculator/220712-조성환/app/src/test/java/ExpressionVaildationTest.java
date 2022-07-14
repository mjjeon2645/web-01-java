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

    assertFalse(expressionVaildation.expressionCheck("1 +"));
    assertFalse(expressionVaildation.expressionCheck("1+1"));
    assertFalse(expressionVaildation.expressionCheck("*"));
    assertFalse(expressionVaildation.expressionCheck("12+"));

  }

  @Test
  void operatorError() {
    ExpressionVaildator expressionVaildation = new ExpressionVaildator();

    assertFalse(expressionVaildation.expressionCheck("+ 1 1"));
    assertFalse(expressionVaildation.expressionCheck("1 1 1"));
    assertFalse(expressionVaildation.expressionCheck("123 + 2 *"));
  }
  @Test
  void inputNumberError() {
    ExpressionVaildator expressionVaildation = new ExpressionVaildator();

    assertFalse(expressionVaildation.expressionCheck("123 + 2 *"));
    assertFalse(expressionVaildation.expressionCheck("123 * $"));
    assertFalse(expressionVaildation.expressionCheck("# * $"));
    assertFalse(expressionVaildation.expressionCheck("43 + @"));
    assertFalse(expressionVaildation.expressionCheck("1 + 1 + 1"));
  }
}
