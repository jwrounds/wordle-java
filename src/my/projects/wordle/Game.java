package my.projects.wordle;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {

    // governs core game logic and flow
    // on a given turn:
        // requests user input
            // pass input to Guess class
        // determines guess feedback
            // passes guess with feedback to Board class
            // calls on Board class to display guess with feedback to user
    // repeat above steps until maximum guesses met or guess is correct
    private boolean gameWon = false;
    private int turn = 1;
    private final ArrayList<Character> word;
    private Board gameBoard;

    public Game(String word) {
        this.gameBoard = new Board();
        this.word = word.toUpperCase().chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(ArrayList::new));
    }

    public Guess checkGuess(String guess) {
        Guess guessWithFeedback = new Guess(guess);
        char[] guessArray = guessWithFeedback.getUserGuess();
        String[] guessFeedback = new String[5];
        int greenCount = 0;

        for (int i=0; i < 5; i++) {
            Character guessChar = guessArray[i];

            if (guessChar.equals(word.get(i))) {
                guessFeedback[i] = "grn";
                greenCount++;
            } else if (word.contains(guessChar)) {
                guessFeedback[i] = "ylw";
            } else {
                guessFeedback[i] = "red";
            }
        }

        if (greenCount == 5) gameWon = true;

        guessWithFeedback.setFeedback(guessFeedback);
        return guessWithFeedback;
    }

    public void printBoard() {
        this.gameBoard.displayBoard();
    }

    public void runTurn() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Please enter your guess:");
        String input = scn.nextLine();

        while (input.length() != 5) {
            System.out.println("Please enter a 5 letter word!");
            input = scn.nextLine();
        }

        Guess newGuess = checkGuess(input);
        gameBoard.addGuessAndFeedback(newGuess, turn);

        printBoard();
        turn++;
    }

    public void runGame() {
        while (turn <= 6) {
            if (gameWon) {
                System.out.println("\nGreat job!");
                return;
            }

            runTurn();
        }
    }
}
