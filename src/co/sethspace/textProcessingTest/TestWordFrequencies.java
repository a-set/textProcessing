package co.sethspace.textProcessingTest;

import java.util.Map;

import co.sethspace.textProcessing.FrequencyCalc;
import co.sethspace.textProcessing.MyTokenizer;

/*
 * This is just a class used to test the API
 */

public class TestWordFrequencies {
	public static void main(String args[]){
		FrequencyCalc f = new FrequencyCalc(); 
		MyTokenizer t = new MyTokenizer();
		Map<String,Integer> tokens = t.tokenizeFile(args[0],1);
		Map<String, Integer> m = f.computeWordFrequencies(tokens);
		//print the map
		for (Map.Entry<String, Integer> entry : m.entrySet()) {
		     System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
}