package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Core.*;

public class BinaryDiagnostic {
    public static void main(String[] args) throws FileNotFoundException {
        binaryDiagnostic();
        System.out.println("\n=====================================================\n");
        lifeSupportRating();
    }

    public static void binaryDiagnostic() throws FileNotFoundException {
        // Scanner to just read line count
        // Else scanner skips first line
        Scanner lscanner = new Scanner(new File("Day3/input.txt"));
        Scanner scanner = new Scanner(new File("Day3/input.txt"));

        int lineCount = 0;
        int[] counter = new int[lscanner.nextLine().length()];
        lscanner.close();

        while (scanner.hasNext()) {
            char[] currentLine = scanner.nextLine().toCharArray();
            lineCount++;

            for (int i = 0; i < currentLine.length; i++) {
                if (currentLine[i] == '1')
                    counter[i]++;
            }

        }

        String gammaRate = "";
        String epsilonRate = "";

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > lineCount / 2)
                gammaRate += 1;
            else
                gammaRate += 0;

            if (counter[i] < lineCount / 2)
                epsilonRate += 1;
            else
                epsilonRate += 0;
        }

        int gammaRateDec = Integer.parseInt(gammaRate, 2);
        int epsilonRateDec = Integer.parseInt(epsilonRate, 2);

        System.out.println("Line Count: " + lineCount);
        System.out.println("Gamma: " + gammaRateDec);
        System.out.println("Epsilon: " + epsilonRateDec);
        System.out.println("Result: " + gammaRateDec * epsilonRateDec);
    }

    // Not Ready yet
    public static void lifeSupportRating() throws FileNotFoundException {
        List<String> list = Importer.importList("Day3/input.txt");
        int stringLength = list.get(0).length();

        String oxyString = "";
        String co2String = "";
        List<String> oxyList = list;
        List<String> co2List = list;

        for (int bitPos = 0; bitPos < stringLength; bitPos++) {
            int oxyCounter = 0;
            int co2Counter = 0;

            for (String line : oxyList) {
                oxyCounter += Character.getNumericValue(line.charAt(bitPos));
            }
            for (String line : co2List) {
                co2Counter += Character.getNumericValue(line.charAt(bitPos));
            }

            if (oxyCounter > oxyList.size() / 2)
                oxyString += 1;
            else
                oxyString += 0;

            if (co2Counter > co2List.size() / 2)
                co2String += 0;
            else
                co2String += 1;

            final String oxyFilter = oxyString;
            final String co2Filter = co2String;

            if (oxyList.size() > 1)
                oxyList = oxyList.parallelStream().filter(c -> c.startsWith(oxyFilter))
                        .collect(Collectors.toList());

            if (co2List.size() > 1)
                co2List = co2List.parallelStream().filter(d -> d.startsWith(co2Filter))
                        .collect(Collectors.toList());

        }
        int oxyRate = Integer.parseInt(oxyList.get(0), 2);
        int co2Rate = Integer.parseInt(co2List.get(0), 2);

        System.out.println("OxyRate: " + oxyRate);
        System.out.println("Co2Rate: " + co2Rate);
        System.out.println("Result: " + co2Rate * oxyRate);

    }
}
