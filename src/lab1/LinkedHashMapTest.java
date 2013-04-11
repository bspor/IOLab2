package lab1;
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
 * @author bspor
 */
public class LinkedHashMapTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //C:\Users\bspor\Documents\IO-Labs\IO-Labs\src\lab1\test
       File data = new File("src" + File.separatorChar + "lab1"+ 
                        File.separatorChar + "test");
        //Map<String, String> map = new LinkedHashMap<String, String>();
        //List<Map> recordList = new ArrayList<Map>();
        BufferedReader in = null;
        String line = "";
        try {
	   in = new BufferedReader(new FileReader(data));
	   while(line != null){
		 // System.out.println(line);
		  line = in.readLine();  // strips out any carriage return chars
                  if(line != null) {
                     Pattern pattern = Pattern.compile(".*\\(|\\).*");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        System.out.println("I found the text " + matcher.group() + " starting at " 
        + "index " + matcher.start() + " and ending at index " + matcher.end());
                        //System.out.println(matcher.group(1));
                    }
                  }
	   }
	 
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
        


        //System.out.println(map.toString());
        
    }
}
