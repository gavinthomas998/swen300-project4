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

    //Scanner used to get information from the given file
    private Scanner scanner;

    /**
     * Constructor for BirthNameProcessor.  Scans given file.
     *
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
     *
     * @return baby data
     */
    public NameRecord getNext() throws NoMoreData
    {
        if (!scanner.hasNextLine()) {
            throw new NoMoreData("bad >:(((");
        }
        String line = scanner.nextLine();
        String[] lineParts = line.split(",");
        String state = lineParts[0].substring(1,  lineParts[0].length() - 1);
        int year = Integer.parseInt(lineParts[1]);
        String name = lineParts[2].substring(1,  lineParts[2].length() - 1);
        int number = Integer.parseInt(lineParts[3]);
        String sex = lineParts[4];
        return new NameRecord(state, year, name, number, sex);

    }

    /**
     * Stores the information about a given baby from one row of the file.
     *
     * @param state given state baby was born in
     * @param year given birth year of baby
     * @param name given name of baby
     * @param count increment
     * @param sex given sex of baby
     */
    public record NameRecord(String state, int year, String name, int count, String sex)
    {

    }
}
