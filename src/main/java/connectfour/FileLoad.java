package connectfour;

import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.io.IOException; 

/**
 * This class is for loading the board onto a file, converting from string to ArrayList
 * @author Nabhan Anwar
 */
public class FileLoad {
    private StringBuilder aBoard = new StringBuilder(); 
    private Path path;

    //method that sets the path of the file
    public void fileReader(String filename){
        path = FileSystems.getDefault().getPath("assets", filename);
    }

    //reads the contents of the file and returns the board to load
    public ArrayList<Character> readTheFile(){
        ArrayList<Character> loadBoard = new ArrayList<Character>();
        String lines = null;
        try{
            //turns string into arraylist for the board
            lines = Files.readString(path);
            aBoard.makeBoard(loadBoard, lines);
        }catch(IOException e){
            System.out.println("Could not load because it is an invalid file. Run the program again.");
            System.exit(0);
        }
        return loadBoard;
    }

}
