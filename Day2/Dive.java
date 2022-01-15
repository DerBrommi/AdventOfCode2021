package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dive {
    public static void main(String[] args) throws FileNotFoundException {
        dive();
        System.out.println("\n======================================\nAim:");
        diveWithAim();
    }

    public static void dive() throws FileNotFoundException {
        // [position, depth]
        int[] position = new int[2];

        Scanner scanner = new Scanner(new File("Day2/input.txt"));

        while (scanner.hasNext()) {

            Pattern number = Pattern.compile("\\d");
            String currentLine = scanner.nextLine();

            // Extract digits
            Matcher digits = number.matcher(currentLine);
            digits.find();
            digits.group();
            int value = Integer.valueOf(digits.group());

            if (currentLine.matches("forward [0-9]")) {
                position[0] += value;
            } else if (currentLine.matches("down [0-9]")) {
                position[1] += value;
            } else if (currentLine.matches("up [0-9]")) {
                position[1] -= value;
            }
        }

        System.out.println("Position: " + position[0]);
        System.out.println("Depth: " + position[1]);
        System.out.println("Result: " + position[0] * position[1]);
        scanner.close();
    }

    private static void diveWithAim() throws FileNotFoundException {
        // [position, depth, aim]
        int[] position = new int[3];

        Scanner scanner = new Scanner(new File("Day2/input.txt"));

        while (scanner.hasNext()) {
            Pattern number = Pattern.compile("\\d");
            String currentLine = scanner.nextLine();

            // Extract digits
            Matcher digits = number.matcher(currentLine);
            digits.find();
            digits.group();
            int value = Integer.valueOf(digits.group());

            if (currentLine.matches("forward [0-9]")) {
                position[0] += value;
                position[1] += value * position[2];
            } else if (currentLine.matches("down [0-9]")) {
                position[2] += value;
            } else if (currentLine.matches("up [0-9]")) {
                position[2] -= value;
            }
        }

        System.out.println("Position: " + position[0]);
        System.out.println("Depth: " + position[1]);
        System.out.println("Result: " + position[0] * position[1]);
        scanner.close();
    }
}
