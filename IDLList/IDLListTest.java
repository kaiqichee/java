package cs284;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IDLListTest {
	IDLList<Integer> t = new IDLList<>();

	//tests for add(E elem)
	@Test
	public void test1() {
		assertEquals(t.add(4), true);
	}
	
	@Test
	public void test2() {
		assertEquals(t.add(2), true);
	}
	
	
	@Test
	public void test3() {
		assertEquals(t.add(1), true);
	}
	
	//tests for add(int index, E elem)
	@Test
	public void test4() {
		t.add(4);
		t.add(2);
		t.add(1);
		assertEquals(t.add(2,3), true);
	}
	
	@Test
	public void test5() {
		t.add(3);
		t.add(2);
		t.add(1);
		assertEquals(t.add(0,0), true);
	}
	
	@Test
	public void test6() {
		t.add(3);
		t.add(2);
		t.add(1);
		assertEquals(t.add(3,4), true);
	}
	
	//tests for append(E elem)
	@Test
	public void test7() {
		assertEquals(t.append(1), true);
	}
	
	@Test
	public void test8() {
		t.append(1);
		assertEquals(t.append(2), true);
	}
	
	//tests for get(int index)
	@Test
	public void test9(){
		for(int i=7; i>=0; i--) {
			t.add(i);
		}
		assertEquals(t.get(2), 2);
	}
	
	//tests for getHead(int index)
	@Test
	public void test10() {
		for(int i=7; i>=0; i--) {
			t.add(i);}
		assertEquals(t.getHead(), 0);
	}
		
	//tests for getHead(int index)
	@Test
	public void test11() {
		for(int i=7; i>=0; i--) {
			t.add(i);}
			assertEquals(t.getLast(), 7);
		}
		
	
	//tests for size()
	@Test
	public void test12() {
		for(int i=7; i>=0; i--) {
			t.add(i);}
			assertEquals(t.size(), 8);
	}
	
	@Test
	public void test13() {
		t.add(1);
		t.add(2);
		t.add(3);
		t.remove();
		assertEquals(t.size(), 2);
	}

	@Test
	public void test14() {
		assertEquals(t.size(), 0);
	}
	
	//tests for remove()
	@Test
	public void test15() {
		for(int i=7; i>=0; i--) {
			t.add(i);}
			assertEquals(t.remove(), 0);
		}
	
	
	//tests for removeLast()
	@Test
	public void test16() {
		for(int i=7; i>=0; i--) {
			t.add(i);}
			assertEquals(t.removeLast(), 7);
		}
	
		
	//tests for removeAt(int index)
	@Test
	public void test17() {
		for(int i=7; i>=0; i--) {
			t.add(i);}
		assertEquals(t.removeAt(3), 3);
			}
	
		
	//tests for remove(E elem)
	@Test
	public void test18() {
		for(int i=7; i>=0; i--) {
			t.add(i);}
		assertEquals(t.remove(3), true);
					}
				
	@Test
	public void test19() {
		t.add(0);
		t.add(1);
		assertEquals(t.remove(7), false);
	}
			
	
	//tests for toString()
	@Test
	public void test20() {
		for(int i=7; i>=0; i--) {
			t.add(i);}
		assertEquals(t.toString(), "[0,1,2,3,4,5,6,7,]");
					}
				
	@Test
	public void test21() {
		t.add(0);
		t.add(1);
		assertEquals(t.toString(), "[1,0,]");
	}
	
	@Test
	public void test22() {
		assertEquals(t.toString(), "[]");
	}
		
}

		
		
		
		
		
		
		
		
		