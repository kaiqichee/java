package anagrams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * I pledge my honor that I have abided by the Stevens Honor System.
 * @author Kai Qi Chee
 *
 */

public class Anagrams {
	final Integer[] primes =  
			{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
			31, 37, 41, 43, 47, 53, 59, 61, 67, 
			71, 73, 79, 83, 89, 97, 101};
	Map<Character,Integer> letterTable;
	Map<Long,ArrayList<String>> anagramTable;

	/**
	 * Builds the hash table letterTable which consists of the first
	 * 26 prime numbers being assigned to a unique letter.
	 */
	private void buildLetterTable() {
		Character[] alph = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
						 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
						 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		letterTable=new HashMap<Character, Integer>();
		for(int i=0;i<primes.length;i++){
			letterTable.put(alph[i], primes[i]);
		}
	}
	
	Anagrams() {
		buildLetterTable();
		anagramTable = new HashMap<Long,ArrayList<String>>();
	}

	/**
	 * Computes the hashcode of the string s passed as an argument, and
	 * adds this string to the hash table anagramTable with its hashcode as its key.
	 * If identical hashcode is already in anagramTable, s is added to the list of values
	 * associated with that key.
	 * @param s String to be added to anagramTable
	 */
	private void addWord(String s) { //why is it ArrayList<String>>, and not just String?
		ArrayList<String> temp=new ArrayList<String>(); //should temp hold the whole word, or each letter individually [hello] vs [h e l l o]?
		long t=myHashCode(s);
		if (anagramTable.containsKey(t)==false) {
			temp.add(s);
			anagramTable.put(myHashCode(s), temp);
		}
		else {
			temp=anagramTable.get(t);
			temp.add(s);
			anagramTable.replace(t, temp);
		}	
	}
	/**
	 * Given a string s, computes its hash code. Uses to the fundamental theorem of arithmetic
	 * such that two strings with the same letters will have the same hashcode.
	 * @param s The string to return as a hashcode
	 * @return Long, the value of the hashcode of s
	 */
	private long myHashCode(String s) {
		int h=1;
		for (int i=0;i<s.length();i++){
			h=h*letterTable.get(s.charAt(i));
		}
		return h;
	}
	
	/**
	 * Receives the name of a text file containing words, 
	 * one per line, and builds the hash table anagramTable.
	 * @param s The name of the text file
	 * @throws IOException
	 */
	public void processFile(String s) throws IOException {
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null)   {
		  this.addWord(strLine);
		}
		br.close();
	}

	/**
	 * Iterates through an anagramTable and returns the entries 
	 * in the anagramTable that have the largest number of anagrams.
	 * @return an ArraList with the key and values of words with most anagrams
	 */
	private ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
		int max=1;
		ArrayList<Map.Entry<Long,ArrayList<String>>> t=new ArrayList<Map.Entry<Long,ArrayList<String>>>();
		
		Set<Entry<Long, ArrayList<String>>> temp=anagramTable.entrySet();
		Iterator<Entry<Long,ArrayList<String>>> n=temp.iterator();

		while (n.hasNext()) {
			Entry<Long,ArrayList<String>> h=n.next();
			if(h.getValue().size()>max) {
				max=h.getValue().size();
				t.clear();
				t.add(h);
			}
			else if(h.getValue().size()==max) {
				t.add(h);
			}
		}
		return t;
		
	}

	/**
	 * Reads all the strings in a file, place them in the hash 
	 * table of anagrams and then iterate over the hash table 
	 * to report which words have the largest number of anagrams.
	 * @param args
	 */
	public static void main(String[] args) {
		Anagrams a = new Anagrams();

		final long startTime = System.nanoTime();    
		try {
			a.processFile("words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double) estimatedTime/1000000000);
		System.out.println("Time: "+ seconds);
		System.out.println("List of max anagrams: "+ maxEntries);

//		//Print statements in the requirements doc but not the stub.
//		System.out.println("Key of max anagrams: "+ maxEntries.get(0).getKey());
//		System.out.println("List of max anagrams: "+ maxEntries.get(0).getValue());
//		System.out.println("Length of List of max anagrams: "+ maxEntries.get(0).getValue().size());
//		

	}
}
