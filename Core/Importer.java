package Core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Importer {
    public static ArrayList<String> importList(String filePath) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(new File(filePath));

        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        return list;
    }
}
