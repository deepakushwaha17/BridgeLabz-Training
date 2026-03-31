package dsaLinkedlist;

import java.util.ArrayList;


public class SocialMediaSystem {
	public static void main(String[] args) {

	    SocialMedia sm = new SocialMedia();

	    sm.addUser(1, "Amit", 25);
	    sm.addUser(2, "Priya", 23);
	    sm.addUser(3, "Rohan", 26);
	    sm.addUser(4, "Sneha", 24);
	    sm.addUser(5, "Vikram", 27);

	    // Friend connections
	    sm.addFriend(1, 2); // Amit - Priya
	    sm.addFriend(1, 3); // Amit - Rohan
	    sm.addFriend(2, 4); // Priya - Sneha
	    sm.addFriend(3, 4); // Rohan - Sneha
	    sm.addFriend(4, 5); // Sneha - Vikram

	    sm.displayFriends(1); // Amit's friends
	    sm.displayFriends(4); // Sneha's friends

	    sm.mutualFriends(1, 4); // Amit & Sneha
	    sm.mutualFriends(2, 3); // Priya & Rohan

	    sm.removeFriend(1, 3); // Amit - Rohan removed

	    sm.displayFriends(1); // Amit's friends
	    sm.displayFriends(3); // Rohan's friends

	    sm.countFriends();

	    sm.displayUsers();
	}


}

class UserNode {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friends; // List of Friend IDs
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    UserNode head;

    // method to Add new user
    void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    // method to Find user by ID
    UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    // method to Find user by Name
    UserNode findUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    // method to Add friend connection (bidirectional)
    void addFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friends.contains(userId2)) {
        	user1.friends.add(userId2);
        }
        if (!user2.friends.contains(userId1)) {
        	user2.friends.add(userId1);
        }

        System.out.println("Friend connection added: " + user1.name + " - " + user2.name);
    }

    // method to Remove friend connection
    void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friends.remove(Integer.valueOf(userId2));
        user2.friends.remove(Integer.valueOf(userId1));

        System.out.println("Friend connection removed: " + user1.name + " - " + user2.name);
    }

    // method to Find mutual friends
    void mutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        ArrayList<Integer> mutual = new ArrayList<>();
        for (int fid : user1.friends) {
            if (user2.friends.contains(fid)) {
                mutual.add(fid);
            }
                
        }

        System.out.println("\nMutual friends between " + user1.name + " and " + user2.name + ": " + mutual);
    }

    // method to Display all friends of a user
    void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        if (user.friends.isEmpty()) {
            System.out.println("No friends.");
        }
        else {
            System.out.println(user.friends);
        }
    }

    // method to Count number of friends for each user
    void countFriends() {
        UserNode temp = head;
        System.out.println("\nNumber of friends for each user:");
        while (temp != null) {
            System.out.println(temp.name + " (" + temp.userId + "): " + temp.friends.size());
            temp = temp.next;
        }
    }

    // method to Display all users
    void displayUsers() {
        UserNode temp = head;
        System.out.println("\nAll Users:");
        while (temp != null) {
            System.out.println(temp.userId + " | " + temp.name + " | Age: " + temp.age + " | Friends: " + temp.friends);
            temp = temp.next;
        }
    }
}