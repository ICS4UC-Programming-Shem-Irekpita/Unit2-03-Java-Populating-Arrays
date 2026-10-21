/*
 * Created by: Shem
 * Created on: Oct, 10, 2026
 * Generates an array of 10 random integers (0 to 100),
 * displays them on one line, then sorts the array with
 * Arrays.sort(), calculates the average, and displays the
 * sorted array and average. This process is repeated 5 times.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * Utility class for populating arrays and calculating averages.
 */
public final class PopulatingArrays {

    /** Input file path constant. */
    static final String INPUT_FILE = "input.txt";

    /** Output file path constant. */
    static final String OUTPUT_FILE = "output.txt";

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private PopulatingArrays() {
    }

    /**
     * Appends text to a specified file.
     *
     * @param fileName the target file path
     * @param text the content to append
     * @throws IOException if an I/O error occurs
     */
    public static void appendLine(
        final String fileName, final String text)
        throws IOException {

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(text + "\n");
        }
    }

    /**
     * Populates an array with 10 random integers from 0 to 100.
     *
     * @return an array of 10 random integers
     * @throws IOException if an I/O error occurs
     */
    public static int[] populateArray() throws IOException {
        int[] numbers = new int[10];
        Random rand = new Random();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(101); // 0 to 100
            line.append(numbers[i]).append(" ");
        }
        String text = line.toString().trim();
        System.out.println(text);
        appendLine(INPUT_FILE, text);
        return numbers;
    }

    /**
     * Sorts array, calculates average, and writes to output file.
     *
     * @param numbers the array of integers to process
     * @throws IOException if an I/O error occurs
     */
    public static void calculateAverage(final int[] numbers)
        throws IOException {

        Arrays.sort(numbers);
        int sum = 0;
        StringBuilder line = new StringBuilder();
        for (int n : numbers) {
            sum += n;
            line.append(n).append(" ");
        }
        double average = (double) sum / numbers.length;
        String text = String.format(
            "%s  Average:  %.1f", line.toString().trim(), average);
        System.out.println(text);
        appendLine(OUTPUT_FILE, text);
    }

    /**
     * Main entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {

        try {

            new FileWriter(INPUT_FILE, false).close(); // clear file

            new FileWriter(OUTPUT_FILE, false).close();

            for (int i = 0; i < 5; i++) {

                int[] numbers = populateArray();

                calculateAverage(numbers);

            }

        } catch (IOException e) {

            System.out.println("File error: " + e.getMessage());

        }

    }
}
