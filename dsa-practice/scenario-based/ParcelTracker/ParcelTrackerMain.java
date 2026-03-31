package ParcelTracker;

public class ParcelTrackerMain {

    public static void main(String[] args) {

        ParcelTracker parcel = new ParcelTracker("Packed");

        parcel.addStage("Shipped");
        parcel.addStage("In Transit");
        parcel.addStage("Delivered");

        // Add custom intermediate checkpoint
        parcel.addCheckpointAfter("Shipped", "Customs Clearance");

        // Forward tracking
        System.out.println("Tracking Path:");
        System.out.println(parcel.trackParcel());

        // Parcel status
        System.out.println(parcel.checkParcelStatus());
    }
}
