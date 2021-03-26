package sa2;

import java.util.ArrayList;

/**
 * Kai Qi Chee
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

/**
 * BSFamilyTree creates a tree for specific families. 
 */
public class BSFamilyTree {
    //Data Fields
    private FamilyTreeNode root;

    /**
     * Constructor: constructs an empty BSFamilyTree
     */
    public BSFamilyTree() {
        this.root=null;
    }

    private boolean doesFamilyExistH(FamilyTreeNode root, String lastName) {
    	if (root==null) {
    		return false;} 
    	else {
    		int n = root.getLastName().compareTo(lastName);
    		if (n==0) {
    			return true;}
    		else{ 
    			if (n>0) {
    			return doesFamilyExistH(root.left,lastName);}
    			else {
    			return doesFamilyExistH(root.right,lastName);}
    	}
    	}}
    
      /**
     * Takes in the last name and returns true if there
     * is a FamilyTreeNode with the given last name.
     */
    public boolean doesFamilyExist(String lastName) {
        return doesFamilyExistH(root,lastName);
        

    }

    private FamilyTreeNode addFamilyTreeNodeH(FamilyTreeNode root, String lastName) {
    	if (root==null) {
    		return new FamilyTreeNode(lastName);} 
    	else {
    		int n = root.getLastName().compareTo(lastName);
    		if (n==0) {
    			throw new IllegalStateException("Last name already in BSFamilyTree");}
    		if (n>0) {
    			root.left=addFamilyTreeNodeH(root.left,lastName);
    			return root;}
    		if(n<0) {
    		    root.right=addFamilyTreeNodeH(root.right,lastName);}
    		    return root;}
    	}
    
    /**
     * Takes in a last name and creates a new instance of
     * FamilyTreeNode and adds it to the BSFamilyTree.
     */
    public void addFamilyTreeNode(String lastName) {
        root=addFamilyTreeNodeH(root,lastName);
    }

    private FamilyTreeNode getFamilyTreeNodeH(FamilyTreeNode root, String lastName) {
    	if (root==null) {
    		throw new IllegalStateException("Last name is not in tree.");} 
    	else {
    		int n=root.getLastName().compareTo(lastName);
    		if (n==0) {
    			return root;}
    		else{ if (n>0) {
    			return getFamilyTreeNodeH(root.left,lastName);}
    		else {
    			return getFamilyTreeNodeH(root.right,lastName);}
    		}
    	}}
    

    
    /**
     * Takes a last name and then finds that specific
     * family tree and then returns that FamilyTreeNode
     * If last name is not in tree, throws an exception.
     */
    public FamilyTreeNode getFamilyTreeNode(String lastName) {
        return getFamilyTreeNodeH(root,lastName);
    }

 
    private boolean doesNumberExistH(FamilyTreeNode root, String phoneNumber) {
    	if (root==null) {
    		return false;} 
    	else {
    		if (root.doesNumberExist(phoneNumber)==true) {
    			return true;}
    		else {
    			return doesNumberExistH(root.left,phoneNumber) ||
    					doesNumberExistH(root.right,phoneNumber);
    	}}}
    
    /**
     * Returns true if the input phone number exists in the BSFamilyTree
     * false otherwise.
     */
    public boolean doesNumberExist(String phoneNumber) {
        return doesNumberExistH(root,phoneNumber);
    }

    private StringBuilder toString(FamilyTreeNode root, int i) {
		StringBuilder n = new StringBuilder();
		for (int j=0; j<i; j++) {
			n.append(" ");}
		if (root==null) {
			n.append("null\n");} 
		else {
			n.append(root.toString()+"\n");
			n.append(toString(root.left,i+1));
			n.append(toString(root.right,i+1));}
		return n;}
    
    /**
     * Returns the string representation of the BSFamilyTree
     */
    public String toString() {
		return toString(root,0).toString();
		}
    
//    public static void main(String[] args) {
//    	BSFamilyTree n=new BSFamilyTree();
//    	n.addFamilyTreeNode("Smith");
//    	n.getFamilyTreeNode("Smith").addFamilyMember("Smith", "John", "1000000000");
//    	n.getFamilyTreeNode("Smith").addFamilyMember("Smith", "April", "1000000001");
//    	n.addFamilyTreeNode("Samuel");
//    	n.getFamilyTreeNode("Samuel").addFamilyMember("Samuel", "John", "1000000002");
//    	n.getFamilyTreeNode("Samuel").addFamilyMember("Samuel", "April", "1000000003");
//    	n.addFamilyTreeNode("Son");
//    	n.getFamilyTreeNode("Son").addFamilyMember("Son", "John", "1000000004");
//    	n.getFamilyTreeNode("Son").addFamilyMember("Son", "April", "1000000005");
//    	System.out.println(n.toString());
//    }
    
    
}

