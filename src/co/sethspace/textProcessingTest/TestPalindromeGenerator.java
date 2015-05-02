package co.sethspace.textProcessingTest;

import java.util.List;
import java.util.Map;

import co.sethspace.textProcessing.MyTokenizer;
import co.sethspace.textProcessing.PalindromeGenerator;

/*
 * Tester class to test palindrome generator method
 */

public class TestPalindromeGenerator {
	public static void main(String args[]){
		MyTokenizer t = new MyTokenizer();
		List<String> sentences = t.sentenceTokenizer(args[0]);
		PalindromeGenerator p = new PalindromeGenerator();
		Map<String,Integer> m = p.computePalindromeFrequencies(sentences);
		for (Map.Entry<String, Integer> entry : m.entrySet()) {
		     System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
}