package connectfour;

import java.util.Scanner;

/**
 * The TextUI Class is used for any printing lines required and getting any input from the user.
 * @author Nabhan Anwar
 */
public class TextUI{

    private Scanner input = new Scanner(System.in);
    private Scanner response = new Scanner(System.in);
    private Scanner fileName = new Scanner(System.in); 

    //tells the user that a game has started
    public void welcomeMessage(){
        System.out.println("Started a game of ConnectFour!");
    }

    //tells the user whose turn it is
    public void turnMessage(char turn){
        System.out.println("The turn is now = " + turn);
    }

    //tells the user to input their choice, validates by catching exceptions
    public int getUserInput() throws Exception{
        int playerChoice = -1;
        int i = 0;
        System.out.println("Press 0 to save and exit the game, 8 to exit without saving.");
        System.out.print("Enter column between 1 and 7: ");
        
        //uses a loop to ask user for input until it is a valid input.
        while(i == 0){
            playerChoice = input.nextInt();
            try{
                if(playerChoice > -1 && playerChoice < 9){
                    break;
                } else{
                    throw new Exception();
                }
            } catch (Exception e){
                System.out.print("Input must be between 1 and 8. Try Again: ");
            }
        }
        return playerChoice - 1;
    }

    //tells the users no one won
    public void tieMessage(){
        System.out.println("The game is a tie.");
    }

    //tells the users who won
    public void winMessage(char turn){
        System.out.println("The winner is Player " + turn);
    }

    //asks the user to enter the file name of the file they want to save
    public String saveFileName(){
        String file = "";
        System.out.print("Enter file name to save: ");
        file = fileName.nextLine();

        return file;
    }

    //tells the user that the game has saved and exits program
    public void fileSaved(){
        System.out.println("Game has been saved!");
        System.exit(0);
    }

    //asks the user to enter the file name of the file they want to load 
    public String loadFileName() throws Exception{
        String file = "";
        System.out.print("Enter file name to load from: ");
        file = fileName.nextLine();

        return file;
    }

    //asks the user if they want to load a file, catches exception to validate user input
    public boolean askToLoad() throws Exception{
        System.out.println("Would you like to load a board?");
        char answer = '?';
        int i = 0;
        //uses a loop to ask user for input until it is a valid input.
        while(i == 0){
            try{
                System.out.print("Type Y/N: ");
                answer = response.next().charAt(0);
                if(answer == 'Y' || answer == 'y'){
                    return true;
                } else if(answer == 'N' || answer == 'n'){
                    return false;
                } else{
                    throw new Exception();
                } 
            } catch (Exception e){
                System.out.println("Invalid input. Try again!");
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "TextUI [input=" + input + ", response=" + response + ", fileName=" + fileName + "]";
    }
}