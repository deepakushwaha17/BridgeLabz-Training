package OnlineVotingSystem;

import java.util.Scanner;

public class OnlineVoting {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ElectionService service = new ElectionServiceImpl();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n---- ONLINE VOTING SYSTEM ----");
            System.out.println("1. Register Voter");
            System.out.println("2. Add Candidate");
            System.out.println("3. Cast Vote");
            System.out.println("4. View Results");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Voter ID: ");
                    int vid = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Voter Name: ");
                    String vname = input.nextLine();

                    service.registerVoter(new Voter(vid, vname));
                    break;

                case 2:
                    System.out.print("Enter Candidate ID: ");
                    int cid = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Candidate Name: ");
                    String cname = input.nextLine();

                    service.addCandidate(new Candidate(cid, cname));
                    break;

                case 3:
                    System.out.print("Enter Voter ID: ");
                    int voterId = input.nextInt();

                    System.out.print("Enter Candidate ID: ");
                    int candidateId = input.nextInt();

                    try {
                        service.castVote(voterId, candidateId);
                    } catch (DuplicateVoteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    service.showResults();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Election ended.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}

