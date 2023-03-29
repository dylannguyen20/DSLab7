package lab7;

import java.io.*;
import java.util.*;

public class file {
    
    public static void main(String[] args) throws FileNotFoundException {
        File fileList = new File ("Queen");
        File[] files = fileList.listFiles();
        ArrayList<TreeSet> songs = new ArrayList<TreeSet>();
        
        
        
        for (File file : files) {
            TreeSet<String> lyrics = new TreeSet<String>();
            Scanner scnr = new Scanner(file);
            while (scnr.hasNextLine()) {
                System.out.println(scnr.nextLine());
            }
        }

    }

}
