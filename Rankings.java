import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * A class for Ranking.
 * 
 * @author Dylan Nguyen
 * @version 28 March 2023
 */
public class Rankings {
	
	private TreeMap<String,Double> Scores = new TreeMap<>();
	private TreeMap<String,TreeSet> songs;
	
	public TreeMap<String,Double> Rank (String s) {
		
		String str = s;
		String[] terms = str.split("\\s+");
		
		/*
		 * Calculates the TF-IDF scores for the songs.
		 */
		for (int i = 0; i < songs.size(); i++) {		
			double score = 0.0;			
			for (int j = 0; i < terms.length; i++) {
				score = score + tf(terms[j],songs.keySet().toArray()[i]) * IDF(terms[j],songs.keySet().toArray()[i]);				
		}
			Scores.put((String) songs.keySet().toArray()[i], score);
	}
		Comparator<String> scoreComp = new Comparator<String>() {
			public int compare(String d1, String d2) {				
				return Double.compare(Scores.get(d2), Scores.get(d1));				
			}			
		};
		
		/*
		 * Sorts and prints the top 5 ranked scores.
		 */
		TreeMap<String,Double> Rankings = new TreeMap<>(scoreComp);
		Rankings.putAll(Scores);		
		Iterator<String> itr = Rankings.keySet().iterator();
		int count = 0;
		
		while (itr.hasNext() && count < 5) {
			String key = itr.next();
			System.out.println("Rank " + (count+1) + ": " + key + "Score: " + Rankings.get(key));
			count++;
		}
		return Rankings;
}
}
