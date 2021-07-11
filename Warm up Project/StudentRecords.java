import java.util.*;

public class StudentRecords extends Student {
	private ArrayList<String> courses = new ArrayList<>();
	StringBuilder courseToString = new StringBuilder();
	// constructor
	public StudentRecords(String first, String last, String ID) throws Exception {
		super(first, last, ID);
		// TODO Auto-generated constructor stub
		
	}
	//setter
	public void addCourse(String course) {
		this.courses.add(course);
	}
	
	//Getter
	public ArrayList<String> getCourse() {
		return courses;
	}
	
	public String toString() {
		String studentInfo = super.toString() + courses;
		return studentInfo;
	}
	
}