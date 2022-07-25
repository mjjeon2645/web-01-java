import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {

  @Test
  void defaultMessage() {
    MessageProvider messageProvider = new MessageProvider();

    assertEquals("Hello, world!", messageProvider.message());
  }

  @Test
  void messageToYou() {
    MessageProvider messageProvider = new MessageProvider("Human Hunter I.N.U");

    assertEquals("Hello, Human Hunter I.N.U!", messageProvider.message());
  }
}