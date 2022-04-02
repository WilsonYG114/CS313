
public class node {
	private node root;
	public Student data;
	public node left;
	public node right;
	
	// constructor
	public node() {
		root = null; // creating empty tree
		data = null;
		left = null;
		right = null;
	}
	
	public node(Student data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	
	
	
}
