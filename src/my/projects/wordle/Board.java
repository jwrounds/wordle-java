package my.projects.wordle;

// Sample Board Display

// 1 |_G_|_U_|_E_|_S_|_S_|
//    red grn ylw ylw grn
// 2 |_R_|_U_|_L_|_E_|_S_|
//    grn grn grn grn grn
// 3 |___|___|___|___|___|
//
// 4 |___|___|___|___|___|
//
// 5 |___|___|___|___|___|
//
// 6 |___|___|___|___|___|
//

public class Board {

    // display guesses and feedback

    private final String[][] gameDisplay = new String[6][2];

    public Board() {
        buildBoard();
    }

    private void buildBoard() {
         for (int i=0; i < 6; i++) {
             gameDisplay[i][0] = i+1 + "|___|___|___|___|___|";
             gameDisplay[i][1] =  " ";
        }
    }

    public void addGuessAndFeedback(Guess guess, int guessNumber) {
        char[] guessChars = guess.getUserGuess();
        String[] guessFeedback = guess.getFeedback();

        gameDisplay[guessNumber-1][0] = String.format("%d |_%s_|_%s_|_%s_|_%s_|_%s_|", guessNumber,
                                                                                        guessChars[0],
                                                                                        guessChars[1],
                                                                                        guessChars[2],
                                                                                        guessChars[3],
                                                                                        guessChars[4]);

        gameDisplay[guessNumber-1][1] = String.format("   %s %s %s %s %s", guessFeedback[0],
                                                                            guessFeedback[1],
                                                                            guessFeedback[2],
                                                                            guessFeedback[3],
                                                                            guessFeedback[4]);

    }

    public void displayBoard() {
        for (String[] row : gameDisplay) {
            for (String guess : row) {
                System.out.println(guess);
            }
        }
    }

}
