
public class node {
	public Student data;
	public node next;

	// constructor
	public node() {
		data = null;
		next = null;
	}

	public node(Student data) {
		this.data = data;
		this.next = null;
	}

	public node(Student data, node next) {
		this.data = data;
		this.next = next;
	}

	public Student getData() {
		return this.data;
	}

	public node getNext() {
		return this.next;
	}

	public void setData(Student data) {
		this.data = data;
	}

	public void setNext(node next) {
		this.next = next;
	}

}
