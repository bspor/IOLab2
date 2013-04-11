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
       String string = "How/WRB can/MD I/PRP find/VB a/DT list/NN of/IN celebrities/NNS '/POS real/JJ names/NNS ?/.";
        Pattern pattern = Pattern.compile("(?<=/).+?(?= |$)");
        Matcher matcher = pattern.matcher(string);

        LinkedList<String> list = new LinkedList<String>();

        // Loop through and find all matches and store them into the List
        while(matcher.find()) { 
            list.add(matcher.group()); 
        }

        // Print out the contents of this List
        for(String match : list) { 
            System.out.println(match); 
        }
    }
}
