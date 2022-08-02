package utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FormParserTest {
  @Test
  void parse() {
    FormParser formParser = new FormParser();

    Map<String, String> formdata = formParser.parse("to=1234&amount=1000");

    assertEquals("1234", formdata.get("to"));
    assertEquals("1000", formdata.get("amount"));
  }

  @Test
  void parseWithBlank() {
    FormParser formParser = new FormParser();

    Map<String, String> formdata = formParser.parse("");

    assertFalse(formdata.containsKey("to"));
  }
}
