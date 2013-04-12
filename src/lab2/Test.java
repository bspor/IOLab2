/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bspor
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String string = "(23)";
        Pattern pattern = Pattern.compile(".*\\(|\\).*");
        Matcher matcher = pattern.matcher(string);
//        while (matcher.matches()) {
//            System.out.println("dude " + matcher.group(1));
//        }
        LinkedList<String> list = new LinkedList<String>();
 //System.out.println(string.replaceAll(".*\\(|\\).*", "$1"));
        // Loop through and find all matches and store them into the List
        while(matcher.find()) { 
            list.add(matcher.group()); 
        }
        if (matcher.matches()) {
                System.out.println("yo " + matcher.groupCount());
        }
        // Print out the contents of this List
        for(String match : list) { 
            System.out.println(match); 
        }
        String s = "test string (67)";
        Pattern p = Pattern.compile("\\(.*\\)");
        Matcher m = p.matcher(s);
        if(m.find())
           System.out.println(m.group().subSequence(1, m.group().length()-1));
        
        //System.out.println(string.replaceAll(".*\\(|\\).*", "$1"));
    }
}
