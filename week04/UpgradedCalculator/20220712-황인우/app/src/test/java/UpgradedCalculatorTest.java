import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpgradedCalculatorTest {
  @Test
  void oneWord() {
    UpgradedCalculator application = new UpgradedCalculator();

    assertEquals("1", application.compute("1"));
    assertEquals("65536", application.compute("65536"));
  }

  @Test
  void simple() {
    UpgradedCalculator application = new UpgradedCalculator();

    assertEquals("1", application.compute("1 + 0"));
    assertEquals("65536", application.compute("65536 + 0"));
  }

  @Test
  void addition() {
    UpgradedCalculator application = new UpgradedCalculator();

    assertEquals("6", application.compute("1 + 5"));
    assertEquals("6912", application.compute("1234 + 5678"));
  }

  @Test
  void subtraction() {
    UpgradedCalculator application = new UpgradedCalculator();

    assertEquals("0", application.compute("8 - 8"));
    assertEquals("3000", application.compute("3396 - 396"));
  }

  @Test
  void multiplication() {
    UpgradedCalculator application = new UpgradedCalculator();

    assertEquals("64", application.compute("8 * 8"));
    assertEquals("2468", application.compute("1234 * 2"));
  }

  @Test
  void division() {
    UpgradedCalculator application = new UpgradedCalculator();

    assertEquals("1", application.compute("8 / 8"));
    assertEquals("617", application.compute("1234 / 2"));
  }
}
