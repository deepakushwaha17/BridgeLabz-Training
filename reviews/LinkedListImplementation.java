package reviews;

public class LinkedListImplementation {

	public static void main(String[] args) {
	
		LinkedListOperations op = new LinkedListOperations();
		op.addAtBeginning(10);
		op.addAtEnd(20);
		op.addAtPosition(30, 1);
		op.display();
		op.delete(30);
		op.display();

	}

}

// Node has data and next pointer
class LinkedListNode{
	int data;
	LinkedListNode next;
	
	public LinkedListNode(int data) {
		this.data = data;
		this.next = null;
	}
}

// Linked List operations
class LinkedListOperations {
    LinkedListNode head;

    void addAtBeginning(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next = head;
        head = newNode;
    }

    void addAtEnd(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        LinkedListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void addAtPosition(int data, int pos) {
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            addAtBeginning(data);
            return;
        }

        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println(data + " is deleted.");
            return;
        }

        LinkedListNode temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Data not found.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println(data + " is deleted.");
    }

    void display() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        LinkedListNode temp = head;
        System.out.print("Linked List Data: ");
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
