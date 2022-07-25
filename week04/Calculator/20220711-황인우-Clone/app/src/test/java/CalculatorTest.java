import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  @Test
  void verySimple() {
    Calculator application = new Calculator();

    assertEquals(0, application.compute("0 + 0"));
    assertEquals(1, application.compute("1 + 0"));
    assertEquals(6, application.compute("6 + 0"));
    assertEquals(2, application.compute("1 + 1"));
  }

  @Test
  void plus() {
    Calculator application = new Calculator();

    assertEquals(2, application.compute("1 + 1"));
    assertEquals(53, application.compute("31 + 22"));
  }

  @Test
  void minus() {
    Calculator application = new Calculator();

    assertEquals(1, application.compute("2 - 1"));
    assertEquals(-25, application.compute("56 - 81"));
  }

  @Test
  void times() {
    Calculator application = new Calculator();

    assertEquals(2, application.compute("2 * 1"));
    assertEquals(-51, application.compute("-3 * 17"));
  }

  @Test
  void divides() {
    Calculator application = new Calculator();

    assertEquals(2, application.compute("4 / 2"));
    assertEquals(5, application.compute("20 / 4"));
  }
}
