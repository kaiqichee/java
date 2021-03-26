package treaps;

import java.util.Random;
import java.util.Stack;
/**
 * I pledge my honor that I have abided by the Stevens Honor System.
 * @author kaiqi_iwda0g1
 *
 * @param <E>
 */
public class Treap<E extends Comparable<E>> { 
	private static class Node<E>{
		//Data Fields
		public E data;
		public int priority; 
		public Node<E> left;
		public Node<E> right;
		
		//Constructor
		/**
		 * creates a node with given data and priority,
		 * left and right child are null.
		 * @param data
		 * @param priority
		 */
		public Node(E data, int priority) {
			if(data==null) {
				throw new IllegalArgumentException("Data cannot be null");
			}
			this.data=data;
			this.priority=priority;
			this.left=null;
			this.right=null;
		}
			
		//Methods
		/**
		 * Rotates a treap right by reassigning left and right children
		 * @return temp2 The new root of the treap
		 */
		Node<E> rotateRight(){ 
			Node<E> temp=this;
			Node<E> temp2=this.left;
			temp.left=temp2.right;
			temp2.right=temp;
			return temp2;
			
		}
		/**
		 * Rotates a treap left by reassigning left and right children
		 * @return temp2 The new root of the rotated treap
		 */
		Node<E> rotateLeft(){ 
			Node<E> temp=this;
			Node<E> temp2=this.right;
			temp.right=temp2.left;
			temp2.left=temp;
			return temp2;
		}
		/**
		 * Turns a Node into a string represented by the pair (key, priority).
		 */
		public String toString() {
			StringBuilder n=new StringBuilder();
			n.append("("+"key="+this.data+","+"priority="+this.priority+")");
			return n.toString();
		}
	}
	//Data Fields
	private Random priorityGenerator;
	private Node<E> root; 
	
	//Constructor
	/**
	 * Creates a treap with random priority and null root.
	 */
	public Treap() {
		priorityGenerator=new Random();
		root=null;
	}
	
	/**
	 * Creates a treap with random priority limited by seed and null root.
	 * @param seed
	 */
	public Treap(long seed) {
		priorityGenerator=new Random(seed);
		root=null;
	}
	
	//Methods
	/**
	 * Adds node with given key and random priority to treap while maintaining
	 * heap priorities.
	 * @param key
	 * @return boolean True if added, False if already exists in treap
	 */
	boolean add(E key) {
		return add(key,priorityGenerator.nextInt(200)); //do I need a limit?
		}
	
	/**
	 * Adds Node<E> current with given key and priority to the
	 * treap then "reheaps" the treap to maintain heap priorities.
	 * @param current Root of the tree
	 * @param key Key of the new node
	 * @param priority Priority of the new node
	 * @return Node<E> The new node with given key and priority
	 */
	Node<E> addH(Node<E> current,E key, int priority) {
		Stack<Node<E>> n=new Stack<Node<E>>();
		if(current==null) {
			return new Node<E>(key, priority);
		}
		while(current!=null) {
		int num=current.data.compareTo(key);
		n.push(current);
		if (num==0) {
			throw new IllegalArgumentException("Item already in tree");
		}
		if(num>0) {
			if(current.left==null) {
				current.left=new Node<E>(key, priority);
				reheap(n);
				return root;
			}
			current=current.left;
		}
		if(num<0) {
			if(current.right==null) {
				current.right=new Node<E>(key, priority);
				reheap(n);
				return root;
				}
			current=current.right;
			}
		}
		reheap(n);
		return root;
	}
	
	/**
	 * Modifies the treap by rotating it to maintain heap priorities.
	 * @param s A stack of nodes to be reheaped
	 */
	void reheap(Stack<Node<E>> s) {
		while(s.size()>0) {
			Node<E> temp=s.pop();
			if(temp.right!=null && temp.left!=null) {
				if(temp.priority<temp.right.priority) {
					root=temp.rotateLeft();
				}
				else if(temp.priority<temp.left.priority) {
					root=temp.rotateRight();
				}
				else {
				root=temp;}
			}
			else if(temp.right!=null && temp.left==null) {
				if(temp.priority<temp.right.priority) {
					root=temp.rotateLeft();
				}
				else {
				root=temp;}
			}
			else if(temp.right==null && temp.left!=null) {
				if(temp.priority<temp.left.priority) {
					root=temp.rotateRight();
				}else {
				root=temp;}
			}
			if(s.size()>0) {
				Node<E> parent=s.peek();
				int y=parent.data.compareTo(temp.data);
				if(y>0) {
					parent.left=root;
				}
				if(y<0) {
					parent.right=root;
				}
			}
			}
		}
		
	/**
	 * Adds node with given key and priority to treap while maintaining heap priorities.
	 * @param key Given key of node to add
	 * @param priority Given priority of node to add
	 * @return boolean Returns true if added to treap and false if already exists
	 */
	boolean add(E key, int priority) {
		if (this.find(key)==true) {
			return false;
		}
		else {
		root=addH(this.root, key, priority);
		return true;
		}
	}
	
	/**
	 * Finds a node with the given key in the treap rooted at root 
	 * and rotates the node downwards until it is a leaf.
	 * Returns null to remove the leaf.
	 * @param current Root of treap
	 * @param key Given key of node to delete
	 * @return Node<E> returns either null to delete node or left or right
	 */
	Node<E> deleteH(Node<E> current, E key) {
		if (current==null) {
			throw new IllegalArgumentException("Item not in tree");
		}
		else {
			int num=key.compareTo(current.data);
			if (num<0) {
				current.left=deleteH(current.left,key);
			}
			if(num>0) {
				current.right=deleteH(current.right,key);
			}
			if(num==0) {
				if(current.left==null && current.right==null) {
					return null;
				}
				if(current.left==null && current.right!=null) {
					return current.right;
				}
				if(current.left!=null && current.right==null) {
					return current.left;
				}
				if(current.right.priority<current.left.priority) {
					return deleteH(current.rotateRight(), key);
				}
				if(current.left.priority<current.right.priority) {
					return deleteH(current.rotateLeft(),key);
				}
			}
			return current;
		}
	}
	
	/**
	 * Deletes the node with the given key from the treap and returns true. 
	 * If the key was not found, the method does not modify the treap and returns false.
	 * @param key Given key of node to delete
	 * @return boolean Returns true if deleted, false if not in treap
	 */
	boolean delete(E key) {
		if (this.find(key)==false) {
			return false;
		}
		root=deleteH(this.root,key);
		return true;
	}
	
	/**
	 * Finds a node with the given key in the treap rooted at root and 
	 * returns true if it finds it and false otherwise.
	 * @param current Root of tree
	 * @param key Given key of node to find
	 * @return boolean Returns false if not in treap, true if in treap
	 */
	private boolean find(Node<E> current, E key) {
		if (current==null) {
			return false;
		}
		else {
			int n=key.compareTo(current.data);
			if (n==0) {
				return true;}
			if(n<0) {
				return find(current.left,key);
			}
			if(n>0) {
				return find(current.right,key);
			}
		}
		return true;
	}
	
	/**
	 * Finds a node with the given key in the treap and returns true if it finds it and false otherwise.
	 * @param key Given key of node to find
	 * @return boolean Returns true if found, false if not
	 */
	public boolean find(E key) {
		return find(this.root, key);
	}
	
	/**
	 * Carries out a pre-order traversal of the tree and returns a representation of the nodes as a string.
	 * @param current Root of treap
	 * @param i Acts as a count for " " representation of levels
	 * @return StringBuilder A string representation of the treap
	 */
	private StringBuilder toString(Node<E> current, int i) {
		StringBuilder n = new StringBuilder();
		for (int j=0; j<i; j++) {
			n.append(" ");}
		if (current==null) {
			n.append("null\n");} 
		else {
			n.append(current.toString()+"\n");
			n.append(toString(current.left,i+1));
			n.append(toString(current.right,i+1));}
		return n;}
	
	/**
	 * Creates a String representation of the nodes in a treap.
	 * @return the string representation of a treap
	 */
	public String toString() {
		return toString(root,0).toString();}

//	public static void main(String[] args) {
//		Treap<Integer>testTree = new Treap<Integer>();
//		testTree.add (4 ,19);
//		testTree.add (2 ,31);
//		testTree.add (6 ,70);
//		testTree.add (1 ,84);
//		testTree.add (3 ,12);
//		testTree.add (5 ,83);
//		testTree.add (7 ,26);
//
//		System.out.println(testTree.toString());
//
//
//	}
}

