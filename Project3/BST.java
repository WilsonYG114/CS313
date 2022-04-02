import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
public class BST {
	private node root;
	int length;
	public Student arr[] = new Student[20];
	int counter=-1;
	public BST() {
		root = null;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public void inserSort(Student x) {
		root = inserSort(x, root);
		length++;
	}

	private node inserSort(Student x, node t) {
		if (t != null) {
			if (x.compareToName(t.data) < 0) {
				t.left = inserSort(x, t.left);
			} else {
				t.right = inserSort(x, t.right);
			}
			return t;
		}
		return new node(x);
	}

	public int getBNodeLength() {
		return length;
	}

	public void InOrder() {
		InOrder(root);
	}

	public void InOrder(node t) {
		if (t != null) {
			InOrder(t.left);
			System.out.println(t.data);
			InOrder(t.right);
		}
	}

	public Student findMax() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty tree");
		}
		return findMax(root);
	}

	private Student findMax(node t) {
		if (t.right != null) {
			return findMax(t.right);
		}
		return t.data;
	}

	public void delete(Student x) throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty tree");
		}
		root = delete(x, root);
	}

	private node delete(Student x, node t) {
		if (t == null) {
			System.out.println("Not found.");
			return null;
		}
		if (x.compareToName(t.data) < 0) {
			t.left = delete(x, t.left);
		} else if (x.compareToName(t.data) > 0) {
			t.right = delete(x, t.right);
		} else {
			// These if statements handle the case where the BNode your deleting has no
			// children or 1 child.
			if (t.right == null) {
				return t.left;
			}
			if (t.left == null) {
				return t.right;
			}
			// This two lines code handle the case where the BNode your deleting has 2
			// children.
			t.data = findMax(t.left);
			t.left = delete(t.data, t.left);
		}
		return t;
	}
	
	
	
	public void saveSortArray() {
		saveSortArray(root);
	}
	
	private void saveSortArray(node t) {
		
		if(t != null) {
			saveSortArray(t.left);
			counter++;
			arr[counter] = t.data;
			saveSortArray(t.right);
		}
	}
	
	public void saveFinalRoster() {
		try {
			File file = new File("Roster.txt"); // Files object
			file.createNewFile();
			FileWriter fw = new FileWriter(file,false); // File writer
			PrintWriter pw = new PrintWriter(fw);
			
			
				// add roster to txt from array
				for(int i=0; i<arr.length;i++) {
					if(arr[i] == null) {
						pw.close();
					}
					pw.println(arr[i]);			
				}
				
				
				
			
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
	
	private Student searchByName(Student x, node t) {
		if (t == null) {
			System.out.println("Not found.");
			return null;
		}
		System.out.println(x.compareToName(t.data));
		if (x.compareToName(t.data) <0) {
			return searchByName(x, t.left);
		}
		if (x.compareToName(t.data) > 0) {
			return searchByName(x, t.right);
		}
		return t.data;

}
	
	public Student searchByName(Student x) throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty tree");
		}
		return searchByName(x, root);
	}

	
	
	public Student searchByID(Student x) throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty tree");
		}
		return searchByID(x, root);
	}
	
	private Student searchByID(Student x, node t) {
		if (t == null) {
			System.out.println("Not found.");
			return null;
		}
		
		if (x.compareToID(t.data) < 0) {
			return searchByID(x, t.right);
		}
		
		if (x.compareToID(t.data) > 0) {
			return searchByID(x, t.left);
		}
		
		return t.data;

}
	
	
	
	
}
