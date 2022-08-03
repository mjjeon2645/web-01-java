package utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FormParserTest {
  @Test
  void parse() {
    FormParser formParser = new FormParser();

    Map<String, String> formData = formParser.parse("to=한지우&amount=5000");

    assertEquals("한지우", formData.get("to"));
    assertEquals("5000", formData.get("amount"));
  }

  @Test
  void parseWithEmpty() {
    FormParser formParser = new FormParser();

    Map<String, String> formData = formParser.parse("");

    assertFalse(formData.containsKey("to"));
    assertFalse(formData.containsKey("amount"));
  }
}
