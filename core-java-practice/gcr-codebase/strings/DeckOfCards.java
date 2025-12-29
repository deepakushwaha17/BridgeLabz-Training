/*Write a program to create a deck of cards, initialize the deck, shuffle the deck, and distribute the deck of n cards to 
x number of players. Finally, print the cards the players have.*/

import java.util.Scanner;

public class DeckOfCards {

    // Initialize the deck of cards
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Shuffle the deck
    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            // Swap deck[i] with deck[randomCardNumber]
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Distribute the deck to players
    public static String[][] distributeDeck(String[] deck, int numOfPlayers, int numOfCardsPerPlayer) {
        if (numOfPlayers * numOfCardsPerPlayer > deck.length) {
            System.out.println("Not enough cards to distribute.");
            return null;
        }

        String[][] players = new String[numOfPlayers][numOfCardsPerPlayer];
        int cardIndex = 0;

        for (int i = 0; i < numOfCardsPerPlayer; i++) {
            for (int j = 0; j < numOfPlayers; j++) {
                players[j][i] = deck[cardIndex++];
            }
        }
        return players;
    }

    // Print players and their cards
    public static void printPlayersCards(String[][] players) {
        if (players == null){
			return;
		}
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (String card : players[i]) {
                System.out.println("  " + card);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Suits and Ranks
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = initializeDeck(suits, ranks);
        shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int numOfPlayers = input.nextInt();
        System.out.print("Enter number of cards per player: ");
        int numOfCardsPerPlayer = input.nextInt();
		
        String[][] players = distributeDeck(deck, numOfPlayers, numOfCardsPerPlayer);
        printPlayersCards(players);
    }
}
