package connectfour;

//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/* 
Tests are run on build unless specifically excluded with -x test.
The test results are reported in the reports subfolder of the build directory */


public class BoardTest{
    private Board tester;

    @Before
    public void setup(){
        //set up for the test
        tester = new Board();

    }

    @Test
    public void boardIsFull() {
        //Arrange
        setup();
        String words = new String("1222112\n1222112\n1222112\n1222112\n1222112\n1222112\n");
        ArrayList<Character> board = new ArrayList<Character>();
        for(int i = 0; i<words.length(); i++){
            board.add(words.charAt(i));
        }
        tester.setBoard(board);
   

        //Act
        boolean result = tester.isBoardFull();

        //Assert
        assertTrue(result);
    }

    @Test
    public void boardIsNotFull() {
        //Arrange
        setup();
        String words = new String("1220112\n1222100\n1222112\n1222112\n1222112\n1222112\n");
        ArrayList<Character> board = new ArrayList<Character>();
        for(int i = 0; i<words.length(); i++){
            board.add(words.charAt(i));
        }
        tester.setBoard(board);
   

        //Act
        boolean result = tester.isBoardFull();

        //Assert
        assertFalse(result);
    }

    

}