package scenario.OnlineAuctionBiddingSystem;

public class User implements Comparable<User> {
    private String userID;
    private String name;

    public User(String userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public String getUserID() { return userID; }
    public String getName() { return name; }

    @Override
    public int compareTo(User other) {
        return this.userID.compareTo(other.userID); // TreeMap needs comparable
    }

    @Override
    public String toString() {
        return name + " (" + userID + ")";
    }
}