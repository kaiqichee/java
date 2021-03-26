package sa2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Kai Qi Chee
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

public class PhoneBook {
	// Data fields
	public Map<Character,BSFamilyTree> directory;

	/**
     	* Creates a new phone book with an empty directory.
     	*/
	public PhoneBook() {
		directory=new HashMap<Character,BSFamilyTree>();
		Character[] alph = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for(int i=0;i<alph.length;i++){
			directory.put(alph[i], new BSFamilyTree());
		}
	}

	/*
	 * Returns the instance of BSFamilyTree at the indicated letter
	 * Must accept lowercase letters as well as uppercase letters
	 */
	public BSFamilyTree getFamilyTree(char letter) {
		Character temp=Character.toUpperCase(letter);
		if(directory.containsKey(temp)==false) {
			throw new IllegalArgumentException("Not valid input.");
		}
		else {
		return directory.get(temp);
		}
	}

	/*
	 * Adds a FamilyTreeNode to the PhoneBook
	 */
	public void addFamily(String lastName) {
		Character t=Character.toUpperCase(lastName.charAt(0));
		BSFamilyTree temp=new BSFamilyTree();
		temp=directory.get(t);
		temp.addFamilyTreeNode(lastName);
		directory.replace(t,temp);
	}

	public boolean numCheck(String phoneNumber) {
		Character[] alph = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for (int i=0; i<alph.length; i++) {
			if(directory.get(alph[i]).doesNumberExist(phoneNumber)==true) {
				return true;
			}
		}
		return false;
		}
	
	        
	/*
	 * Adds a Person to the PhoneBook
	 * If a FamilyTreeNode with the given last name doesn't currently exist, create the FamilyTreeNode
	 */
	public void addPerson(String lastName, String firstName, String phoneNumber) {
		Character t=Character.toUpperCase(lastName.charAt(0));
		if(directory.get(t).doesFamilyExist(lastName)==false) {
			addFamily(lastName); 
		}
		else if(numCheck(phoneNumber)==true) {
			throw new IllegalArgumentException("This number already exists");
		}
		else if (directory.get(t).getFamilyTreeNode(lastName).doesFamilyMemberExist(lastName, firstName)==true) {
			throw new IllegalArgumentException("This person already exists");
		}
		Person temp=new Person(lastName,firstName,phoneNumber);
		directory.get(t).getFamilyTreeNode(lastName).addFamilyMember(temp);
	}

	/*
	 * Finds the phone number of a person
	 * Returns 'Does not exist.' if not found.
	 */
	public String getPhoneNumber(String lastName, String firstName) {
		return directory.get(lastName.charAt(0)).getFamilyTreeNode(lastName).getPhoneNumberOfFamilyMember(lastName, firstName);
	}


    /**
     	* String representation of PhoneBook
     	*/
	public String toString() {
		Character[] alph = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		StringBuilder s=new StringBuilder();
		for(int i=0;i<26;i++) {
			s.append(alph[i] + "\n");
			s.append(directory.get(alph[i]));
		}
		return s.toString();
	}
	
//	public static void main(String[] args) {
//		PhoneBook n=new PhoneBook();
//		n.addPerson("Anderson", "John", "1000000000");
//		n.addPerson("Anderson", "April", "1000000001");
//		n.addPerson("Aaron", "John", "1000000002");
//		n.addPerson("Aaron", "April", "1000000003");
//		n.addPerson("Anthony", "John", "1000000004");
//		n.addPerson("Anthony", "April", "1000000005");
//		
//		n.addPerson("Bart", "John", "1000000006");
//		n.addPerson("Bart", "April", "1000000007");
//		n.addPerson("Brady", "John", "1000000008");
//		n.addPerson("Brady", "April", "1000000009");
//		n.addPerson("Bob", "John", "1000000010");
//		n.addPerson("Bob", "April", "1000000011");
//		n.addPerson("Bunyan", "John", "1000000012");
//		n.addPerson("Bunyan", "April", "1000000013");
//		System.out.println(n.toString());
//		}
}

