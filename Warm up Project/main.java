import java.util.*;
public class main {

	//CS313 Section23
	//Weixin Yang
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Student S1 = new Student("Mary","Doe","D122223");
		Student S2 = new Student("John", "Smith", "S133334");
		Student S3 = new Student("John","Smith","S135554");
		Student S4 = new Student("ss", "Smith", "S143333");
		System.out.println(S1);
		System.out.println(S2);
		System.out.println(S3);
		System.out.println(S4);
		System.out.println(S1.compareTo(S2));
		System.out.println(S2.compareTo(S3));
		System.out.println(S3.compareTo(S4));
		System.out.println(S1.equals(S2));
		System.out.println(S2.equals(S3));
		System.out.println(S3.equals(S4));
		
		StudentRecords sR1 = new StudentRecords("Mary","Doe","D122223");
		sR1.addCourse("CS121");
		sR1.addCourse("CS111");
		sR1.addCourse("CS123");
		System.out.println(sR1);
		System.out.println(sR1.getCourse());
	}

}
