import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class LinkedList {
	private node headptr;
	node curr = new node();
	node prev = new node();
	public Student arr[];
	public Student arr1[];
	int size = 10;

	// dummy node
	public LinkedList() {
		headptr = new node();
		curr = headptr;
	}

	public boolean isEmpty() {
		return headptr.next == null;
	}

	public void append(Student a) {
		node x = new node(a);
		if (headptr.next == null) {
			prev = headptr;
			headptr.next = x;
			curr = x; // refference to node X
		} else {
			curr.next = x;
			curr = x;
		}
	}

	public Student searchID(String ID) throws Exception {
		if (ID.length() != 7) {
			throw new Exception("Error ID should be 7 digits");
		}
		node search = headptr.next;

		while (search != null) {
			if (search.data.getID().equalsIgnoreCase(ID)) {
				return search.data;
			}
			search = search.next;
		}
		return null;
	}

	public Student searchName(String first, String last) throws Exception {
		if (first.length() == 0) {
			throw new Exception("Error fist name should not be empty");
		}
		if (last.length() == 0) {
			throw new Exception("Error last name should not be empty");
		}
		Student temp = new Student(first, last);
		node searchUser = headptr.next;
		while (searchUser != null) {
			if (searchUser.data.compareToSearch(temp) == 0) {
				return searchUser.data;
			}
			searchUser = searchUser.next;
		}

		return null;
	}

	public void save() {
		// Student size max 10
		arr = new Student[size];
		int counter = 0;
		node y = headptr.next;
		while (y != null) {
			arr[counter] = y.data;
			y = y.next;
			counter++;
		}
	}

	public void saveFile() {
		try {
			File file = new File("Roster.txt"); // Files object
			FileWriter fw = new FileWriter(file); // File writer
			PrintWriter pw = new PrintWriter(fw);

			String student = "";
			node n = headptr.next;
			while (n != null) {
				pw.println(n.data);
				n = n.next;
			}
			pw.close();
		} catch (IOException e) {
			System.out.println("Error");
		}

	}

	public void printArray() throws Exception {
		arr = new Student[size];
		int counter = 0;
		node y = headptr.next;
		while (y != null) {
			arr[counter] = y.data;
			y = y.next;
			counter++;
		}
		if (arr[0] == null) {
			throw new Exception("Roster not saved saved rost first or array is empty");
		}

		for (int j = 0; j < size; j++) {
			System.out.println(arr[j]);
		}
	}

	// delete student from linkedlist
	public void linkListDelete(Student input) throws Exception {

		try {
			if (headptr.next.data == input) { // check if first node is empty
				headptr.next = headptr.next.next;
			} else {
				node trav1 = headptr; // use another node to point to previous node
				while (trav1 != null) { // basic list traversal
					node trav2 = trav1.next; // current node
					if (trav2.data == input) { // if we locate the node with user input we will shift next pointer to
												// next
												// next node and complete the deletion
						trav1.next = trav1.next.next;
						break;
					}
					trav1 = trav1.next; // continue to next node
				}
			}
		} catch (Exception e) {
			System.out.println("User not found");
		}

	}

	public void inserSort(Student s) {
		node curr = headptr.next;
		node prev = headptr;
		int length = -1;
		while (curr != null && curr.data.compareTo(s) < 0) {
			prev = curr;
			curr = curr.next;
		}
		if (curr == null) {
			prev.next = new node();
		}
		prev.next = new node(s, curr);

		node y = headptr;
		while (y != null) {
			length++;
			y = y.next;
			if (length == 10) {
				// System.out.println("Roster is full do not add anymore student");
			}
		}

	}
	
	

	public String toString() {
		String student = "";
		node n = headptr.next;
		while (n != null) {
			student += (n.data);
			student += ("\n");
			n = n.next;
		}
		return student;
	}
	
	
}
