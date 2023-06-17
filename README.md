# Project Title
ConnectFour Game

A simple overview of use/purpose.
The purpose of the program is to allow players to play ConnectFour, where you have to match four of your numbers on the board against another player on the same computer.

## Description

An in-depth paragraph about your project and overview of use.
This object-oriented project is a ConnectFour simulator that allows users to play ConnectFour. The board is set as an ArrayList of characters. The main method of the ConnectFour class uses objects of other classes to call their methods. The Board class handles the changes in the board and checks the conditions for the winner. The StringBuilder class is in charge of making the board at the start of the game and printing the board whenever needed. The FileSave class allows the players to save the game anytime they want to a file with their desired file name. The FileLoad class allows the players to start the game with a board from a file of their choice, which must be in the assets folder. The TextUI Class is used for any printing lines required and getting any input from the user. The board is a 7x6 grid. It starts with player 1, they must input a number between 1 to 7 to set where they want to place their letter, or 0 to quit, 8 to save and quit. The board is updated and printed back. The next person, player 2, has the option to do the same. The game goes on until either player matches their letters in a straight line (vertically, horizontally, or diagonally) four times consecutively. Whoever matches four of their letter in a line first wins. If no one matches their letter in a straight line and all blocks are occupied, then the game ends as a tie.

## Getting Started

### Dependencies

* Describe any prerequisites, libraries, OS version, etc., needed before installing and running your program.


The program should run on Windows, Mac, and Linux computers. It can be run in the terminal after gradle build and run. Java must be installed on your computer. The program uses imports from java.util.

### Executing program

* How to build and run the program
* Step-by-step bullets
```
use code blocks for commands
-First, cd into the A1 folder, 
-Next build and run using the following commands:
    >gradle build
    >gradle run
-Then, copy the line that is output from gradle run. It should read:
    >java -cp build/classes/java/main connectfour.ConnectFour
```
* include the expected output
The program should build and run without errors. The program starts by saying "Started a game of ConnectFour!" and prints the 7x6 board. It prompts the user to load a board, where they can type 'y' or 'n' (yes or no). If they pick yes, they must type the file name, the file must be in the assets folder. It indicates the turn starts with player 1 as it will print "The turn is now = 1" and then ask for user input between 0 and 8. After appropriate input, the board will be updated, and printed again, and it will print "Turn = 2" unless 0 is entered, which ends the game, or 8, which asks the user to input a file name for the game to save it and then exits the game. This is repeated until a player wins, is a tie, or the game exited or is saved and exited.
Tests are run on build unless specifically excluded with -x test. The test results are reported in the reports subfolder of the build directory.

## Limitations

What isn't done? What things cause errors?  
Errors are handled, however, entering alphabets or symbols for user input on their turn causes an exception as it is only validated for numerical values. The diagonal matches aren't fully functional, some diagonals do not win you the game.

## Author Information

Your name and contact information including your email address
Nabhan Anwar, 437-984-8842, nanwar@uoguelph.ca

## Development History

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)
* University of Guelph CIS2430 2022 course content 
