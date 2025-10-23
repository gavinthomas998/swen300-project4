/**
 * Stores the information about a given baby from one row of the file.
 *
 * @param state given state baby was born in
 * @param year given birth year of baby
 * @param name given name of baby
 * @param count increment
 * @param sex given sex of baby
 */
public record NameRecord(String state, int year, String name, int count, String sex) {}