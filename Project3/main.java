import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class main {

	// CS313 Section23
	// project3
	// Weixin Yang
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BST roster = new BST();
		WaitListQueue list = new WaitListQueue();
		int rosterLength = 0;
		Scanner sc = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		System.out.println("Roster Menu------ Maxium legnth 20");
		System.out.println("1 Load roster from file");
		System.out.println("2 Add student");
		System.out.println("3 Remove student");
		System.out.println("4 Search student by ID");
		System.out.println("5 Search student by name");
		System.out.println("6 Save to sorted array");
		System.out.println("7 Save Final roster to text file");
		System.out.println("8 print roster");
		System.out.println("10 Add to wait list");
		System.out.println("9 Exit");
		System.out.println("Enter option:");
		int option = sc.nextInt();

		while (option != 9) {

			// Load from txt Function working
			if (option == 1) {
				System.out.println("Load roster from file");
				// String first = null, last = null, ID = null;
				try {
					File inputFile = new File("./src/inputFile.txt");
					Scanner in = new Scanner(inputFile);

					while (in.hasNextLine()) {
						String data = in.nextLine();
						String[] parts = data.split(",");
						Student temp = new Student(parts[0], parts[1], parts[2]);
						roster.inserSort(temp);
						rosterLength++;
						if (rosterLength > 20) {
							list.enqueue(temp);
						}
					}
					in.close();

				} catch (FileNotFoundException e) {
					System.out.println("File not found");
				}
				System.out.println("Select new option or Exit");
				option = sc.nextInt();
				System.out.println("Select new option or Exit");
			}

			// Insertion sort to BST Function working
			if (option == 2) {
				if (rosterLength != 20) {
					System.out.println("Enter Student name in following format: First Last ID");
					String first = input.nextLine();
					String last = input.nextLine();
					String ID = input.nextLine();
					Student S1 = new Student(first, last, ID);
					roster.inserSort(S1);
					rosterLength++;
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
			
			
			if (option == 3) {
				if (rosterLength != 0) {
					System.out.println("Enter Student name for removal ");
					String first = sc.next();
					String last = sc.next();
					// search student first
					Student temp = new Student(first,last);	
					roster.delete(temp);
					if(list.isEmpty()!= true) {
						roster.inserSort(list.peek());
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
					Student temp = new Student(ID);
					System.out.println(roster.searchByID(temp));
					System.out.println("Select new option or Exit");
					option = sc.nextInt();
				} else {
					System.out.println("Roster empty");
					option = sc.nextInt();
					System.out.println("Select new option or Exit");
				}

			}

			// Search by name
			if (option == 5) {
				if (rosterLength != 0) {
					System.out.println("Enter First name then last name");
					String first = input.nextLine();
					String last = input.nextLine();
					Student temp = new Student(first, last);
					System.out.println(temp.toString());
					if (roster.searchByName(temp) != null) {
						System.out.println(roster.searchByName(temp));
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

			// Save changes to array 
			if (option == 6) {
				System.out.println("Saving to sorted Array");
				roster.saveSortArray();
				System.out.println("Select new option or Exit");
				option = sc.nextInt();
			}

			// Save to txt 
			if (rosterLength != 0) {
				if (option == 7) {
					System.out.println("Save to text file");
					roster.saveFinalRoster();
					System.out.println("Select new option or Exit");
					option = sc.nextInt();
				}
			} else {
				System.out.println("Roster empty");
				option = sc.nextInt();
				System.out.println("Select new option or Exit");
			}

			// Print In Order from BST 
			if (option == 8) {
				if (rosterLength != 0) {
					roster.InOrder();
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
				break;
			}

		}

	}
}
