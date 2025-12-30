import java.util.Random;

public class SnakeLadderGame {

    static final int WINNING_POSITION = 100;
    static final int START_POSITION = 0;
    
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;

    static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game !");
        playSinglePlayer();
        System.out.println("\n========================================\n");
        playTwoPlayers();
    }

    public static void playSinglePlayer() {
        System.out.println("--- Starting SINGLE PLAYER Game ---");
        
        int position = START_POSITION;
        int rollCount = 0;

        while (position < WINNING_POSITION) {
            rollCount++;
            int die = rand.nextInt(6) + 1;
            int option = rand.nextInt(3);

            // Calculate new position using helper function
            position = calculateNewPosition(position, die, option);

            System.out.println("Roll: " + die + " | Position: " + position);
        }

        System.out.println("Single Player Won! Total Dice Rolls: " + rollCount);
    }

    public static void playTwoPlayers() {
        System.out.println("--- Starting TWO PLAYER Game ---");

        int p1Pos = START_POSITION;
        int p2Pos = START_POSITION;
        boolean isPlayer1Turn = true; // Flag to track whose turn it is

        while (p1Pos < WINNING_POSITION && p2Pos < WINNING_POSITION) {
            
            int die = rand.nextInt(6) + 1;
            int option = rand.nextInt(3);
            
            if (isPlayer1Turn) {
                // --- Player 1 Turn ---
                System.out.print("P1 Rolls: " + die + " | ");
                p1Pos = calculateNewPosition(p1Pos, die, option);
                System.out.println("P1 Pos: " + p1Pos);

                if (p1Pos == WINNING_POSITION) {
                    System.out.println("RESULT: Player 1 Wins!");
                    break;
                }
                
                // UC 7: If Ladder, Player 1 plays again (do not switch flag)
                // Otherwise, switch to Player 2
                if (option != LADDER) {
                    isPlayer1Turn = false;
                }

            } else {
                // --- Player 2 Turn ---
                System.out.print("P2 Rolls: " + die + " | ");
                p2Pos = calculateNewPosition(p2Pos, die, option);
                System.out.println("P2 Pos: " + p2Pos);

                if (p2Pos == WINNING_POSITION) {
                    System.out.println("RESULT: Player 2 Wins!");
                    break;
                }

                // UC 7: If Ladder, Player 2 plays again
                // Otherwise, switch to Player 1
                if (option != LADDER) {
                    isPlayer1Turn = true;
                }
            }
        }
    }

    public static int calculateNewPosition(int currentPos, int die, int option) {
        switch (option) {
            case NO_PLAY:
                // No change
                break;
            case LADDER:
                currentPos += die;
                // UC 5: Exact winning position check
                if (currentPos > WINNING_POSITION) {
                    currentPos -= die; 
                }
                break;
            case SNAKE:
                currentPos -= die;
                // UC 4: Restart from 0 if below 0
                if (currentPos < START_POSITION) {
                    currentPos = START_POSITION;
                }
                break;
        }
        return currentPos;
    }
}