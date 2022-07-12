package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionValidatorTest {
  @Test
  void falseCheck() {
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
  void trueCheck() {
    ExpressionValidator expressionValidator = new ExpressionValidator();

    assertTrue(expressionValidator.process("1 + 1"));
    assertTrue(expressionValidator.process("2 * 5"));
    assertTrue(expressionValidator.process("123"));
    assertTrue(expressionValidator.process("12"));
    assertTrue(expressionValidator.process("1 / 1"));
    assertTrue(expressionValidator.process("123 + 2"));
  }
}
