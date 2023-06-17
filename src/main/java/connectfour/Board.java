package connectfour;

import java.util.ArrayList;

/**
 * The Board class handles the changes in the board and checks the conditions for the winner.
 * It checks for four matches in a straight line and ends the program when someone wins/ties
 * @author Nabhan Anwar
 */
public class Board{

    private ArrayList<Character> connectFourBoard = new ArrayList<>();
    private TextUI text = new TextUI();

    /**
     * This is the setter method to update the board
     * so it can be processed in this class
     * @param theBoard
     * @author Nabhan Anwar
    */
    public void setBoard(ArrayList<Character> theBoard){
        connectFourBoard = theBoard;
    }
    
    /**
     * This is a getter method to return to main
     * @return the updated board
     * @author Nabhan Anwar
     */
    public ArrayList<Character> getBoard(){
        return connectFourBoard;
    }

    /**
     * this method will be used to check if the bottom rows of a 
     * column are filled and where the letter will be next
     * @param column the column that the player's choice will drop into
     * @param turn the current player's turn
     * @exception IndexOutOfBoundsException On user inputting on a full column 
     * @author Nabhan Anwar
     */
    public void fillCell(int column, char turn) throws IndexOutOfBoundsException{
        int rows = 5;
        if(column == 7){
            return;
        }
        try{
            //every row has 8 characters, loops through to find 1 or 2, then go to next row
            while(connectFourBoard.get(rows*8 + column).equals('1') 
            || connectFourBoard.get(rows*8 + column).equals('2')){
                rows--;
            }
        } catch(IndexOutOfBoundsException e){
            System.out.println("Column is full!");
            return;
        }
        connectFourBoard.set(rows*8 + column, turn);
    }

    /**
     * checks whether the board is full by checking for any 0's remaining in the Arraylist
     * @return true if the board is full 
     * @author Nabhan Anwar
     */
    public boolean isBoardFull(){
        ArrayList<Character> boardToCheck = getBoard();
        //loop through the ArrayList to find any 0's
        for(int i = 0; i < boardToCheck.size(); i++){
            if(boardToCheck.get(i).equals('0')){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks to see the player won by places four consecutively on the board.
     * Uses the other check methods to see if at least one of them is true.
     * Otherwise checks if board is full and prints out the draw message.
     * @param playerTurn The current player's turn which is checked to see if they won 
     * @author Nabhan Anwar
     */
    public void checkWinner(char playerTurn){

        //prints win message and exits if any of the following are true
        if(checkVertical(playerTurn)){
            text.winMessage(playerTurn);
            System.exit(0);
        } else if(checkHorizontal(playerTurn)){
            text.winMessage(playerTurn);
            System.exit(0);
        } else if(checkDiagonal(playerTurn)){
            text.winMessage(playerTurn);
            System.exit(0);
        
        //prints tie message and exits if the board is full
        } else if(isBoardFull()){
            text.tieMessage();
            System.exit(0);
        }
    }

    /**
     * Checks for four matches vertically on the Arraylist.
     * @param playerTurn the current player's turn which is checked to see if they won 
     * @return true if four of the player's number is matched vertically
     * @author Nabhan Anwar
     */
    public boolean checkVertical(char playerTurn){
        int rows = 5;
        int matches = 0;
        int columnNum = 0;
        //loop to go through each column, stop if at last column or 4 matches found
        while(columnNum != 7 && matches != 4){
            rows = 5;
            matches = 0;
            //loop through each row to see if four match
            while(matches != 4 && rows != -1){
                if(connectFourBoard.get(rows*8 + columnNum).equals(playerTurn)){
                    matches++;
                } else{
                    matches = 0;
                }
                rows--;
            }
            columnNum++;
        }
        return (matches == 4);
    }

    /**
     * Checks for four matches horizontally on the Arraylist.
     * @param playerTurn the current player's turn which is checked to see if they won 
     * @return true if four of the player's number is matched horizontally
     * @author Nabhan Anwar
     */
    public boolean checkHorizontal(char playerTurn){
        int rows = 5;
        int matches = 0;
        int columnNum = 0;
        //loop through each rwo until the last or if four matches are found
        while(rows != -1 && matches != 4){
            columnNum = 0;
            matches = 0;
            //loop through each column to see if four match
            while(matches != 4 && columnNum != 7){
                if(connectFourBoard.get(rows*8 + columnNum).equals(playerTurn)){
                    matches++;
                } else{
                    matches = 0;
                }
                columnNum++;
            }
            rows--;
        }
        return (matches == 4);
    }

    /**
     * Checks for four matches diagonally on the Arraylist.
     * @param playerTurn the current player's turn which is checked to see if they won 
     * @return true if four of the player's number is matched diagonally
     * @author Nabhan Anwar
     */
    public boolean checkDiagonal(char playerTurn){
        int row = 0;
        int matches = 0;
        int i = 0;
        //loop to go through the rows and add 1 each time to get the diagonal cell
        while(i < 6 && matches != 4){
            if(connectFourBoard.get(row*8 + i).equals(playerTurn)){
                matches++;
            } else{
                matches = 0;
            }
            row++;
            i++;
        }
        return (matches == 4);        
    }

    @Override
    public String toString() {
        return "connectFourBoard=" + connectFourBoard;
    }

}