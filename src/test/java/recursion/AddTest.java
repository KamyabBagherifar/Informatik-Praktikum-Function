import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {

  @DisplayName("2 plus 3")
  @Test
  void simpleAdd() {
    int expects = 5;
    int received = add(2, 3);
    assertEquals(expects, received);
  }
}