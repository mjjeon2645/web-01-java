package utils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FormParser {
  public Map<String, String> parse(String line) {
    return Arrays.stream(line.split("&"))
        .map(pair -> pair.split("="))
        .filter(pair -> pair.length == 2)
        .collect(Collectors.toMap(
            keyAndValue -> keyAndValue[0],
            keyAndValue -> keyAndValue[1]));
  }
}
