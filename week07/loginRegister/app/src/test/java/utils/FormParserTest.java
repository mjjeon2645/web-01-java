package utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FormParserTest {
  @Test
  void parse() {
    FormParser formParser = new FormParser();
    String rawData = "name=전민지&id=mjjeon2645&password=1234" +
        "&check-password=1234&email=angel2645@naver.com";

    Map<String, String> formData =
        formParser.parse(rawData);

    assertEquals("전민지", formData.get("name"));
    assertEquals("mjjeon2645", formData.get("id"));
    assertEquals("1234", formData.get("password"));
    assertEquals("1234", formData.get("check-password"));
    assertEquals("angel2645@naver.com", formData.get("email"));

    assertEquals(5, formData.size());
  }
}
