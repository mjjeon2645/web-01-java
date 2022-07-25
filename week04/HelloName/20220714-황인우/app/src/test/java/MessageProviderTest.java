import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {

  @Test
  void defaultMessage() {
    MessageProvider messageProvider = new MessageProvider();

    assertEquals("Hello, world!", messageProvider.message());
  }

  void messageToYou() {
    MessageProvider messageProvider = new MessageProvider("Eevee");

    assertEquals("Hello, Eevee!", messageProvider.message());
  }
}
