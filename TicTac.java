//Name: Stanley Delva

//Due Date: Feb 21

//Tic-tac-toe game
//===============================================================

import java.util.Scanner;

public class TicTac {


    public static void main(String[] args) {
        //initiate Scanner object for input
        Scanner scan = new Scanner(System.in);
        //create 2D char array to display game board 
        char[] [] tacBoard = new char[3] [3];
        
        //initiliaze values of array to designate unclaimed spots of game board
        for (int i = 0; i < 3; i++) {
            for (int ii = 0; ii < 3; ii++) {
                tacBoard [i] [ii] = '-';
            }
        } 



        System.out.println("Tic-tac-toe: ");

        //boolean to check if it's player one's turn; if false, it is player two's turn
        boolean firstPlayerTurn = true;

        boolean gameDone = false;
        while (!gameDone) {

            //call drawBoard function to draw game board
            drawBoard(tacBoard);

            //if it is player one's turn, inputted spot will be marked with an 'x'
            char marker = ' ';
            if(firstPlayerTurn) {
                marker = 'x';
                System.out.println("Player 1's turn. Marker is x.");
            }
            //if it is player two's turn, inputted spot will be marked with an 'o'
            else {
                marker = 'o';
                System.out.println("Player 2's turn. Marker is o.");
            }

            //Values to store coordinate inputs
            int row = 0;
            int column = 0;

            while(true) {
                //Get row and column index from user
                System.out.print("Enter the row index: ");
                row = scan.nextInt();
                System.out.print("Enter the column index: ");
                column = scan.nextInt();

                //If row and column are not within scope of array (0 - 2), try again
                if (row < 0 || column < 0 || row > 2 || column > 2) {
                    System.out.println("Coordinates are out of bounds.");
                }
                //If coordinate is already occupied, user cannot claim it
                else if (tacBoard[row][column] != '-') {
                    System.out.println("Spot is already occupied");
                }
                //If coordinate is valid, continue
                else {
                    break;
                }

            }
            //place marker in requested spot of board
            tacBoard[row][column] = marker;

            //if hasWon returns 'x', player one wins; if it returns 'o', player 2 wins; if it returns neither the players have either tied, or the game is not done
            if (hasWon(tacBoard) == 'x') {
                System.out.println("\nPlayer 1 has won");
                gameDone = true;
            }
            //if hasWon returns 'o', player two wins
            else if (hasWon(tacBoard) == 'o') {
                System.out.println("\nPlayer 2 has won");
                gameDone = true;
            }
            //if hasWon returns neither 'x' or 'o', no one has won
            else {
                //if hasTied is true, players have tied
                if (hasTied(tacBoard)) {
                    System.out.println("\nNo one wins; It's a draw.");
                    gameDone = true;
                }
                //if hasTied is false, game is not done. Switch turns and continue the game
                else {
                    firstPlayerTurn = !firstPlayerTurn;

                }
            }
        }

        //print resulting game board after game is done
        drawBoard(tacBoard);



    }

    //mehtod to draw game board
    public static void drawBoard(char[] [] board) {
        //print contents of 2D and print resulting game board
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int ii = 0; ii < 3; ii++) {
                System.out.print(": ");
                System.out.print(board[i] [ii] + " ");

            }
            System.out.print(":");
            System.out.println("\n-------------");
        }
    }

    //method to decide if there is a winner
    public static char hasWon (char[] [] board) {
        //if a player has 3 of their markers in a row, they win
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }


        //if a player has 3 of their markers in a column, they win
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return board[0][i];
            }
        }

        //if a player has 3 of their markers diagonally, they win
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
       
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }

        //If none of the if statements are fulfilled, no one has won
        return '-';
                
    }

    //method to decide if there is a tie
    public static boolean hasTied(char[][] board) {
        //if any of the spots on the game board are empty, players have not tied, so return false
        for (int i = 0; i < 3; i++) {
            for (int ii = 0; ii < 3; ii++) {
                if(board[i][ii] == '-') {
                    return false;
                }
            }
        }
        //if none of the spots are empty, players have tied; return true
        return true;
    }
}
