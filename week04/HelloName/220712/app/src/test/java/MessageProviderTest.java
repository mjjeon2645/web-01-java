import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {
  @Test
  void messageWithoutName() {
    MessageProvider messageProvider = new MessageProvider();

    assertEquals("Hello, world!",messageProvider.greetingMessage());
  }
  @Test
  void message() {
    String name = "123";
    MessageProvider messageProvider = new MessageProvider(name);

    assertEquals("Hello, 123!",messageProvider.greetingMessage());
  }

}