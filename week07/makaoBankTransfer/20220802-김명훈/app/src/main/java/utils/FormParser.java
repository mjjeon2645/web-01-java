package utils;

import java.util.*;
import java.util.stream.*;

public class FormParser {
  public Map<String, String> parse(String text) {

    return Arrays.stream(text.split("&"))
        .map(pair -> pair.split("="))
        .collect(Collectors.toMap(i -> i[0], i -> i[1]));
  }
}
