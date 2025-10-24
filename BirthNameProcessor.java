import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that processes birth names from a given list.
 * @author Ari
 * @author Julia
 * @author Gavin
 */
public class BirthNameProcessor
{
    private Scanner scanner;
    /**
     * Constructor for BirthNameProcessor.  Scans given file.
     * @param filename file passed into function to be scanned
     * @throws FileNotFoundException if no file is found
     */
    public BirthNameProcessor(String filename) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
        if (scanner.hasNextLine())
        {
            scanner.nextLine(); // Skip the header line
        }
    }
    /**
     * Reads and parses the next line of baby name data.
     * @return baby data
     */
    public NameRecord getNext() throws NoMoreData
    {
        NameRecord result = null;
        boolean validLineFound = false;

        while (!validLineFound)
        {
            if (!scanner.hasNextLine()) { throw new NoMoreData(); }

            try
            {
                String currentLine = scanner.nextLine();
                String[] lineParts = currentLine.split(",");

                String state = lineParts[0].substring(1, lineParts[0].length() - 1);
                int year = Integer.parseInt(lineParts[1]);
                String name = lineParts[2].substring(1, lineParts[2].length() - 1);
                int count = Integer.parseInt(lineParts[3]);
                String sex = lineParts[4].substring(1, lineParts[4].length() - 1);
                result = new NameRecord(state, year, name, count, sex);
                validLineFound = true;
            } catch (NumberFormatException _) {}
        }
        return result;
    }
}
