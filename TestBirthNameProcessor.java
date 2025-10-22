import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void firstRecord() throws FileNotFoundException, NoMoreData
    {
        BirthNameProcessor f = new BirthNameProcessor("baby-names-by-state.csv");
        BirthNameProcessor.NameRecord rec = f.getNext();
        assertEquals("AK", rec.state());
        assertEquals(1960, rec.year());
        assertEquals("David", rec.name());
        assertEquals(151, rec.count());
    }

    /**
     *
     * @throws FileNotFoundException
     */
    @Test
    public void readLast() throws FileNotFoundException
    {
        BirthNameProcessor f = new BirthNameProcessor("baby-names-by-state.csv");
        BirthNameProcessor.NameRecord rec = null;
        boolean stillReading = true;
        while (stillReading)
        {
            try
            {
                rec = f.getNext();
            }
            catch(NoMoreData e)
            {
                stillReading = false;
            }
        }
        assertNotNull( rec );
        assertEquals("WY", rec.state());
        assertEquals(2008, rec.year());
        assertEquals("Mya", rec.name());
        assertEquals(6, rec.count());
    }
}
