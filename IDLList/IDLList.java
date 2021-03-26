package cs284;

import java.util.ArrayList;

public class IDLList<E> {
	public static class Node<E> {
		//data fields
		E data; 
		Node<E> next;
		Node<E> prev;
		
		//constructors
		Node(E elem) {
			this.data=elem;
			this.next=null;
			this.prev=null;
		}
		
		Node(E elem, Node<E> prev,  Node<E> next) {
			this.data=elem;
			this.prev=prev;
			this.next=next;
		}
	}
	
	//data fields
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;
	

	//constructor
	public IDLList() { 
		head=null;
		tail=null;
		size=0;
		indices= new ArrayList<Node<E>>();
		}
	
	
	//methods
	
	//adds elem at index, throws error if index>size or index<0
	public boolean add (int index, E elem) {
		Node<E> current=head;
		Node<E> h=new Node<E>(elem);

		if (index>size ||index<0) {
			throw new IllegalArgumentException("index out of range");
		}
		if(index==0 && size==0) {
			head=new Node<E> (elem);
			tail=head;
			size++;
			indices.add(index,h);
			return true;
		}
		if(index==0) {
			Node<E> n=new Node<E>(elem);
			n.next=head;
			head.prev=n;
			head=n;
			size++;
			indices.add(index,n);
			return true;
		}
		if (index==size ) {
			tail.next=h;
			h.prev=tail;
			size++;
			indices.add(index,h);
			return true;	
		}
		for(int i=0; i<=index; i++) {
			if(i==index) {
			h.next=current;
			h.prev=current.prev;
			current.prev=h;
			h.prev.next=h;}
			current=current.next;
			}
		size++;
		indices.add(index,h);
		return true;
	}
	
	//adds elem at beginning/head of list, updates indices
	public boolean add (E elem) {
		Node<E> n=new Node<E>(elem);
		if(size==0) {
		head=n; 
		tail=head;}
		else {
			n.next=head;
			head.prev=n;
			head=n;
		}
		size++;
		indices.add(0,n);
		return true;
	}
	
	//appends elem at the end/tail of the list, updates indices
	public boolean append (E elem) {
		if(size==0) {
			head=new Node<E>(elem);
			tail=head;
		}
		else if (size==1) {
			head.next=new Node<E>(elem, head, null);
		}
		else {
			Node<E> p =new Node<E>(elem, tail, null);
			tail.next=p;
			tail=p;
			indices.add(p);
		}
		size++;
		return true; 
	}
	
	//gets data at index of list, uses fast index of indices
	public E get(int index) {
		if (size==0) {
			throw new IllegalStateException("List is empty");
		}
		if(index>=size || index<0) {
			throw new IllegalStateException("index out of range");
		}
		return indices.get(index).data;
	}
	
	//returns data of head, throws error if list is empty
	public E getHead () {
		if (size==0) {
			throw new IllegalStateException("List is empty");
		}
		return this.head.data;
	}
	
	//returns data of tail, throws data if list is empty
	public E getLast () {
		if (size==0) {
			throw new IllegalStateException("List is empty");
		}
		return this.tail.data;
	}
	
	//returns size
	public int size() {
		return this.size;
	}
	
	//removes and returns the elements at head, throws exception if there is no such element
	public E remove() {
		if (head==null) {
			throw new IllegalStateException("no element at head");
		}
		else {
			Node<E> temp = new Node<E>(head.data);
			head=head.next;
			size--;
			indices.remove(0);
			return temp.data;
		}
	}
	
	//removes and returns the element at tail, throws exception if there is no such element
	public E removeLast () {
		if (head==null) {
			throw new IllegalStateException("no element at tail");
		}
		Node<E> temp = new Node<E>(tail.data);
		tail.prev.next=null; 
		indices.remove(size-1);
		return temp.data;
	}
	
	//removes and returns the element at index, updates indices
	public E removeAt (int index) {
		if (size==0) {
			throw new IllegalStateException("List is empty");
		}
		if (index>=size || index<0) {
			throw new IllegalStateException("Index out of range");
		}
		if(index==size-1) {
			tail.prev.next=null;
			tail=tail.prev;
			size--;
			E temp=indices.get(index).data;
			indices.remove(index);
			return temp; 
		}
		if(index==0) {
			head.next.prev=null;
			head=head.next;
			size--;
			E temp=indices.get(index).data;
			indices.remove(index);
			return temp; 
		}
		Node<E> current=head;
		int counter=0;
		
		while (current != null) {
			if (counter==index) {
				current.prev.next=current.next;
				current.next.prev=current.prev;
				break;
			}
			counter++;
			current=current.next;
		}
		size--;
		E temp=indices.get(index).data;
		indices.remove(index);
		return temp; 
	}
	
	 public boolean remove (E elem) {
		 Node<E> current=head;
		 if (head==null) {
			 throw new IllegalStateException("List is empty");
		 }
		 for(int i=0; i<size;i++) {
			 if(indices.get(i).data != elem && i==size-1) {
				 return false;
			 }
			 if(indices.get(i).data==elem) {
			 indices.remove(i);
			 break;
			 }
		 }	
		 if(tail.data==elem) {
			 tail.prev.next=null;
			 tail=tail.prev;
			 size--;
			 return true;
		 }
		 if(head.data==elem) {
			 System.out.println("wot");
			 head.next.prev=null;
			 head=head.next;
			 size--;
			 return true;
		 }
		 while (current != null){
			 if (current.data == elem) {
				 current.prev.next=current.next;
				 current.next.prev=current.prev;
			 }
			 current=current.next;
		 }
		 size--;
		 return true;
	 }
	 
	 public String toString() {
		 StringBuilder s= new StringBuilder();
		 Node<E> current=head;
		 s.append("[");
		 while (current !=null) {
			 s.append(current.data.toString() + ",");
			 current=current.next;
		 }
		 s.append("]");
		 return s.toString();
	 }
	 
//	 public static void main(String[] args) {
//		IDLList<Integer> t = new IDLList<>();
//		t.add(3);
//		t.add(2);
//		t.add(1);
//		System.out.println(t.toString());
//	 }

}
