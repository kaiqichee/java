package midterm284;

/**
 * Kai Qi Chee
 * section: A
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

public class ListMatrix extends ListCollection<Integer> {
	private int rows;
	private int columns;

	/**
	 * Initializes a `ListMatrix` with the specified number of rows and columns. By
	 * default, ALL elements are set to 0.
	 * 
	 * @param rows
	 * @param columns
	 */
	public ListMatrix(int rows, int columns) {
		setNodeCount(getNodeCount()+(rows*columns));
		this.rows=rows;
		this.columns=columns;
		for(int i=0;i<rows;i++) {
			SingleLL<Integer> m=new SingleLL<Integer>();
			this.addList(m);
			for(int j=0; j<columns; j++) {
				m.append(0);}
		}
	}

	/**
	 * @return the number of rows
	 */
	public int numRows() {
		return this.rows;
	}

	/**
	 * 
	 * @return the number of columns
	 */
	public int numColumns() {
		return this.columns;
	}

	/**
	 * Adds the `ListMatrix` to `ListMatrix other`, storing the result in the caller
	 * (this)
	 * 
	 * @throws IllegalArgumentException if dimensions do not properly coincide
	 * @param other
	 * @complexity Your big-o and supporting explanation here
	 * the big-o will be: O(n*m)
	 * explanation: There are 2 for-loops, the inner loop runs m=this.columns 
	 *              number of times and the outer loop runs n=this.rows number
	 *              of times. Because the loops are nested, the inner loop, 
	 *              which runs m number of times, is executed n number of times. 
	 *              Therefore, the total number of execution are n*m, 
	 *              which means that the Big-O will be O(n*m).
	 */
	public void add(ListMatrix other) {
		if (this.rows!=other.rows || this.columns!=other.columns){
			throw new IllegalArgumentException("Dimensions do not properly coincide");
		}
		else {
			for(int i=0;i<rows;i++){
				for(int j=0;j<columns;j++) {
					this.getList(i).set(j, this.getList(i).get(j)+other.getList(i).get(j));
				}
			}
		}

	}

	/**
	 * Returns the transpose of the matrix
	 * 
	 * @param matrix
	 * @return matrix transpose
	 */
	public static ListMatrix transpose(ListMatrix matrix) {
		ListMatrix n=new ListMatrix(matrix.columns,matrix.rows);
		for(int i=0;i<n.columns;i++) {
			for(int j=0;j<n.rows;j++) {
				n.setElem(j, i, matrix.getElem(i, j));
			}
		}
		return n;
	}

	/**
	 * Multiplies the `ListMatrix` with `ListMatrix other`, returning the result as
	 * a new `ListMatrix.
	 * 
	 * @throws IllegalArgumentException if dimensions do not properly coincide
	 * @param other
	 * @return
	 */
	public ListMatrix multiply(ListMatrix other) {
		if (this.columns!=other.rows){
			throw new IllegalArgumentException("Dimensions do not properly coincide");
		}
		ListMatrix n=new ListMatrix(this.rows,other.columns);
		int temp=0;
		for(int i=0;i<this.rows;i++) {
			for(int z=0;z<n.rows;z++) {
				temp=0;
				for(int j=0;j<this.columns;j++) {
					temp=temp+(this.getElem(i,j)*other.getElem(j,z));
					n.setElem(i, z, temp);
					}
				}
			}
		return n;
		}



//	public static void main(String[] args) {	
//		ListMatrix n1= new ListMatrix(2,3);
//		n1.setElem(0, 0, 1);
//		n1.setElem(0, 1, 2);
//		n1.setElem(0, 2, 3);
//		
//		n1.setElem(1, 0, 4);
//		n1.setElem(1, 1, 5);
//		n1.setElem(1, 2, 6);
//		
//		ListMatrix n2= new ListMatrix(3,2);
//		n2.setElem(0, 0, 6);
//		n2.setElem(0, 1, 3);
//		n2.setElem(1, 0, 5);
//		n2.setElem(1, 1, 2);
//		n2.setElem(2, 0, 4);
//		n2.setElem(2, 1, 1);
//		
//		System.out.println(n1);
//		
//
//
//	}

}
