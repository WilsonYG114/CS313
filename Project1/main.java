import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class main {

	// CS313 Section23
	// Weixin Yang
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList Student = new LinkedList();
		
		Scanner sc = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		System.out.println("Roster Menu------ Maxium legnth 10");
		System.out.println("1 Load roster from file");
		System.out.println("2 Add student");
		System.out.println("3 Remove student");
		System.out.println("4 Search student by ID");
		System.out.println("5 Search student by name");
		System.out.println("6 Save change");
		System.out.println("7 Save Changes-- Will save to Text file");
		System.out.println("8 print roster");
		System.out.println("9 Exit");
		System.out.println("Enter option:");
		int option = sc.nextInt();

		while (option != 9) {
			
			if (option == 1) {
				System.out.println("Load roster from file");
				String first = null, last = null, ID = null;
				try {
					File inputFile = new File("./src/inputFile.txt");
					Scanner in = new Scanner(inputFile);
					
					while(in.hasNextLine()) {
						String data = in.nextLine();
						String[] parts = data.split(",");
						Student temp = new Student(parts[0],parts[1], parts[2]);
						Student.inserSort(temp);
					}
					in.close();
					
				}catch(FileNotFoundException e) {
					System.out.println("File not found");
				}
				System.out.println("Select new option or Exit");
				option = sc.nextInt();
			}

			if (option == 2) {
				System.out.println("Enter Student name in following format: First Last ID");
				String first = input.nextLine();
				String last = input.nextLine();
				String ID = input.nextLine();
				Student S1 = new Student(first, last, ID);
				Student.inserSort(S1);
				System.out.println("Select new option or Exit");
				option = sc.nextInt();
			}
			
			if (option == 3) {
				System.out.println("Enter Student name for removal ");
				String first = sc.next();
				String last = sc.next();
				//search student first 
				Student.linkListDelete(Student.searchName(first,last));
				System.out.println("Select new option or Exit");
				option = sc.nextInt();
		}
			
			if (option == 4) {
				System.out.println("Enter 7 digits ID number");
				String ID = input.nextLine();
				System.out.println(Student.searchID(ID));
				System.out.println("Select new option or Exit");
				option = sc.nextInt();
			}
			if (option == 5) {
				System.out.println("Enter First name then last name");
				String first = input.nextLine();
				String last = input.nextLine();
				System.out.println(Student.searchName(first, last));
				System.out.println("Select new option or Exit");
				option = sc.nextInt();
			}
			if (option == 6) {
				System.out.println("Saving changes");
				Student.save();
				System.out.println("Select new option or Exit");
				option = sc.nextInt();
			}
			if (option == 7) {
				System.out.println("Save Changes");
				Student.saveFile();
				System.out.println("Select new option or Exit");
				option = sc.nextInt();
			}
			if(option ==8) {
				System.out.println(Student.toString());
				System.out.println("Select new option or Exit");
				option = sc.nextInt();
			}
			if (option == 9) {
				System.out.println("Program Exit");
				break;
			}
			
		}

		
		/*
		 Student S1 = new Student("Mary", "Doe", "D122223");
		 Student S2 = new Student("JASON", "Smith", "S133334");
		 Student S3 = new Student("JENNY", "Smith", "S135554");
		 Student S4 = new Student("AMY", "Smith", "S143333");
		Student.inserSort(S1);
		Student.inserSort(S2);
		Student.inserSort(S3);
		Student.inserSort(S4);
		Student.linkListDelete(S3);
		 System.out.println(Student.toString());
		 */
		// System.out.println(S1.compareTo(S2));
		// System.out.println(S2.compareTo(S3));
		// System.out.println(S3.compareTo(S4));
		// System.out.println(S1.equals(S2));
		// System.out.println(S2.equals(S3));
		// System.out.println(S3.equals(S4));
		// StudentRecords sR1 = new StudentRecords("Mary","Doe","D122223");
		// sR1.addCourse("CS121");
		// sR1.addCourse("CS111");
		// sR1.addCourse("CS123");
		// System.out.println(sR1);
		// System.out.println(sR1.getCourse());
		// Student.printArray();
		// Student.save();
		// System.out.println(Student.searchID("D122223"));
		// System.out.println(Student.searchName("JASON", "Smith"));

	}
}
