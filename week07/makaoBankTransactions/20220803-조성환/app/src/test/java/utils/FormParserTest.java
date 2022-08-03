package utils;

import org.junit.jupiter.api.Test;
import pages.utils.FormParser;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FormParserTest {
  @Test
  void parse() {
    FormParser formParser = new FormParser();

    Map<String,String> formData = formParser.parse("to=2345&amount=1000");

    assertEquals("2345", formData.get("to"));
    assertEquals("1000", formData.get("amount"));
  }

  @Test
  void parseWithBlank() {
    FormParser formParser = new FormParser();

    Map<String,String> formData = formParser.parse("");

    assertFalse(formData.containsKey("to"));
  }
}
