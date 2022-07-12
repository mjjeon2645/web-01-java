import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionVaildationTest {
  @Test
  void expressionLengthUnder3() {
    ExpressionVaildator expressionVaildation = new ExpressionVaildator();

    assertEquals("수식 오류: 1 +", expressionVaildation.exceptionExpression("1 +"));
    assertEquals("수식 오류: 1+1", expressionVaildation.exceptionExpression("1+1"));
    assertEquals("수식 오류: *", expressionVaildation.exceptionExpression("*"));
    assertEquals("수식 오류: 12+", expressionVaildation.exceptionExpression("12+"));

  }

  @Test
  void operatorError() {
    ExpressionVaildator expressionVaildation = new ExpressionVaildator();

    assertEquals("수식 오류: + 1 1", expressionVaildation.exceptionExpression("+ 1 1"));
    assertEquals("수식 오류: 1 1 1", expressionVaildation.exceptionExpression("1 1 1"));
    assertEquals("수식 오류: 123 + 2 *", expressionVaildation.exceptionExpression("123 + 2 *"));
  }

  @Test
  void inputNumberError() {
    ExpressionVaildator expressionVaildation = new ExpressionVaildator();

    assertEquals("수식 오류: 123 + 2 *", expressionVaildation.exceptionExpression("123 + 2 *"));
    assertEquals("수식 오류: 123 * $", expressionVaildation.exceptionExpression("123 * $"));
    assertEquals("수식 오류: # * $", expressionVaildation.exceptionExpression("# * $"));
    assertEquals("수식 오류: 43 + @", expressionVaildation.exceptionExpression("43 + @"));
    assertEquals("수식 오류: 1 + 1 + 1", expressionVaildation.exceptionExpression("1 + 1 + 1"));
  }
}
