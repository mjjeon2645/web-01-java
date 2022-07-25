import org.checkerframework.checker.units.qual.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
      void expression() {
    Calculator calculator = new Calculator();

    calculator.divideExpression("3 + 1");


    assertEquals("3",calculator.expressionComponent(0));
    assertEquals("+",calculator.expressionComponent(1));
    assertEquals("1",calculator.expressionComponent(2));

  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    calculator.divideExpression("3 + 1");

    assertEquals(4,calculator.compute());
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    calculator.divideExpression("6 - 2");

    assertEquals(4,calculator.compute());
  }

  @Test
  void multiply() {
    Calculator calculator = new Calculator();

    calculator.divideExpression("3 * 2");

    assertEquals(6,calculator.compute());
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    calculator.divideExpression("8 / 4");

    assertEquals(2,calculator.compute());
  }

  }