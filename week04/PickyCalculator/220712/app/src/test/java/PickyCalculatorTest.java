import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PickyCalculatorTest {
  @Test
  void coreCalculate() {
    PickyCalculator pickyCalculator = new PickyCalculator();

    assertEquals(4, pickyCalculator.compute("1 + 3"));
    assertEquals(6, pickyCalculator.compute("3 * 2"));
    assertEquals(2, pickyCalculator.compute("4 / 2"));
    assertEquals(3, pickyCalculator.compute("5 - 2"));
  }

  @Test
  void testExpressionError() {
    PickyCalculator pickyCalculator = new PickyCalculator();

    assertTrue(pickyCalculator.testExpressionError("1 + 1"));
    assertFalse(pickyCalculator.testExpressionError("1 +"));
    assertFalse(pickyCalculator.testExpressionError("1+1"));
    assertFalse(pickyCalculator.testExpressionError("+ 1 1"));
    assertFalse(pickyCalculator.testExpressionError("1 1 1"));
    assertFalse(pickyCalculator.testExpressionError("*"));
    assertFalse(pickyCalculator.testExpressionError("12+"));
    assertFalse(pickyCalculator.testExpressionError("123 + 2 *"));
    assertFalse(pickyCalculator.testExpressionError("123 * $"));
    assertTrue(pickyCalculator.testExpressionError("123"));
    assertTrue(pickyCalculator.testExpressionError("4"));

  }

  @Test
  void isOneNumber() {
    PickyCalculator pickyCalculator = new PickyCalculator();

    assertTrue(pickyCalculator.isOneNumber("3 "));
    assertFalse(pickyCalculator.isOneNumber("3 +"));
  }

  @Test
  void oneNumberPrintOut() {
    PickyCalculator pickyCalculator = new PickyCalculator();
    String[] components = new String[]{"1"};
    if (components.length == 1) {
      System.out.println("Result: " + components[0]);

    }
  }

  @Test
  void testAll() {
    PickyCalculator pickyCalculator = new PickyCalculator();
    Scanner scanner = new Scanner(System.in);

  }
}
