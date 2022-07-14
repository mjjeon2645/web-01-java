package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExpressionCheckerTest {
  @Test
  void oneLegalWord() {
    ExpressionChecker checker = new ExpressionChecker();

    assertTrue(checker.checkValidity("15"));
    assertTrue(checker.checkValidity("1634534"));
  }

  @Test
  void oneIllegalWord() {
    ExpressionChecker checker = new ExpressionChecker();

    assertFalse(checker.checkValidity("*"));
    assertFalse(checker.checkValidity("12+"));
    assertFalse(checker.checkValidity("1+1"));
  }

  @Test
  void legalWordsLengthAndLegalExpression() {
    ExpressionChecker checker = new ExpressionChecker();

    assertTrue(checker.checkValidity("-35435 + 2455"));
    assertTrue(checker.checkValidity("435 / -5"));
    assertTrue(checker.checkValidity("22 - 7"));
    assertTrue(checker.checkValidity("3785 * 4733"));
  }

  @Test
  void legalWordsLengthButIllegalExpression() {
    ExpressionChecker checker = new ExpressionChecker();

    assertFalse(checker.checkValidity("+ 1 1"));
    assertFalse(checker.checkValidity("35435 + 24-55"));
    assertFalse(checker.checkValidity("123 * $"));
    assertFalse(checker.checkValidity("+ 1 1"));
    assertFalse(checker.checkValidity("1 1 1"));
    assertFalse(checker.checkValidity("123 ( 4"));
    assertFalse(checker.checkValidity("123 +-/ 4636"));
  }

  @Test
  void illegalWordsLength() {
    ExpressionChecker checker = new ExpressionChecker();

    assertFalse(checker.checkValidity("1 + 1 + 1"));
    assertFalse(checker.checkValidity("123 + 2 *"));
  }
}
