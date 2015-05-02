package co.sethspace.textProcessingTest;
import java.util.List;

import co.sethspace.textProcessing.MyTokenizer;

/*
 * This class accepts a file name as a command line argument and prints its tokens
 * Its a method to test the MyTokenizer class
 */

public class TestTokenizer {
	public static void main(String args[]){
		MyTokenizer u = new MyTokenizer(); 
		List<String> tokens = u.tokenizeFile(args[0]);
		for(String s:tokens)
			System.out.println(s);
			System.out.println(tokens.size());
	}
}