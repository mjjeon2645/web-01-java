package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionValidityCheckerTest {
  @Test
  void setAndSplitExpression() {
    ExpressionValidityChecker checker
        = new ExpressionValidityChecker("1234567 + 7654321");
    assertArrayEquals(new String[]{"1234567", "+", "7654321"}, checker.words());

    checker = new ExpressionValidityChecker("3 +");
    assertArrayEquals(new String[]{"3", "+"}, checker.words());
  }

  @Test
  void checkNumberOfWordIs1Or3() {
    ExpressionValidityChecker checker
        = new ExpressionValidityChecker("3 + 2");
    assertTrue(checker.checkNumberOfWordIs1Or3(), checker.expression());

    checker = new ExpressionValidityChecker("15");
    assertTrue(checker.checkNumberOfWordIs1Or3(), checker.expression());

    checker = new ExpressionValidityChecker("*");
    assertTrue(checker.checkNumberOfWordIs1Or3(), checker.expression());

    checker = new ExpressionValidityChecker("12+");
    assertTrue(checker.checkNumberOfWordIs1Or3(), checker.expression());

    checker = new ExpressionValidityChecker("1+1");
    assertTrue(checker.checkNumberOfWordIs1Or3(), checker.expression());

    checker = new ExpressionValidityChecker("1 +");
    assertFalse(checker.checkNumberOfWordIs1Or3(), checker.expression());

    checker = new ExpressionValidityChecker("1 + 1 + 1");
    assertFalse(checker.checkNumberOfWordIs1Or3(), checker.expression());

    checker = new ExpressionValidityChecker("123 + 2 *");
    assertFalse(checker.checkNumberOfWordIs1Or3(), checker.expression());
  }

  @Test
  void checkIllegalWords() {
    ExpressionValidityChecker checker
        = new ExpressionValidityChecker("3 + 2");
    assertTrue(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("-35435 + 2455");
    assertTrue(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("3");
    assertTrue(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("1634534");
    assertTrue(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("*");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("12+");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("1+1");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("+ 1 1");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("35435 + 24-55");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("1 1 1");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("123 * $");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker = new ExpressionValidityChecker("123 ( 4");
    assertFalse(checker.checkIllegalWord(), checker.expression());
  }
}
