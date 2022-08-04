package utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FormParserTest {
  @Test
  void parse() {
    FormParser formParser = new FormParser();

    Map<String, String> formData = formParser.parse("to=179&amount=500");

    assertEquals("179", formData.get("to"));
    assertEquals("500", formData.get("amount"));
  }

  @Test
  void parseEmptyValue() {
    FormParser formParser = new FormParser();

    Map<String, String> formData = formParser.parse("");

    assertFalse(formData.containsKey("to"));
    assertFalse(formData.containsKey("amount"));
  }
}
