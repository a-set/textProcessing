package co.sethspace.textProcessingTest;

import java.util.List;
import java.util.Map;

import co.sethspace.textProcessing.MyTokenizer;
import co.sethspace.textProcessing.TwoGramGenerator;

/*
 * Tests the 2 gram generator
 */

public class TestTwoGramGenerator {
	public static void main(String args[]){
		//WordFrequencies w = new WordFrequencies(); 
		MyTokenizer t = new MyTokenizer();
		List<String> tokens = t.tokenizeFile(args[0]);
		//Map<String, Integer> m = w.computeWordFrequencies(tokens);
		TwoGramGenerator tg = new TwoGramGenerator();
		Map<List<String>,Integer> m =  tg.computeTwoGramFrequencies(tokens);
		for (Map.Entry<List<String>, Integer> entry : m.entrySet()) {
		     System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
}