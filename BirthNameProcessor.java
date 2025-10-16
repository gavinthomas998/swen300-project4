import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that processes birth names from a given list.
 *
 * @author Ari
 * @author Julia
 * @author Gavin
 */
public class BirthNameProcessor {

    private Scanner scanner;

    /**
     * Constructor for BirthNameProcessor
     * @param filename file passed into function to be scanned
     * @throws FileNotFoundException no file
     */
    public BirthNameProcessor(String filename) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
        if (scanner.hasNextLine())
        {
            // Skip the header line
            scanner.nextLine();
        }
    }

    /**
     *
     *
     * @return the info
     */
    public NameRecord getNext()
    {
        if (!scanner.hasNextLine()) { return null; }

        String line = scanner.nextLine();
        String[] lineParts = line.split(",");

        String state = lineParts[0].substring(1,  lineParts[0].length() - 1);
        int year     = Integer.parseInt(lineParts[1]);
        String name  = lineParts[2].substring(1,  lineParts[2].length() - 1);
        int number   = Integer.parseInt(lineParts[3]);
        String sex   = lineParts[4];

        return new NameRecord(state, year, name, number, sex);
    }

    /**
     * Javadoc comments
     *
     * @param state
     * @param year
     * @param name
     * @param count
     */
    public record NameRecord(String state, int year, String name, int count, String sex) {

    }
}
