package dsaLinkedlist;

public class TextEditorSystem {
	public static void main(String[] args) {
	    
	    TextEditor editor = new TextEditor(10); // History limit = 10

	    // Simulate typing / actions
	    editor.addState("Hello");
	    editor.addState("Hello World");
	    editor.addState("Hello World!");
	    editor.addState("Hello World! This");
	    editor.addState("Hello World! This is");
	    editor.addState("Hello World! This is TextEditor");
	    
	    System.out.println("Current State:");
	    editor.displayCurrent();

	    System.out.println("\nPerforming 2 Undos:");
	    editor.undo();
	    editor.displayCurrent();
	    editor.undo();
	    editor.displayCurrent();

	    System.out.println("\nPerforming 1 Redo:");
	    editor.redo();
	    editor.displayCurrent();

	    System.out.println("\nAdding new state after undo:");
	    editor.addState("Hello World! This is Undo-Redo TextEditor");
	    editor.displayCurrent();

	    System.out.println("\nAttempting Redo after new state:");
	    editor.redo();
	    
	    // Adding more states to exceed history limit
	    editor.addState("State 7");
	    editor.addState("State 8");
	    editor.addState("State 9");
	    editor.addState("State 10");
	    editor.addState("State 11"); // Oldest state should be removed
	    
	    System.out.println("\nCurrent State after exceeding history limit:");
	    editor.displayCurrent();
	    
	    System.out.println("\nFull History (limited to last 10 states):");
	    editor.displayHistory();
	}


}

class TextNode {
    String text;
    TextNode next, prev;

    TextNode(String text) {
        this.text = text;
        this.next = this.prev = null;
    }
}

class TextEditor {
	TextNode head, tail, current;
    int historyLimit;
    int size;

    TextEditor(int limit) {
        historyLimit = limit;
        size = 0;
        head = tail = current = null;
    }

    // method to Add new state
    void addState(String text) {
    	TextNode newNode = new TextNode(text);

        if (current != null && current.next != null) {
            // Clear redo history
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = tail;
        }

        size++;

        // Limit history size
        if (size > historyLimit) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Added State: \"" + text + "\"");
    }

    // method to Undo
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // method to Redo
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // method to Display current state
    void displayCurrent() {
        if (current != null) {
            System.out.println(current.text);
        } else {
            System.out.println("No text available.");
        }
    }

    // method to Display full history
    void displayHistory() {
    	TextNode temp = head;
        while (temp != null) {
            System.out.println(temp.text);
            temp = temp.next;
        }
    }
}
