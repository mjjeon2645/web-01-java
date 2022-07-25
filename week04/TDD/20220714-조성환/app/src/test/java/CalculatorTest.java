import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void simpleTest() {
    Calculator calculator = new Calculator();

    assertEquals(1, calculator.compute("1 + 0"));
    assertEquals(3, calculator.compute("3 + 0"));
  }

  @Test
  void plus() {
    Calculator calculator = new Calculator();

    assertEquals(4, calculator.compute("1 + 3"));
    assertEquals(7, calculator.compute("3 + 4"));
    assertEquals(13, calculator.compute("3 + 10"));
  }

  @Test
  void minus() {
    Calculator calculator = new Calculator();

    assertEquals(6, calculator.compute("10 - 4"));
    assertEquals(13, calculator.compute("15 - 2"));
    assertEquals(13, calculator.compute("19 - 6"));
  }

  @Test
  void times() {
    Calculator calculator = new Calculator();

    assertEquals(15, calculator.compute("3 * 5"));
    assertEquals(140, calculator.compute("20 * 7"));
    assertEquals(66, calculator.compute("11 * 6"));
  }

  @Test
  void divide() {
    Calculator calculator = new Calculator();

    assertEquals(4, calculator.compute("20 / 5"));
    assertEquals(30, calculator.compute("150 / 5"));
    assertEquals(5, calculator.compute("15 / 3"));
  }

  @Test
  void expressionLengthOne() {
    Calculator calculator = new Calculator();

    assertEquals(123, calculator.compute("123"));
    assertEquals(55, calculator.compute("55"));
    assertEquals(5, calculator.compute("5"));
  }
}
