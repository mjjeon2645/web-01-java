import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {

  @Test
  void defaultMessage() {
    MessageProvider messageProvider = new MessageProvider();

    assertEquals("Hello, world!", messageProvider.message());
  }

  @Test
  void messageWithName() {
    MessageProvider messageProvider = new MessageProvider("ashal");

    assertEquals("Hello, ashal!", messageProvider.message());
  }
}