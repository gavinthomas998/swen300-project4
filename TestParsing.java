import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests class for parsing.
 *
 * @author Ari
 * @author Julia
 * @author Gavin
 */
public class TestParsing
{
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
