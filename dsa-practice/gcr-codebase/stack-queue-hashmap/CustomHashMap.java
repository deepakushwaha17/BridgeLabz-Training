package dsaProblems;

public class CustomHashMap {
	public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 100);
        map.put(2, 200);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
class Node {
    int key, value;
    Node next;
    Node(int k, int v) {
        key = k;
        value = v;
    }
}
class MyHashMap {
   
	int SIZE = 10;
    Node[] table = new Node[SIZE];

    int hash(int key) {
        return key % SIZE;
    }

    void put(int key, int value) {
        int index = hash(key);
        Node node = table[index];

        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    int get(int key) {
        int index = hash(key);
        Node node = table[index];

        while (node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        return -1;
    }
}
