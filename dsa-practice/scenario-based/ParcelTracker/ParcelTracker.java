package ParcelTracker;

public class ParcelTracker {

    private StageNode head;

    // Initialize parcel with first stage
    public ParcelTracker(String firstStage) {
        head = new StageNode(firstStage);
    }

    // Add stage at the end
    public boolean addStage(String stageName) {
        StageNode newNode = new StageNode(stageName);

        if (head == null) {
            head = newNode;
            return true;
        }

        StageNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return true;
    }

    // Add intermediate checkpoint after a given stage
    public boolean addCheckpointAfter(String existingStage, String newStage) {
        StageNode current = head;

        while (current != null) {
            if (current.stageName.equals(existingStage)) {
                StageNode checkpoint = new StageNode(newStage);
                checkpoint.next = current.next;
                current.next = checkpoint;
                return true;
            }
            current = current.next;
        }

        return false; // stage not found
    }

    // Forward tracking through delivery stages
    public String trackParcel() {
        if (head == null) {
            return "No tracking information available.";
        }

        StringBuilder trackingInfo = new StringBuilder();
        StageNode current = head;

        while (current != null) {
            trackingInfo.append(current.stageName);

            if (current.next != null) {
                trackingInfo.append(" -> ");
            }

            current = current.next;
        }

        return trackingInfo.toString();
    }

    // Detect lost or missing parcel 
    public String checkParcelStatus() {
        if (head == null) {
            return "Parcel data missing.";
        }

        StageNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        if (!current.stageName.equalsIgnoreCase("Delivered")) {
            return "Parcel tracking interrupted. Last known stage: " + current.stageName;
        }

        return "Parcel successfully delivered.";
    }
}