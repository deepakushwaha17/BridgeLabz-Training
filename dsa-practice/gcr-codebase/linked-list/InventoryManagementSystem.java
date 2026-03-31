package dsaLinkedlist;

public class InventoryManagementSystem {
	public static void main(String[] args) {

        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtBeginning(101, "Laptop", 5, 55000);
        inventory.addAtEnd(102, "Mouse", 20, 500);
        inventory.addAtEnd(103, "Keyboard", 15, 1200);
        inventory.addAtPosition(2, 104, "Monitor", 7, 8000);

        inventory.displayAll();

        inventory.searchById(102);
        inventory.updateQuantity(103, 25);
        inventory.totalInventoryValue();

        inventory.sortByName(true);
        System.out.println("\nSorted by Name (Ascending):");
        inventory.displayAll();

        inventory.sortByPrice(false);
        System.out.println("\nSorted by Price (Descending):");
        inventory.displayAll();

        inventory.removeById(104);
        inventory.displayAll();
    }


}

class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList{
	ItemNode head;

    // method to add at beginning
    void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // method to add at end
    void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }
    
    // method to add at specific position
    void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // method to remove by Item ID
    void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed: " + id);
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next == null)
            System.out.println("Item not found");
        else {
            temp.next = temp.next.next;
            System.out.println("Item removed: " + id);
        }
    }

    // method to update quantity
    void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated for Item ID: " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // method to search by Item ID
    void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
            	System.out.println(temp.itemId + " | " + temp.itemName +
                  " | Quantity: " + temp.quantity + " | Price: ₹" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // method to search by Item Name
    void searchByName(String name) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
            	System.out.println(temp.itemId + " | " + temp.itemName +
                 " | Quantity: " + temp.quantity + " | Price: ₹" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Total inventory value
    void totalInventoryValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value = ₹" + total);
    }

    // method to sort by Item Name
    void sortByName(boolean ascending) {
        for (ItemNode i = head; i != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.itemName.compareTo(j.itemName) > 0) ||
                    (!ascending && i.itemName.compareTo(j.itemName) < 0)) {
                    swapData(i, j);
                }
            }
        }
    }

    // method to sort by Price
    void sortByPrice(boolean ascending) {
        for (ItemNode i = head; i != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.price > j.price) ||
                    (!ascending && i.price < j.price)) {
                    swapData(i, j);
                }
            }
        }
    }

    // method to swap data
    void swapData(ItemNode a, ItemNode b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    // method to display all items
    void displayAll() {
        ItemNode temp = head;
        System.out.println("\nInventory Items:");
        while (temp != null) {
        	System.out.println(temp.itemId + " | " + temp.itemName +
                    " | Quantity: " + temp.quantity + " | Price: ₹" + temp.price);
            temp = temp.next;
        }
    }
}
