import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpgradedCalculatorTest {
  @Test
  void oneWord() {
    UpgradedCalculator calculator = new UpgradedCalculator();

    assertEquals("1", calculator.compute("1"));
    assertEquals("65536", calculator.compute("65536"));
  }

  @Test
  void simple() {
    UpgradedCalculator calculator = new UpgradedCalculator();

    assertEquals("1", calculator.compute("1 + 0"));
    assertEquals("65536", calculator.compute("65536 + 0"));
  }

  @Test
  void plus() {
    UpgradedCalculator calculator = new UpgradedCalculator();

    assertEquals("6", calculator.compute("1 + 5"));
    assertEquals("6912", calculator.compute("1234 + 5678"));
  }

  @Test
  void minus() {
    UpgradedCalculator calculator = new UpgradedCalculator();

    assertEquals("0", calculator.compute("8 - 8"));
    assertEquals("3000", calculator.compute("3396 - 396"));
  }

  @Test
  void times() {
    UpgradedCalculator calculator = new UpgradedCalculator();

    assertEquals("64", calculator.compute("8 * 8"));
    assertEquals("2468", calculator.compute("1234 * 2"));
  }

  @Test
  void divides() {
    UpgradedCalculator calculator = new UpgradedCalculator();

    assertEquals("1", calculator.compute("8 / 8"));
    assertEquals("617", calculator.compute("1234 / 2"));
  }
}
