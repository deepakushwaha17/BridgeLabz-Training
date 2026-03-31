package collections.list;

import java.util.LinkedList;
import java.util.Stack;

public class FindElementFromEnd {
	
	public static void nElementFromEnd(LinkedList<Character> list , int n) {
		Stack<Character> stack = new Stack<>();

        for (char s : list) {
            stack.push(s);
        }

        char result = ' ';
        for (int i = 0; i < n; i++) {
            result = stack.pop();
        }
        System.out.println("Nth element from end : " +result);
	}

	public static void main(String[] args) {
		LinkedList<Character> linkedList = new LinkedList<>();
		linkedList.add('A');
		linkedList.add('B');
		linkedList.add('C');
		linkedList.add('D');
		linkedList.add('E');
		int n = 2;
		nElementFromEnd(linkedList,n);
	}

}
