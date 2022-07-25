import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {
  @Test
  void defaultMessage() {
    MessageProvider messageProvider = new MessageProvider();

    assertEquals("Hello, World", messageProvider.message());
  }
  @Test
  void helloToYou() {
    MessageProvider messageProvider = new MessageProvider("sunghwan");

    assertEquals("Hello, sunghwan", messageProvider.message());
  }

}