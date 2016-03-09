/**
 * Created by adempus on 2/22/16.
 */

import java.util.*;

public class Main
{
    static int playerCount = 0;

    public static void main(String[] args) {
        String player1Name = getPlayer();
        String player2Name = getPlayer();

        String player;
        TicTacToeBoard game = new TicTacToeBoard(3, 3);
        System.out.println("\n" + player1Name + ", you are X, and go first.");

        /** game loop */
        do {
            //print the game's board
            game.printBoard();

            // check if there is a draw
            if(game.isADraw()) {
                System.out.println("Its a draw!");
                System.exit(0);
            }

            // initialize a counter to track turns
            int counter = game.getTurnCounter();
            // if counter equals 0 it's player 1's turn, otherwise it's player 2's turn
            player = (counter == 0 ? player1Name : player2Name);
            // if counter is equals the move is X, otherwise the move is O
            String XOValue = (counter == 0 ? "X" : "O");
            System.out.print(player + " please input a row and column # " +
                    "between 1-3: for " + XOValue + ": ");

            try {
                int rowCol[] = getRowAndCol();
                game.add(rowCol[0], rowCol[1])
            } catch (UnsupportedOperationException | IndexOutOfBoundsException ex) {
                System.out.println(ex.getMessage());
            }
        } while(!game.isWinner());
        /** loop end **/

        game.printBoard();
        System.out.println(player + " wins!");
    }

    // Method to retrieve the players names
    public static String getPlayer() {
        Scanner scan = new Scanner(System.in);
        String prompt = (playerCount == 0 ? "Player 1 enter your name: "
                : "Player 2 enter your name: ");
        System.out.print(prompt);
        String playerName = scan.nextLine();
        playerCount ^= 1;

        return playerName;
    }

    // Method to retrieve the player's row and column inputs
    public static int[] getRowAndCol() {
        Scanner scan = new Scanner(System.in);
        String rowCol = scan.nextLine().replaceAll("\\s", "");
        int rowColArray[] = new int[2];

        rowColArray[0] = Character.getNumericValue(rowCol.charAt(0));
        rowColArray[1] = Character.getNumericValue(rowCol.charAt(1));

        return rowColArray;
    }
}
