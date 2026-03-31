package dsaLinkedlist;

import java.util.Scanner;

public class StudentRecordManagement {
	
	public static StudentNode userInput(Scanner input) {
		System.out.print("Enter Roll no : ");
		int rollNo = input.nextInt();
		input.nextLine();
		System.out.print("Enter Name : ");
		String name = input.nextLine();
		System.out.print("Enter Age : ");
		int age = input.nextInt();
		input.nextLine();
		System.out.print("Enter Grade : ");
		char grade = input.next().charAt(0);
		grade = Character.toUpperCase(grade);
		
		return new StudentNode(rollNo , name , age ,grade);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		StudentLinkedList list = new StudentLinkedList();
		while(true) {
			System.out.println("\n----Student Record Management");
			System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All Records");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch(choice) {
            
            	case 1:
	                StudentNode newNode1 = userInput(input);
	                list.addAtBeginning(newNode1.rollNo, newNode1.name, newNode1.age, newNode1.grade);
	                break;

            	case 2:
	                StudentNode newNode2 = userInput(input);
	                list.addAtEnd(newNode2.rollNo, newNode2.name, newNode2.age, newNode2.grade);
	                break;

            	case 3:
	                System.out.print("Enter Position: ");
	                int pos = input.nextInt();
	                StudentNode newNode3 = userInput(input);
	                list.addAtPosition(pos, newNode3.rollNo, newNode3.name, newNode3.age, newNode3.grade);
	                break;
	                
            	case 4:
            		System.out.print("Enter Roll No: ");
	                int dRollNo = input.nextInt();
	                list.deleteByRollNo(dRollNo);
	                break;
	              
            	case 5:
            		System.out.print("Enter Roll No: ");
	                int sRollNo = input.nextInt();
	                list.searchByRollNo(sRollNo);
	                break;
	                
            	case 6:
            		System.out.print("Enter Roll No: ");
	                int uRollNo = input.nextInt();
	                input.nextLine();
	                System.out.print("Enter New Grade: ");
	                char newGrade = input.next().charAt(0);
	                newGrade = Character.toUpperCase(newGrade);
	                list.updateGrade(uRollNo,newGrade);
	                break;
	                
            	case 7:
            		list.displayRecords();
            		break;
            		
            	case 8:
            		System.out.println("Exiting...");
            		input.close();
            		
            	default:
            		System.out.println("Invalid choice!");
            }
            
		}

	}

}

class StudentNode{
	int rollNo;
	String name;
	int age; 
	char grade;
	StudentNode next;
	
	StudentNode(int rollNo , String name , int age , char grade){
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
}

class StudentLinkedList{
	StudentNode head;
	
	// method to add at beginning
	void addAtBeginning(int rollNo , String name , int age , char grade) {
		StudentNode newNode = new StudentNode(rollNo , name ,age , grade);
		newNode.next = head;
		head = newNode;
	}
	
	// method to add at end
	void addAtEnd(int rollNo , String name , int age , char grade) {
		StudentNode newNode = new StudentNode(rollNo , name ,age , grade);

		if(head == null) {
			head = newNode;
			return;
		}
		StudentNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	// method to add at specific position
	void addAtPosition(int position , int rollNo , String name , int age , char grade) {
		if(position == 1) {
			addAtBeginning(rollNo , name, age,grade);
			return;
		}
		
		StudentNode newNode = new StudentNode(rollNo , name , age , grade);
		StudentNode temp = head;
		for(int i = 1 ; i < position -1 && temp != null ; i++) {
			temp = temp.next;
		}
		
		if(temp == null) {
			System.out.println("Invalid position");
			return;
		}
		
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	// method to delete by roll no.
	void deleteByRollNo(int rollNo) {
		if(head == null) {
			System.out.println("List is empty!");
			return;
		}
		
		if(head.rollNo == rollNo) {
			head = head.next;
			System.out.println("Roll number " +rollNo +" student deleted successfully." );
			return;
		}
		
		StudentNode temp = head;
		while(temp.next != null && temp.next.rollNo != rollNo) {
			temp = temp.next;
		}
		
		if(temp.next == null) {
			System.out.println("Student not found.");
		}else {
			temp.next = temp.next.next;
			System.out.println("Roll number " +rollNo +" student deleted successfully." );
		}
	}
	
	// method to search by roll no.
	void searchByRollNo(int rollNo) {
		StudentNode temp = head;
		
		while(temp != null) {
			if(temp.rollNo == rollNo) {
				System.out.println("Student Found . ");
				System.out.println("Student Roll no. : " + temp.rollNo);
				System.out.println("Student Name : " + temp.name);
				System.out.println("Student Age : " + temp.age);
				System.out.println("Student Grade : " + temp.grade);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student not Found.");
	}
	
	// method to display all student records
	void displayRecords() {
		if(head == null) {
			System.out.println("No student records available");
			return;
		}
		
		StudentNode temp = head;
		while(temp != null) {
			System.out.println("\n-----Student records-----");
			System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
			temp = temp.next;
		}

	}
	
	// method to update grade by roll no.
	void updateGrade(int rollNo , char newGrade) {
		StudentNode temp = head;
	    while (temp != null) {
	    	if (temp.rollNo == rollNo) {
	    		temp.grade = newGrade;
	    		System.out.println("Grade updated successfully");
	            return;
	        }
	    	temp = temp.next;
	    }
	    System.out.println("Student not found.");
	}
	
}