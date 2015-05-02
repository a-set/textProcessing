package co.sethspace.textProcessing;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

	/*
	 * This class compares two strings and returns the one with higher frequency in the file
	 */
	 class ValueComparator implements Comparator<String> {
		 
	    Map<String, Integer> map;
	 
	    public ValueComparator(Map<String, Integer> base) {
	        this.map = base;
	    }
	 
	    @Override
		public int compare(String a, String b) {
	        if (map.get(a) >= map.get(b)) {
	            return -1;
	        } else {
	            return 1;
	        	}
	    	}
		}

	
	/*
	 * This class is generally compilation of methods that help calculate frequency
	 */
	public class FrequencyCalc{
		
		/*
		 * This method takes a Map of words and word counts, sorts it by word count and returns
		 * a sorted Tree Map
		 */
		
		public Map<String,Integer> computeWordFrequencies(Map<String,Integer> tokens){
			TreeMap<String, Integer> m1 = SortByValue(tokens);
			return m1;
		}
 
		/*
		 * This is in an internal method called by computeWordFrequencies to sort
		 * the treemap using the comparator class
		 */
		private static TreeMap<String, Integer> SortByValue 
				(Map<String, Integer> m) {
			ValueComparator vc =  new ValueComparator(m);
			TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
			sortedMap.putAll(m);
			return sortedMap;
		}
}