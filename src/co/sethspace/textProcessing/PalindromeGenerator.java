package co.sethspace.textProcessing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PalindromeGenerator{
	
		/*
		 * This method takes a list of sentences and returns all possible palindromes and
		 * their frequency in a sorted Treemap
		 */
	
		public Map<String,Integer> computePalindromeFrequencies(List<String> Sentences){
		
			//Create a hash map to store count
			Map<String,Integer> palindromeCount = new HashMap<String,Integer>();
			
			//List to store word tokens
			List<String> wordTokens;
			
			//For each sentence in the list sentences received
			
			for(String s:Sentences){
				
				//Tokenize the words
				wordTokens = new MyTokenizer().tokenizeWords(s);
				
				//Concatenate all the words
				StringBuilder sb = new StringBuilder();
				for(String s2: wordTokens)
				    sb.append(s2);
				
				//Check if phrase is a palinderome, if it is add to map or update its frequency
				if(isPalindrome(sb.toString())){
					StringBuilder sb2 = new StringBuilder();
					for(String s3: wordTokens){
						sb2.append(s3);
						sb2.append(" ");
					}
					if(palindromeCount.containsKey(sb2.toString()))
						palindromeCount.put(sb2.toString(),palindromeCount.remove(sb2.toString())+1);
					else
						palindromeCount.put(sb2.toString(),1); 
				}
				
				//Check if each word is a palindrome or not
				for(String s1:wordTokens){
					if(isPalindrome(s1)){
						if(palindromeCount.containsKey(s1))
							palindromeCount.put(s1,palindromeCount.remove(s1)+1);
						else
							palindromeCount.put(s1,1);
					}
				}
			}
			return SortByValue(palindromeCount);
		}
	
	
		/*
		 * Helper static method for computing palindrome frequencies
		 */
		private static TreeMap<String, Integer> SortByValue (Map<String, Integer> m) {
		ValueComparator vc =  new ValueComparator(m);
		TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
		sortedMap.putAll(m);
		return sortedMap;
	}
	
		/*
		 * core method that checks if a string is Palindrome or not
		 */
		
		private boolean isPalindrome(String s){
			int length = s.length();
			//Ignoring palindromes smaller than length 2.
			if(s.length()<3)
				return false;
			int i=0;
			while(i<length/2){
				if(s.charAt(i)!=s.charAt(length-i-1)){
					return false;
				}
			i++;
			}
		return true;
		}
}