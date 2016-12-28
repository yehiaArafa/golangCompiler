package Main_Package;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ninja
 */
public class Main {

    private static Scanner scanner;
    private static String fileName;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        LoadRegex loadRegex = new LoadRegex();

        scanner = new Scanner(System.in);
        System.out.println(Strings.fileName);
        fileName = scanner.nextLine();

        Analyzer analyzer = new Analyzer(fileName);

    }

}
