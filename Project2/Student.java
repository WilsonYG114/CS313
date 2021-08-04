public class Student {

	private String firstName, lastName, IDNo;

	public Student(String first, String last, String ID) throws Exception {
		this.firstName = first;
		this.lastName = last;
		this.IDNo = ID;
		if (IDNo.length() != 7) {
			throw new Exception("Error ID length should be 7 digits");
		}
	}
	// constructor

	public Student(String first, String last) {
		// TODO Auto-generated constructor stub
		this.firstName = first;
		this.lastName = last;

	}

	public void setFirst(String first) {
		this.firstName = first;
	}

	public void setLast(String last) {
		this.lastName = last;
	}

	public void setID(String ID) {
		this.IDNo = ID;
	}

	// Accessors
	public void showFirst() {
		System.out.println(firstName);
	}

	public void showLast() {
		System.out.println(lastName);
	}

	public void showID() {
		System.out.println(IDNo);
	}

	public String getID() {
		return this.IDNo;
	}

	public boolean equals(Student a) {
		if (this.IDNo == a.IDNo) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		String studentInfo = firstName + " " + lastName + " " + IDNo;
		return studentInfo;
	}

	public int compareTo(Student a) {
		if (a.firstName.compareTo(this.firstName) != 0) {
			return a.firstName.compareTo(this.firstName);
		}

		if (a.lastName.compareTo(this.lastName) != 0) {
			return a.lastName.compareTo(this.lastName);
		}

		if (a.IDNo.compareTo(this.IDNo) != 0) {
			return a.IDNo.compareTo(this.IDNo);
		}
		return 0;

	}

	public int compareToSearch(Student a) {
		if (a.firstName.compareTo(this.firstName) != 0) {
			return a.firstName.compareTo(this.firstName);
		}

		if (a.lastName.compareTo(this.lastName) != 0) {
			return a.lastName.compareTo(this.lastName);
		}
		return 0;

	}

}
