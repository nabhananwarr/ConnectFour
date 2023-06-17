package connectfour;

import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.io.IOException; 

/**
 * This class is for saving the board onto a file in the assets folder, converting the board to string first
 * @author Nabhan Anwar
 */
public class FileSave {

    private Path path;

    //method that sets the path of the file
    public void fileWriter(String fileName){
        path = FileSystems.getDefault().getPath("assets", fileName);
    }
        
    //writes the conents of the board onto a file
    public void writeLinesToFile(ArrayList<Character> board){
        //converts Arraylist to string using a loop and then attemtps to write it onto the file
        String stringOfBoard = new String();
        for(int i = 0; i < board.size(); i++){
            stringOfBoard += board.get(i);
        }
        try{
            Files.writeString(path, stringOfBoard);
        }catch(IOException e){
            //prints this line in case somethind goes wrong
            System.out.println("Failed to save to file.");
        }
    }
}
