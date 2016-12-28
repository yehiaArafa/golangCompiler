package Main_Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author ninja
 */
public class LoadRegex {

    private String fileName = "regex.txt";
    private String row;

    public LoadRegex() throws FileNotFoundException, IOException {

        this.initiateParsing(new BufferedReader(new FileReader(Constants.Location + this.fileName)), Constants.csvParseSeparator);

    }

    public void initiateParsing(BufferedReader br, String regex) throws IOException {

        if (checkDirectory()) {

            while ((row = br.readLine()) != null) {
                String[] dataExtracted = row.split(regex);
                Constants.regexHashMap.put(dataExtracted[0], dataExtracted[1]);
            }
        }
    }

    private boolean checkDirectory() {
        File filecheck = new File(Constants.Location + this.fileName);
        boolean check = (filecheck.isFile()) ? true : false;
        return check;
    }
}
