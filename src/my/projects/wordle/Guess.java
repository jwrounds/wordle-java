package my.projects.wordle;

public class Guess {

    // takes user input string and converts it into a format suitable to Game and Board classes
    // formats and returns guess and feedback

    private char[] userGuess;
    private String[] feedback;

    public Guess(String userGuess) {
        this.userGuess = userGuess.toUpperCase().toCharArray();
    }

    public char[] getUserGuess() {
        return userGuess;
    }

    public String[] getFeedback() {
        return feedback;
    }

    public void setFeedback(String[] feedback) {
        this.feedback = feedback;
    }
}
