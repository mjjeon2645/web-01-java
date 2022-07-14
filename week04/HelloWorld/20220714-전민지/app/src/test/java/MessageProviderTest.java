import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {
  @Test
  void defaultMessage() {
    MessageProvider messageProvider = new MessageProvider();

    assertEquals("Hello, world!", messageProvider.message());
  }

  @Test
  void HelloToYou() {
    MessageProvider messageProvider = new MessageProvider("Ashal");

    assertEquals("Hello, Ashal!", messageProvider.message());
  }
}
