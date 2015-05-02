package co.sethspace.textProcessing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * This class compares two grams and their frequency and return the one with higher frequency
 * as larger than the one with lower frequency
 */

class ValueListComparator implements Comparator<List<String>> {
	 
    Map<List<String>, Integer> map;
 
    public ValueListComparator(Map<List<String>, Integer> m) {
        this.map = m;
    }
 
    @Override
	public int compare(List<String> a, List<String> b) {
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys 
    }
}

/*
 * This is the helper class for TwoGramGeneration with methods to find and compute
 * frequencies of two grams
 */

public class TwoGramGenerator{
	
	public Map<List<String>,Integer> computeTwoGramFrequencies(List<String> tokens){
		Map<List<String>,Integer> m = new HashMap<List<String>,Integer>();
		List<String> s1;
		for(int i=0;i<tokens.size()-1;i++){
			 s1 = new ArrayList<String>();
			 s1.add(tokens.get(i));
			 s1.add(tokens.get(i+1));
			if(m.containsKey(s1)){
				m.put(s1,m.remove(s1)+1);
			}
			else
				m.put(s1, 1);
		}
		
	return SortByValue(m);
	}
	
	public static TreeMap<List<String>, Integer> SortByValue 
	(Map<List<String>, Integer> m) {
		ValueListComparator vc =  new ValueListComparator(m);
		TreeMap<List<String>,Integer> sortedMap = new TreeMap<List<String>,Integer>(vc);
		sortedMap.putAll(m);
		return sortedMap;
	}
	
}