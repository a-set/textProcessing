package co.sethspace.textProcessing;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyTokenizer{
	
	/*
	 * This method takes the name of a text file and return
	 * a list containing tokens in that file
	 */
	@SuppressWarnings("resource")
	public List<String> tokenizeFile(String TextFile){
		BufferedReader br;
		List<String> tokens= new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(new File(TextFile)));
			Scanner sc;
			sc = new Scanner(br).useDelimiter("[^A-Za-z0-9]+");
			while (sc.hasNext())
					tokens.add(sc.next().toLowerCase());	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return tokens;
	}
	
	/*
	 * This is ver2 of tokenizeFile , which returns a map instead of a list by combining the 
	 * frequency of occurrence of a word, to not violate overloading rules , we add a dummy
	 * integer variable ver
	 */
	public Map<String,Integer> tokenizeFile(String TextFile,int ver){
		BufferedReader br;
		Map<String,Integer> m = new HashMap<String,Integer>();
		try {
			br = new BufferedReader(new FileReader(new File(TextFile)));
			String s;
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(br).useDelimiter("[^A-Za-z0-9]+");
			while (sc.hasNext()){
				s = sc.next().toLowerCase();
				if(m.containsKey(s)){
					m.put(s,m.remove(s)+1);
				}
				else
					m.put(s,1);
			}
	} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	/*
	 * This is a sentence tokenizer , that tokenizes sentences instead of words
	 */
	public List<String> sentenceTokenizer(String TextFile){
		BufferedReader br;
		List<String> tokens = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(new File(TextFile)));
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(br).useDelimiter("[.?!]");
			while (sc.hasNext())
				tokens.add(sc.next().toLowerCase().replaceAll("\\r?\\n", " "));
			
	} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return tokens;
	}
	
	/*
	 * This tokenizer takes a sentence and break into constituent words
	 * Returns a List of words
	 */
	
	@SuppressWarnings("resource")
	public List<String> tokenizeWords(String sentence){
		List<String> tokens= new ArrayList<String>();
		Scanner sc;
		sc = new Scanner(sentence).useDelimiter("[^A-Za-z0-9]+");
		while (sc.hasNext())
			tokens.add(sc.next());	
		return tokens;
	}
}
