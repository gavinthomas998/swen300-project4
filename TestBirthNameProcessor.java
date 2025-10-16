import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests class for BirthNameProcessor.
 *
 * @author Ari
 * @author Julia
 * @author Gavin
 */
public class TestBirthNameProcessor
{
    /**
     * Test to make sure data is read in and stored.
     *
     * @throws FileNotFoundException if file data is not found
     */
    @Test
    public void firstRecord() throws FileNotFoundException {
        BirthNameProcessor f = new BirthNameProcessor("baby-names-by-state.csv");
        BirthNameProcessor.NameRecord rec = f.getNext();
        assertEquals("AK", rec.state());
        assertEquals(1960, rec.year());
        assertEquals("David", rec.name());
        assertEquals(151, rec.count());
    }
}
