package connectfour;

import java.util.ArrayList;

//this class is for making the board at the start and printing the board any time
public class StringBuilder {
    
    private String baseString = new String("0000000\n0000000\n0000000\n0000000\n0000000\n0000000");

    //setting up the board for the start of the game 
    public void makeBoard(ArrayList<Character> theBoard){
        for (int i = 0; i < baseString.length(); i++){
            theBoard.add(baseString.charAt(i));
        }
    }

    public void makeBoard(ArrayList<Character> theBoard, String differentString){
        for (int i = 0; i < differentString.length(); i++){
            if(differentString.charAt(i) == ',' || differentString.charAt(i) == ' '){
                continue;
            }
            theBoard.add(differentString.charAt(i));
        }
    }

    //printing the the board from an ArrayList appropriately.
    public void printBoard(ArrayList<Character> theBoard){
        for(int i = 0; i < baseString.length(); i++){
            System.out.print(theBoard.get(i));
        }
        System.out.println("");
    }

}
