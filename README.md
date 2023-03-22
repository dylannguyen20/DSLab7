# DSLab7

package sdf;

import java.io.*;
import java.util.*;

public class filereading {

	public static void main(String[] args) throws FileNotFoundException {
		File fileList = new File ("Queen");
		File[] files = fileList.listFiles();
		ArrayList<TreeSet> songs = new ArrayList<TreeSet>();
		
		
		
		for (int i = 0; i < files.length; i++) {
			TreeSet<String> lyrics = new TreeSet<String>();
			Scanner scnr = new Scanner(files.);
			if(scnr.hasNextLine()) {
				lyrics.get(i)
			}
		}

	}

}
