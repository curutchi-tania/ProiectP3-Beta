import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {
    @Test
    public void testClientGet() {
        Client client1 = new Client("Tania");
        assertEquals(-1, client1.getId());
        assertEquals("Tania", client1.getNume());

        Client client2 = new Client(13, "ABC");
        assertEquals(13, client2.getId());
        assertEquals("ABC", client2.getNume());
    }
}
