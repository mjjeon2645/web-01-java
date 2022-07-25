package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionValidatorTest {
  @Test
  void wrongExpression() {
    ExpressionValidator expressionValidator = new ExpressionValidator();

    assertFalse(expressionValidator.process("1 +"));
    assertFalse(expressionValidator.process("*"));
    assertFalse(expressionValidator.process("1+1"));
    assertFalse(expressionValidator.process("12+"));
    assertFalse(expressionValidator.process("+ 1 1"));
    assertFalse(expressionValidator.process("123 + 2 *"));
    assertFalse(expressionValidator.process("1 + 1 + 1"));
    assertFalse(expressionValidator.process("123 * $"));
    assertFalse(expressionValidator.process("1 1 1"));
  }

  @Test
  void rightExpression() {
    ExpressionValidator expressionValidator = new ExpressionValidator();

    assertTrue(expressionValidator.process("1 + 1"));
    assertTrue(expressionValidator.process("2 * 5"));
    assertTrue(expressionValidator.process("123"));
    assertTrue(expressionValidator.process("12"));
    assertTrue(expressionValidator.process("1 / 1"));
    assertTrue(expressionValidator.process("123 + 2"));
  }

  @Test
  void isNumber() {
    ExpressionValidator expressionValidator = new ExpressionValidator();

    assertTrue(expressionValidator.isNumber("35"));
    assertTrue(expressionValidator.isNumber("122309"));
    assertTrue(expressionValidator.isNumber("1"));

    assertFalse(expressionValidator.isNumber("12*&5"));
    assertFalse(expressionValidator.isNumber("*&"));
    assertFalse(expressionValidator.isNumber("129 "));
    assertFalse(expressionValidator.isNumber("1 29"));
  }

  @Test
  void isOperator() {
    ExpressionValidator expressionValidator = new ExpressionValidator();

    assertTrue(expressionValidator.isOperator("+"));
    assertTrue(expressionValidator.isOperator("-"));
    assertTrue(expressionValidator.isOperator("*"));
    assertTrue(expressionValidator.isOperator("/"));

    assertFalse(expressionValidator.isOperator("$"));
    assertFalse(expressionValidator.isOperator("#@"));
    assertFalse(expressionValidator.isOperator(" "));
    assertFalse(expressionValidator.isOperator("*)"));
  }
}
