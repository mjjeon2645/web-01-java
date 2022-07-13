import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void simple() {
    Calculator application = new Calculator();

    assertEquals(0, application.compute("0 + 0"));
    assertEquals(2, application.compute("2 + 0"));
    assertEquals(57125, application.compute("57125 + 0"));
  }

  @Test
  void addition() {
    Calculator application = new Calculator();

    assertEquals(3, application.compute("0 + 3"));
    assertEquals(7, application.compute("2 + 5"));
    assertEquals(100000, application.compute("57125 + 42875"));
  }

  @Test
  void subtraction() {
    Calculator application = new Calculator();

    assertEquals(-3, application.compute("0 - 3"));
    assertEquals(-3, application.compute("2 - 5"));
    assertEquals(14250, application.compute("57125 - 42875"));
  }

  @Test
  void multiplication() {
    Calculator application = new Calculator();

    assertEquals(0, application.compute("0 * 3"));
    assertEquals(10, application.compute("2 * 5"));
    assertEquals(7006652, application.compute("1234 * 5678"));
  }

  @Test
  void division() {
    Calculator application = new Calculator();

    assertEquals(3, application.compute("9 / 3"));
    assertEquals(-2, application.compute("-10 / 5"));
    assertEquals(12341234, application.compute("24682468 / 2"));
  }
}