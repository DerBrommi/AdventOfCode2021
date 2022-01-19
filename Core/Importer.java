package Core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Importer {
    public static ArrayList<String> importList(int day) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();

        Scanner scanner = new Scanner(new File("data/Day " + ((day < 10) ? "0" + day : day) + "/input.txt"));

        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        return list;
    }
}
