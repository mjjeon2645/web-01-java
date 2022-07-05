import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoreCalculatorTest {

  @Test
  void addCurrentNumberTest() {
    CoreCalculator coreCalculator = new CoreCalculator();

    coreCalculator.addCurrentNumber(1);
    coreCalculator.addCurrentNumber(3);
    coreCalculator.addCurrentNumber(7);
    coreCalculator.addCurrentNumber(9);

    assertEquals(1379, coreCalculator.currentNumber());
  }

  @Test
  void additionTest() {
    CoreCalculator coreCalculator = new CoreCalculator();

    coreCalculator.addCurrentNumber(2);
    coreCalculator.calculate("+");
    coreCalculator.addCurrentNumber(5);
    coreCalculator.addCurrentNumber(3);
    coreCalculator.calculate("=");

    assertEquals(55, coreCalculator.accumulator());
  }

  @Test
  void subtractionTest() {
    CoreCalculator coreCalculator = new CoreCalculator();

    coreCalculator.addCurrentNumber(8);
    coreCalculator.calculate("-");
    coreCalculator.addCurrentNumber(4);
    coreCalculator.calculate("=");

    assertEquals(4, coreCalculator.accumulator());
  }

  @Test
  void multiplicationTest() {
    CoreCalculator coreCalculator = new CoreCalculator();

    coreCalculator.addCurrentNumber(1);
    coreCalculator.addCurrentNumber(0);
    coreCalculator.calculate("*");
    coreCalculator.addCurrentNumber(2);
    coreCalculator.addCurrentNumber(0);
    coreCalculator.calculate("=");

    assertEquals(200, coreCalculator.accumulator());
  }

  @Test
  void divisionTest() {
    CoreCalculator coreCalculator = new CoreCalculator();

    coreCalculator.addCurrentNumber(6);
    coreCalculator.addCurrentNumber(8);
    coreCalculator.addCurrentNumber(8);
    coreCalculator.calculate("/");
    coreCalculator.addCurrentNumber(1);
    coreCalculator.addCurrentNumber(6);
    coreCalculator.calculate("=");

    assertEquals(43, coreCalculator.accumulator());
  }

  @Test
  void complexTest() {
    CoreCalculator coreCalculator = new CoreCalculator();

    coreCalculator.addCurrentNumber(2);
    coreCalculator.calculate("+");
    coreCalculator.addCurrentNumber(5);
    coreCalculator.addCurrentNumber(3);
    coreCalculator.calculate("+");
    coreCalculator.addCurrentNumber(4);
    coreCalculator.addCurrentNumber(5);
    coreCalculator.calculate("/");
    coreCalculator.addCurrentNumber(5);
    coreCalculator.addCurrentNumber(0);
    coreCalculator.calculate("*");
    coreCalculator.addCurrentNumber(8);
    coreCalculator.calculate("-");
    coreCalculator.addCurrentNumber(1);
    coreCalculator.addCurrentNumber(3);
    coreCalculator.calculate("=");

    assertEquals(3, coreCalculator.accumulator());
  }
}
