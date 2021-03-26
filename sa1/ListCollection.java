package midterm284;

import java.util.ArrayList;
import java.util.List;

/**
 * Kai Qi Chee
 * section: A
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

public class ListCollection<E> {
	private int nodeCount;
	protected List<SingleLL<E>> collection;
	
	/**
	 * Base constructor, initializes an empty ListCollection.
	 */
	public ListCollection() {
		nodeCount=0;
		collection=new ArrayList<SingleLL<E>>(); 
	}

	/**
	 * Initializes a ListCollection with `numLists` lists.
	 * 
	 * @param numLists
	 */
	public ListCollection(int numLists) {
		nodeCount=numLists;
		SingleLL<E> n=new SingleLL<E>();
		collection=new ArrayList<SingleLL<E>>(numLists); 
		for (int i=0; i<numLists; i++) {
			collection.add(i,n);
		}
	}

	/**
	 * @return The size of the `ListCollection`
	 */
	public int size() {
		return collection.size();
	}

	/**
	 * Sets the nodeCount
	 * 
	 * @param nodeCount
	 */
	public void setNodeCount(int nodeCount) {
		this.nodeCount=nodeCount;
	}

	/**
	 * @return the nodeCount
	 */
	public int getNodeCount() {
		return nodeCount;
	}

	/**
	 * Adds the specified `SingleLL` to the end of the `ListCollection`
	 * 
	 * @param list
	 */
	public void addList(SingleLL<E> list) {
		nodeCount=nodeCount+list.size();
		collection.add(collection.size(),list);

	}

	/**
	 * Adds the specified `List` to the `ListCollection`
	 * 
	 * @param list
	 * @complexity Your big-o and supporting explanation here
	 * the big-o will be: O(n)
	 * explanation: The for-loop in the method will run n=list.size() times.
	 *              every time the for-loop runs the append method is implemented 
	 *              when i<list.size(). This shows that the append method is run 
	 *              n number of times, therefore the big-o is O(n).
	 */
	public void addList(List<E> list) {
		SingleLL<E> l=new SingleLL<E>();
		for(int i=0; i<list.size();i++) {
			l.append(list.get(i));
		}
		this.addList(l);
	}

	/**
	 * Returns the list at the specified index
	 *	 
	 * @throws IllegalArgumentException when index out of bounds
	 * @param listIndex
	 * @return the list
	 */
	public SingleLL<E> getList(int listIndex) {
		if(listIndex<0||listIndex>=this.size()) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		return collection.get(listIndex);

	}

	/**
	 * Adds an element to the `elemIndex` position of the list at `listIndex`
	 * 
	 * @throws IllegalArgumentException when index out of bounds
	 * @param listIndex
	 * @param elemIndex
	 * @param elem
	 * @complexity Your big-o and supporting explanation here
	 * the big-o will be: O(1)
	 * explanation: Every time addElem(int, int, E) is called, regardless of whether 
	 *              any 'if statements' are met, there is either an error thrown or
	 *              an element added. If an error is thrown, only 1 argument is executed,
	 *              this argument throws an error; if an element is inserted or appended, 
	 *              the methods getList(int) and insert(int, E) or append(E) will each be 
	 *              called once, both these methods have a constant time operation, therefore, 
	 *              addElem(int, int, E) will also have a constant time operation or O(1).
	 */
	public void addElem(int listIndex, int elemIndex, E elem) {
		if(listIndex<0 || listIndex>=this.size()) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		if(elemIndex<0 || elemIndex>this.getList(listIndex).size()) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		if(elemIndex==this.getList(listIndex).size()) {
			this.getList(listIndex).append(elem);
			nodeCount=nodeCount+1;
		}
		else {
			this.getList(listIndex).insert(elemIndex,elem);
			nodeCount=nodeCount+1;
		}

	}

	/**
	 * Sets the element at the `elemIndex` position of the list at `listIndex`
	 * 
	 * @throws IllegalArgumentException when index out of bounds
	 * @param listIndex
	 * @param elemIndex
	 * @param elem
	 */
	public void setElem(int listIndex, int elemIndex, E elem) {
		if(listIndex<0 || listIndex>=this.size()) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		if(elemIndex<0 || elemIndex>=this.getList(listIndex).size()) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		else {
		this.getList(listIndex).set(elemIndex,elem);
		}
	}

	/**
	 * Returns the element at the `elemIndex` position of the list at `listIndex`
	 * 
	 * @throws IllegalArgumentException when index out of bounds
	 * @param listIndex
	 * @param elemIndex
	 * @return
	 */
	public E getElem(int listIndex, int elemIndex) {
		if(listIndex<0 || listIndex>=this.size()) {
			throw new IllegalArgumentException("Index out of bounds"); 
		}
		if(elemIndex<0 || elemIndex>=this.getList(listIndex).size()){
			throw new IllegalArgumentException("Index out of bounds");
		}
		else {
		return this.getList(listIndex).get(elemIndex);
		}
	}

	/**
	 * Returns the `ListCollection` in string form, following STRICTLY the rule of
	 * "[LIST1, LIST2, LIST3, ... ]" Ex: [[0, 1, 2], [3, 4, 5] [6, 7, 8]]
	 */
	public String toString() {
		 StringBuilder s= new StringBuilder();
		 if(this.size()==0) {
			 s.append("[]");
			 return s.toString();
		 }
		 else {
		 s.append("[");
		 s.append(this.getList(0));
		 for(int i=1; i<this.size();i++){
			 s.append("," + this.getList(i));
		 }
		 s.append("]");
		 return s.toString();
		 }
	}
	
//	public static void main(String[] args) {
//		ListCollection<Integer> n = new ListCollection<Integer>();
//		
//		SingleLL<Integer> p= new SingleLL<Integer>();
//		p.append(19);
//		n.addList(p);
//		
//		SingleLL<Integer> q= new SingleLL<Integer>();
//		q.append(20);
//		q.append(21);
//		q.append(22);
//		n.addList(q);
//		
//		SingleLL<Integer> t= new SingleLL<Integer>();
//		t.append(49);
//		t.append(50);
//		n.addList(t);
//
//		ArrayList<Integer> k=new ArrayList<Integer>();
//		k.add(0, 50);
//		k.add(0, 49);
//		n.addList(k);
//		
//		System.out.println(n.toString());
//
//
//	}
	

}

