package anagrams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * I pledge my honor that I have abided by the Stevens Honor System.
 * Kai Qi Chee
 */

//need to change visibilities of methods to public for these to run.
class AnagramsTest {
	Anagrams n=new Anagrams();

	
	//Tests for myHashCode(String s)
	@Test
	void test1() {
		long temp= 160193275;
		assertEquals(n.myHashCode("chicken"),temp);
	}
	
	@Test
	void test2() {
		long temp= 710;
		assertEquals(n.myHashCode("cat"),temp);
	}
	
	@Test
	void test3() {
		long temp= 856957;
		assertEquals(n.myHashCode("phil"),temp);
	}
	
	@Test
	void test4() {
		long temp= 266570;
		assertEquals(n.myHashCode("chair"),temp);
	}
	
	@Test
	void test5() {
		long temp= 795982843;
		assertEquals(n.myHashCode("purple"),temp);
	}
	
	//Tests for getMaxEntries()
	@Test
	void test6() {
		n.addWord("tops");
		n.addWord("stop");
		n.addWord("spot");
		n.addWord("pots");
		n.addWord("chicken");
		long t1=11849687;
		ArrayList<String> t2=new ArrayList<String>();
		t2.add("tops");
		t2.add("stop");
		t2.add("spot");
		t2.add("pots");
		assertEquals(n.getMaxEntries().get(0).getKey(),t1);
		assertEquals(n.getMaxEntries().get(0).getValue(),t2);

	}
	
	@Test
	void test7() {
		n.addWord("pots");
		n.addWord("chicken");
		long t1=11849687;
		ArrayList<String> t2=new ArrayList<String>();
		t2.add("pots");
		long t4=160193275;
		ArrayList<String> t3=new ArrayList<String>();
		t3.add("chicken");
		assertEquals(n.getMaxEntries().get(0).getKey(),t1);
		assertEquals(n.getMaxEntries().get(0).getValue(),t2);
		assertEquals(n.getMaxEntries().get(1).getKey(),t4);
		assertEquals(n.getMaxEntries().get(1).getValue(),t3);
	}
	
	@Test
	void test8() {
		n.addWord("pots");
		n.addWord("chicken");
		long t1=11849687;
		ArrayList<String> t2=new ArrayList<String>();
		t2.add("pots");
		long t4=160193275;
		ArrayList<String> t3=new ArrayList<String>();
		t3.add("chicken");
		assertEquals(n.getMaxEntries().get(0).getKey().equals(t4),false);
		assertEquals(n.getMaxEntries().get(0).getValue(),t2);
		assertEquals(n.getMaxEntries().get(1).getKey().equals(t1),false);
		assertEquals(n.getMaxEntries().get(1).getValue(),t3);

	}
	
	@Test
	void test9() {
		ArrayList<Map.Entry<Long,ArrayList<String>>> temp=new ArrayList<Map.Entry<Long,ArrayList<String>>>();
		assertEquals(n.getMaxEntries().equals(temp),true);
	}

	
//	Tests for addWord(String s)
	@Test
	void test10() {
		n.addWord("hello");
		Map<Long,ArrayList<String>> temp=new HashMap<Long,ArrayList<String>>();
		long x=13447687;
		ArrayList<String> y=new ArrayList<String>();
		y.add("hello");
		temp.put(x, y);
		assertEquals(n.anagramTable,temp);
	}
	
	
	@Test
	void test11() {
		n.addWord("hello");
		n.addWord("hlelo");
		n.addWord("helol");
		Map<Long,ArrayList<String>> temp=new HashMap<Long,ArrayList<String>>();
		long x=13447687;
		ArrayList<String> y=new ArrayList<String>();
		y.add("hello");
		y.add("hlelo");
		y.add("helol");
		temp.put(x, y);
		assertEquals(n.anagramTable,temp);
	}
	
	@Test
	void test12() {
		n.addWord("hello");
		n.addWord("hlelo");
		n.addWord("goodbye");
		Map<Long,ArrayList<String>> temp=new HashMap<Long,ArrayList<String>>();
		long x=13447687;
		ArrayList<String> y=new ArrayList<String>();
		y.add("hello");
		y.add("hlelo");
		long a=841450071;
		ArrayList<String> b=new ArrayList<String>();
		b.add("goodbye");
		temp.put(x, y);
		temp.put(a, b);
		assertEquals(n.anagramTable,temp);
	}
	
	
	//Test for buildLetterTable()
	@Test
	void test13() {
		Map<Character,Integer> temp=new HashMap<Character,Integer>();
		temp.put('a',2);
		temp.put('b',3);
		temp.put('c',5);
		temp.put('d',7);
		temp.put('e',11);
		temp.put('f',13);
		temp.put('g',17);
		temp.put('h',19);
		temp.put('i',23);
		temp.put('j',29);
		temp.put('k',31);
		temp.put('l',37);
		temp.put('m',41);
		temp.put('n',43);
		temp.put('o',47);
		temp.put('p',53);
		temp.put('q',59);
		temp.put('r',61);
		temp.put('s',67);
		temp.put('t',71);
		temp.put('u',73);
		temp.put('v',79);
		temp.put('w',83);
		temp.put('x',89);
		temp.put('y',97);
		temp.put('z',101);
		n.buildLetterTable();
		assertEquals(n.letterTable.equals(temp),true);
	}
}
