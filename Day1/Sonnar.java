package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Day1
 */
public class Sonnar {

    public static void main(String[] args) throws FileNotFoundException {
        basicScanner();
        advancedScanner();
    }

    public static void basicScanner() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day1/input.txt"));

        int counter = 0;
        int prevValue = scanner.nextInt();

        while (scanner.hasNextInt()) {
            int currentDepth = scanner.nextInt();

            if (currentDepth > prevValue)
                counter++;

            prevValue = currentDepth;
        }

        System.out.println("Basic Counter: " + counter);
    }

    public static void advancedScanner() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day1/input.txt"));

        int counter = 0;
        int[] prevWindow = { scanner.nextInt(), scanner.nextInt(), scanner.nextInt() };
        int[] window = { prevWindow[1], prevWindow[2], scanner.nextInt() };

        while (scanner.hasNext()) {

            if (IntStream.of(window).sum() > IntStream.of(prevWindow).sum())
                counter++;

            prevWindow = window.clone();
            window[0] = window[1];
            window[1] = window[2];
            window[2] = scanner.nextInt();
        }

        // Last Entry isn't counted
        if (IntStream.of(window).sum() > IntStream.of(prevWindow).sum())
            counter++;

        System.out.println("Advanced Counter: " + counter);
    }
}