package sa2;

import java.util.ArrayList;
import java.util.List;

/**
 * Kai Qi Chee
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

public class FamilyTreeNode {
	// Data fields
	private String lastName;
	private List<Person> members;
	public FamilyTreeNode left;
	public FamilyTreeNode right;

	/**
     	* Constructor: instantiates a new FamilyTreeNode
     	* given a lastName
     	*/
	public FamilyTreeNode(String lastName) {
        	this.lastName=lastName;
        	this.left=null; 
        	this.right=null;
        	this.members=new ArrayList<Person>();
	}

	/**
     	* Returns the last name of the FamilyTreeNode
     	*/
	public String getLastName() {
		return this.lastName;
	}

	/**
     	* Returns the arraylist of members in the FamilyTreeNode
     	*/
	public List<Person> getMembers() {
		return this.members;
	}

	/*
	 * Returns true if there is an instance of Person in the FamilyTreeNode that has
	 * the same first and last name provided Return false otherwise
	 */
	public boolean doesFamilyMemberExist(String lastName, String firstName) {
		for(int i=0;i<members.size();i++) {
			Person temp=members.get(i);
			if(temp.getFirstName()==firstName && temp.getLastName()==lastName) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if there is an instance of Person in the FamilyTreeNode whose
	 * phone number matches the one provided Returns false otherwise
	 */
	public boolean doesNumberExist(String phoneNumber) {
		for(int i=0;i<members.size();i++) {
			Person temp=members.get(i);
			if(temp.getPhoneNumber()==phoneNumber) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Adds a Person to this FamilyTreeNode
	 * Throw an exception if the last name provided does not match the last name of the FamilyTreeNode
	 */
	public void addFamilyMember(String lastName, String firstName, String phoneNumber) {
		if(lastName!=this.lastName) {
			throw new IllegalArgumentException("Last names are not the same!");
		}
		else if(doesFamilyMemberExist(lastName,firstName)==true) {
			throw new IllegalArgumentException("This person already exists");
		}
		else if(doesNumberExist(phoneNumber)==true) {
			throw new IllegalArgumentException("This number already exists");
		}
		else {
		Person temp=new Person(lastName,firstName,phoneNumber);
		members.add(temp);}
	}

	/**
	 * Adds a Person to this FamilyTreeNode
	 * Throw an exception if the last name provided does not match the last name of the FamilyTreeNode
	 */
	public void addFamilyMember(Person person) {
		addFamilyMember(person.getLastName(),person.getFirstName(),person.getPhoneNumber());
	}

	/*
	 * Returns the phone number of the person in the family with the given phone
	 * number Returns "Does not exist." if not found
	 */
	public String getPhoneNumberOfFamilyMember(String lastName, String firstName) {
		for(int i=0;i<members.size();i++) {
			Person temp=members.get(i);
			if(temp.getFirstName()==firstName && temp.getLastName()==lastName) {
				return temp.getPhoneNumber();
			}
		}
		return "Does not exist.";
	}
	

	/*
	 * toString method Ex: [] [John Smith (5551234567), May Smith (5551234568),
	 * April Smith (5551234569), August Smith (5551234570)]
	 */
	public String toString() {
		if(members.size()==0) {
			return "[]";
		}
		else {
		StringBuilder s=new StringBuilder();
		s.append("[");
		s.append(members.get(0));
		for(int i=1;i<members.size();i++) {
			s.append(", ");
			s.append(members.get(i));
		}
		s.append("]");
		return s.toString();
		}
	}
	
//	public static void main(String[] args) {
//		FamilyTreeNode a=new FamilyTreeNode("Smith");
//		
//		a.addFamilyMember("Smith", "John", "5551234567");
//		a.addFamilyMember("Smith", "April", "5551234569");
//		a.addFamilyMember("Smith", "May", "5551234568");		
//		Person n=new Person("Smith", "June", "5551234570");
//		a.addFamilyMember(n);
//		System.out.println(a.toString());
//	}
//	
}

