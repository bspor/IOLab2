package lab3;

import lab1.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Brandon
 */
public class IOLab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //C:\Users\bspor\Documents\IO-Labs\IO-Labs\src\lab1\test
        String filePath = "src" + File.separatorChar + "lab1"
                + File.separatorChar + "test";
        File data = new File(filePath);
        String regexPattern = ".*\\(|\\).*";
        int recordLength = 7;
        String keyVal = "";


        Map<String, Map> key = new LinkedHashMap<String, Map>();
        Map<String, String> record = new LinkedHashMap<String, String>();
        List<Map> recordList = new ArrayList<Map>();


        BufferedReader in = null;
        String line = "";
        try {
            in = new BufferedReader(new FileReader(data));
            while (line != null) {
                //System.out.println(line);
                line = in.readLine();  // strips out any carriage return chars
                if (line != null) {
                    Pattern pattern = Pattern.compile(regexPattern);
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        //System.out.println(line);
                        keyVal = line;
                    } else {
                        //System.out.println("Add this to the record " + line);
                        String[] parts = line.split(":");
                        record.put(parts[0], parts[1]);
                    }
                    key.put(keyVal, new LinkedHashMap(record));
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
       //Throws and error if input is not correct. Validates magic number, 
       //err handling, and DIP, but it works for what we need it to for now.
       queryByRecordAndFieldName(key, "(2)", "city" );
    }
    
    public static void queryByRecordAndFieldName(Map<String, Map> key, String valKey, String field) {
            Map <String, String> mapOutput = new LinkedHashMap<String, String>(key.get(valKey));
            System.out.println(mapOutput.get(field));
    }
}
