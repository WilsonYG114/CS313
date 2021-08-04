import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class main {

	// CS313 Section23
	// Weixin Yang
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList Student = new LinkedList();
		WaitListQueue list = new WaitListQueue();
		int rosterLength = 0;
		Scanner sc = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		
		// loading txt file 
				System.out.println("Loading roster from file");
				try {
					File inputFile = new File("./src/inputFile.txt");
					Scanner in = new Scanner(inputFile);
					while (in.hasNextLine()) {
						String data = in.nextLine();
						String[] parts = data.split(",");
						Student temp = new Student(parts[0], parts[1], parts[2]);
						Student.inserSort(temp);
						rosterLength++;
						if (rosterLength > 10) {
							list.enqueue(temp);
						}
					}
					in.close();

				} catch (FileNotFoundException e) {
					System.out.println("File not found");
				}
		
		
		System.out.println("Roster Menu------ Maxium legnth 10");
		System.out.println("2 Add student");
		System.out.println("3 Remove student");
	//	System.out.println("8 print roster");
		System.out.println("9 Save and cloase");
		System.out.println("Enter option:");
		int option = sc.nextInt();


		while (option != 9) {

			// Search
			if (option == 2) {
				if (rosterLength < 10) {
					System.out.println("Enter Student name in following format: First Last ID");
					String first = input.nextLine();
					String last = input.nextLine();
					String ID = input.nextLine();
					Student S1 = new Student(first, last, ID);
					Student.inserSort(S1);
					System.out.println("Select new option or Exit");
					option = sc.nextInt();
				} else {
					System.out.println("Roster is full adding to wait list");
					System.out.println("Enter Student name in following format: First Last ID");
					String waitListfirst = input.nextLine();
					String WaitListlast = input.nextLine();
					String WaitListID = input.nextLine();
					Student temp = new Student(waitListfirst, WaitListlast, WaitListID);
					list.enqueue(temp);
					System.out.println("Select new option or Exit");
					option = sc.nextInt();
				}

			}
			
			
			// Remove
			
			if (option == 3) {
				if (rosterLength != 0) {
					System.out.println("Enter Student name for removal ");
					String first = sc.next();
					String last = sc.next();
					// search student first
					Student.linkListDelete(Student.searchName(first, last));
					if(list.isEmpty()!= true) {
						Student.inserSort(list.peek());
						list.dequeue();
					}
					System.out.println("Select new option or Exit");
					option = sc.nextInt();
				} else {
					System.out.println("Roster empty");
					option = sc.nextInt();
					System.out.println("Select new option or Exit");
				}
			}
	
			
			// Search by ID
			if (option == 4) {
				if (rosterLength != 0) {
					System.out.println("Enter 7 digits ID number");
					String ID = input.nextLine();
					if (Student.searchID(ID) != null) {
						System.out.println(Student.searchID(ID));
					} else {
						System.out.println("User not found");
					}

					System.out.println("Select new option or Exit");
					option = sc.nextInt();
				} else {
					System.out.println("Roster empty");
					option = sc.nextInt();
					System.out.println("Select new option or Exit");
				}

			}
	
			/*
			// Search by name
			if (option == 5) {
				if (rosterLength != 0) {
					System.out.println("Enter First name then last name");
					String first = input.nextLine();
					String last = input.nextLine();

					if (Student.searchName(first, last) != null) {
						System.out.println(Student.searchName(first, last));
					} else {
						System.out.println("User not found");
					}
					System.out.println("Select new option or Exit");
					option = sc.nextInt();
				} else {
					System.out.println("Roster empty");
					option = sc.nextInt();
					System.out.println("Select new option or Exit");
				}
			}
	*/
			
			// Print using linkedlist;
			if (option == 8) {
				if (rosterLength != 0) {
					System.out.println(Student.toString());
					System.out.println("Select new option or Exit");
					option = sc.nextInt();
				} else {
					System.out.println("Roster empty");
					option = sc.nextInt();
					System.out.println("Select new option or Exit");
				}
			}
			
			// Exit
			if (option == 9) {
				System.out.println("Program Exit");
				list.saveWaitList();
				Student.saveFile();
				break;
			}

		}

	}
}
