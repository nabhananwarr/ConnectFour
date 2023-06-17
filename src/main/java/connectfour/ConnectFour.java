package connectfour;

import java.util.ArrayList;

/**
 * The ConnectFour Class is the central part of the program
 * The main method of the ConnectFour class uses objects of other classes to call their methods
 * @author Nabhan Anwar
 */
public class ConnectFour{

    /**
     * This method checks whose turn is it, then switches the turn
     * @param turn
     * @return The updated turn
     * @author Nabhan Anwar
     */
    public char setTurn(char turn) {
        if (turn == '1') {
            turn = '2';
        } else {
            turn = '1';
        }
        return turn;
    }

    public static void main(String[] args) throws Exception{
        //objects of other classes to use methods
        StringBuilder boardMaker = new StringBuilder();   
        TextUI message = new TextUI();
        Board game = new Board();
        ConnectFour player = new ConnectFour();
        FileLoad load = new FileLoad();
        FileSave save = new FileSave();

        char playerTurn = '2';
        int playerChoice = 0;
        ArrayList<Character> gameBoard = new ArrayList<Character>();

        //start message and initializing the board 
        message.welcomeMessage();
        boardMaker.makeBoard(gameBoard);

        //ask user if they want to load a game, if yes, then ask for the filename and load if found
        if(message.askToLoad()){
            load.fileReader(message.loadFileName());
            gameBoard = load.readTheFile();
        }
        //upadates the board to the Board class and prints it
        game.setBoard(gameBoard);
        boardMaker.printBoard(gameBoard);

        //loop to keep the game running 
        while(playerChoice != 7){

            //sets turn and asks for user input
            playerTurn = player.setTurn(playerTurn); 
            message.turnMessage(playerTurn);
            playerChoice = message.getUserInput();

            //if player enters 0, the game saves and exits
            if(playerChoice == -1){
                save.fileWriter(message.saveFileName());
                save.writeLinesToFile(gameBoard);
                message.fileSaved();
            }
            //fills the column entered, retrieves board and prints it, then checks for winner
            game.fillCell(playerChoice, playerTurn);
            gameBoard = game.getBoard();
            boardMaker.printBoard(gameBoard);

            game.checkWinner(playerTurn);
        }
        System.out.println("Game has exited.");
    }
}