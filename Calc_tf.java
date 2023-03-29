package Lab7;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Seth Tedder
 * @version 28 March, 2023
 */
public class Calc_tf {
	
	File file;
	
	/**
	 * Constructor.  Should be given a file to read
	 * @param f
	 */
	public Calc_tf(File f) {
		file = f;
	}
	
	/**
	 * Calculates and returns the dividend of total matching words and total words from the file
	 * @param phrase
	 * @return 
	 */
	public double tfCalc(String phrase) {
		double totalW = 0;
		double totalP = 0;
		try {
			//to scan the file
		Scanner scnr = new Scanner(this.file);
		
		//moves scanner over each line in the file
		while(scnr.hasNextLine()) {
			//creates string out of the next line
			String line = scnr.nextLine();
			//iterates through the line looking for matches to phrase.  May update to use .hasNext(Pattern)
			for (int i = 0; i < line.length() - phrase.length() + 1; i++) {
				if (line.substring(i, i + phrase.length()).equals(phrase)) {
					totalP++;
				}
			}
			//Scans the line
			Scanner lineScanner = new Scanner(line);
			//Count the number of words in the line
			while (lineScanner.hasNext()) {
				lineScanner.next();
				totalW++;
			}
			lineScanner.close();
		}
		
		scnr.close();
		} catch (Exception e) {
			System.out.println("File Not Found!");
		}
		
		double result = totalP / totalW;
		return result;
	}
	/**
	 * Main method used for testing
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("Brighton Rock.txt");
		Calc_tf tf = new Calc_tf(file);
		System.out.println(tf.tfCalc("will"));
	}
}
