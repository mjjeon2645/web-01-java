package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionValidityCheckerTest {
  @Test
  void setWords() {
    ExpressionValidityChecker checker = new ExpressionValidityChecker();

    checker.setAndSplitExpression("1234567 + 7654321");
    assertArrayEquals(new String[]{"1234567", "+", "7654321"}, checker.words());

    checker.setAndSplitExpression("3 +");
    assertArrayEquals(new String[]{"3", "+"}, checker.words());
  }

  @Test
  void checkNumberOfWords() {
    ExpressionValidityChecker checker = new ExpressionValidityChecker();

    checker.setAndSplitExpression("3 + 2");
    assertTrue(checker.checkNumberOfWords(), checker.expression());

    checker.setAndSplitExpression("15");
    assertTrue(checker.checkNumberOfWords(), checker.expression());

    checker.setAndSplitExpression("*");
    assertTrue(checker.checkNumberOfWords(), checker.expression());

    checker.setAndSplitExpression("12+");
    assertTrue(checker.checkNumberOfWords(), checker.expression());

    checker.setAndSplitExpression("1+1");
    assertTrue(checker.checkNumberOfWords(), checker.expression());

    checker.setAndSplitExpression("1 +");
    assertFalse(checker.checkNumberOfWords(), checker.expression());

    checker.setAndSplitExpression("1 + 1 + 1");
    assertFalse(checker.checkNumberOfWords(), checker.expression());

    checker.setAndSplitExpression("123 + 2 *");
    assertFalse(checker.checkNumberOfWords(), checker.expression());
  }

  @Test
  void checkIllegalWords() {
    ExpressionValidityChecker checker = new ExpressionValidityChecker();

    checker.setAndSplitExpression("3 + 2");
    assertTrue(checker.checkIllegalWord(), checker.expression());

    checker.setAndSplitExpression("3");
    assertTrue(checker.checkIllegalWord(), checker.expression());

    checker.setAndSplitExpression("1634534");
    assertTrue(checker.checkIllegalWord(), checker.expression());

    checker.setAndSplitExpression("*");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker.setAndSplitExpression("12+");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker.setAndSplitExpression("1+1");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker.setAndSplitExpression("+ 1 1");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker.setAndSplitExpression("1 1 1");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker.setAndSplitExpression("123 * $");
    assertFalse(checker.checkIllegalWord(), checker.expression());

    checker.setAndSplitExpression("123 ( 4");
    assertFalse(checker.checkIllegalWord(), checker.expression());
  }
}
