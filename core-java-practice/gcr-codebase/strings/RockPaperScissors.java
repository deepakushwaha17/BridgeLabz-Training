/*Rock-Paper-Scissors is a game played between a minimum of two players. Each player can choose either rock, paper, or scissors. Here
the game is played between a user and a computer. Based on the rules, either a player or a computer will win.Show the status of player
 and computer win in a tabular format across multiple games. Also, show the winning percentage between the player and the computer.*/

import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {
        int rand = (int)(Math.random() * 3); // 0,1,2
        if (rand == 0){
			return "Rock";
		} else if (rand == 1) {
			return "Paper";
        } else{
			return "Scissors";
		}
    }

    public static String findWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "Draw";
        }

        switch (userChoice.toLowerCase()) {
            case "rock":
                return (computerChoice.equalsIgnoreCase("Scissors")) ? "User" : "Computer";
            case "paper":
                return (computerChoice.equalsIgnoreCase("Rock")) ? "User" : "Computer";
            case "scissors":
                return (computerChoice.equalsIgnoreCase("Paper")) ? "User" : "Computer";
            default:
                return "Invalid";
        }
    }

    // Method to calculate status and percentage, return 2D array
    public static String[][] calculateStatus(String[] results) {
        int userWins = 0, computerWins = 0, draws = 0;

        for (String result : results) {
            if (result.equals("User")){
				userWins++;
			} else if (result.equals("Computer")){
				computerWins++;
            } else if (result.equals("Draw")) {
				draws++;
			}
        }

        int totalGames = results.length;

        double userPercentage = (userWins * 100.0) / totalGames;
        double computerPercentage = (computerWins * 100.0) / totalGames;

        String[][] status = new String[4][2];
        status[0][0] = "User Wins"; 
		status[0][1] = Integer.toString(userWins);
        status[1][0] = "Computer Wins";
		status[1][1] = Integer.toString(computerWins);
        status[2][0] = "Draws"; 
		status[2][1] = Integer.toString(draws);
        status[3][0] = "Winning %"; 
		status[3][1] = "User: " + String.format("%.2f", userPercentage) + "%, Computer: " + String.format("%.2f", computerPercentage) + "%";

        return status;
    }

    // Method to display results of every game and status
    public static void displayResults(String[] userChoices, String[] computerChoices, String[] winners, String[][] status) {
        System.out.println("\nGame Results:");
        System.out.println("Game\tUser      Computer     Winner");
        for (int i = 0; i < winners.length; i++) {
            System.out.println((i+1) + "\t" + userChoices[i] + "      " + computerChoices[i] + "       " + winners[i]);
        }

        System.out.println("\n--- Overall Status ---");
        for (String[] row : status) {
            System.out.println(row[0] + "\t: " + row[1]);
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of games to play: ");
        int n = input.nextInt();
        input.nextLine(); 

        String[] userChoices = new String[n];
        String[] computerChoices = new String[n];
        String[] winners = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nGame " + (i+1) + " - Enter your choice (Rock/Paper/Scissors): ");
            String userChoice = input.nextLine();
            String computerChoice = getComputerChoice();

            String winner = findWinner(userChoice, computerChoice);

            userChoices[i] = userChoice;
            computerChoices[i] = computerChoice;
            winners[i] = winner;
        }

        String[][] status = calculateStatus(winners);
        displayResults(userChoices, computerChoices, winners, status);

    }
}
