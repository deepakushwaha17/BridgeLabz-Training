package scenario.OnlineAuctionBiddingSystem;

import java.util.*;

public class AuctionItem {
    private String itemName;
    private TreeMap<User, Double> bids = new TreeMap<>(); // Users sorted by ID

    public AuctionItem(String itemName) {
        this.itemName = itemName;
    }

    public void placeBid(User user, double amount) throws InvalidBidException {
        double highestBid = bids.isEmpty() ? 0 : Collections.max(bids.values());
        if (amount <= highestBid) {
            throw new InvalidBidException("Bid must be higher than current highest bid: " + highestBid);
        }
        bids.put(user, amount);
        System.out.println(user.getName() + " placed a bid of $" + amount + " on " + itemName);
    }

    public void showHighestBid() {
        if (bids.isEmpty()) {
            System.out.println("No bids yet for " + itemName);
            return;
        }
        User highestUser = Collections.max(bids.entrySet(), Map.Entry.comparingByValue()).getKey();
        double highestAmount = bids.get(highestUser);
        System.out.println("Highest bid for " + itemName + ": " + highestAmount + " by " + highestUser.getName());
    }

    public void showAllBids() {
        System.out.println("All bids for " + itemName + ":");
        for (Map.Entry<User, Double> entry : bids.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }
}

