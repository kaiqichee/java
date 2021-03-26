package treaps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * I pledge my honor that I have abided by the Stevens Honor System.
 * @author kaiqi_iwda0g1
 *
 */
class TreapTest {
	Treap<Integer> n=new Treap<Integer>();

	//Tests for add(E key)
	@Test
	void test1() {
		assertEquals(n.add(5),true);
	}
	
	@Test
	void test2() {
		assertEquals(n.add(12),true);
	}
	
	@Test
	void test3() {
		n.add(5);
		n.add(12);
		assertEquals(n.add(5),false);
	}
	
	//Test for delete(E key)
	@Test
	void test4() {
		n.add(5);
		n.add(12);
		assertEquals(n.delete(5),true);
	}
	
	@Test
	void test5() {
		n.add(5);
		n.add(12);
		assertEquals(n.delete(12),true);
	}
	
	@Test
	void test6() {
		n.add(5);
		n.add(12);
		assertEquals(n.delete(20),false);
	}
	
	
	//Tests for add(E key, int priority)
	@Test
	void test7() {
		n.add(5);
		n.add(12);
		assertEquals(n.add(10,20),true);
	}
	
	@Test
	void test8() {
		n.add(5);
		n.add(12);
		assertEquals(n.add(13,2),true);
	}
	
	@Test
	void test9() {
		n.add(5);
		n.add(12);
		n.add(13,2);
		assertEquals(n.add(13, 94),false);
	}
	
	//tests for find(E key)
	@Test
	void test10() {
		n.add(5);
		n.add(12);
		n.add(13,2);
		assertEquals(n.find(12),true);
	}
	
	@Test
	void test11() {
		n.add(5);
		n.add(12);
		n.add(13,2);
		assertEquals(n.find(100),false);
	}
	
	@Test
	void test12() {
		n.add(5);
		n.add(12);
		n.add(13,2);
		assertEquals(n.find(13),true);
	}

}
