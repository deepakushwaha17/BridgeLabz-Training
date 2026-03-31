package scenario.OnlineAuctionBiddingSystem;

public class AuctionSystem {
    public static void main(String[] args) {
        AuctionItem item = new AuctionItem("Antique Vase");

        User u1 = new User("U101", "Deepa");
        User u2 = new User("U102", "Mahi");

        try {
            item.placeBid(u1, 100);
            item.placeBid(u2, 120);
            item.placeBid(u1, 110); // Invalid, lower than highest
        } catch (InvalidBidException e) {
            System.out.println(e.getMessage());
        }

        item.showHighestBid();
        item.showAllBids();
    }
}