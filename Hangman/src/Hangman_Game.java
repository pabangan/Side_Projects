import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author Philip Abangan
 * @version 6 Oct 2017
 * Hangman_game contains components necessary for a game of hangman.
 * The paintComponent create a graphic that resembles a hanging stick figure, depending on the value of currentImagePos
 */
public class Hangman_Game extends JPanel
{
    private int m_currentImagePos; // Counter used to print the correct graphic.
    private int m_letterLeftToGuess; // Counter of the letter in the word, that haven't been guessed yet.
    private int m_round; //Way to know the beginning, during, and end of the game.
    private char[] m_incorrectGuesses;
    private String m_gameRules; // Contains a String of a few different pieces of information.
    private int m_remainingGuesses; //Number of guesses left
    private char[] m_allGuessed; // All the letters guessed so far.
    private int m_numLetters; // This is the number of letters in the word.
    private String m_word;
    private char [] m_correctGuesses; //This is an array of underscores and correctly guessed letters.
    /**
     * Default constructor
     * Instantiates the word, and dependent variables to the default = "hangman".
     *
     */
    public Hangman_Game()
    {
        this.m_round = -1;
        this.setWord("hangman");
        this.m_incorrectGuesses = new char[6];
        Arrays.fill(m_incorrectGuesses,' ');
        this.m_remainingGuesses = 6;
        this.setNumLetters(this.getWord().length());
        this.m_letterLeftToGuess = this.getWord().length();
        this.m_currentImagePos = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.LIGHT_GRAY);
        g.drawLine(100, 300, 100, 50); // main wood piece
        g.drawLine(200, 50, 100, 50); //Top wood piece
        g.drawLine(200, 100, 200, 50); //rope connected to head
        g.drawRect(50, 300, 100, 50); // This is the post foundation
        if(this.getCurrentImagePos()>0)
        {
            g.drawOval(175, 100, 50, 50); // Head
            if(this.getCurrentImagePos()>1)
            {
                g.drawLine(200, 200, 200, 150); // Main
                if(this.getCurrentImagePos()>2)
                {
                    g.drawLine(150, 150, 200, 175); // left arm
                    if(this.getCurrentImagePos()>3)
                    {
                        g.drawLine(250, 150, 200, 175); //Right arm
                        if(this.getCurrentImagePos()>4)
                        {
                            g.drawLine(200, 200, 150, 250); // left leg
                            if(this.getCurrentImagePos()==6)
                            {
                                g.drawLine(200, 200, 250, 250); // Right leg
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * @return m_currentImagePos.
     */
    public int getCurrentImagePos() {
        return m_currentImagePos;
    }

    /**
     * @param currentImagePos is set to.
     */
    public void setCurrentImagePos(int currentImagePos) {
        this.m_currentImagePos = currentImagePos;
    }

    // Increments m_currentImage pos.
    public void nextHangmanImage()
    {
        if (this.getCurrentImagePos() < 7) // If current image position is less than or equal to the number of different graphics(6)
        {
            this.m_currentImagePos++;
        }
    }

    /**
     * @return m_letterLeftToGuess.
     */
    public int getLetterLeftToGuess() {
        return m_letterLeftToGuess;
    }

    /**
     * @param letterLeftToGuess is set to m_letterLeftToGuess.
     */
    public void setLetterLeftToGuess(int letterLeftToGuess) {
        this.m_letterLeftToGuess = letterLeftToGuess;
    }

    // Subtracts one from the number of guesses left.
    public void subtLetterLeftToGuess() {
        this.m_letterLeftToGuess--;
    }

    /**
     * @return m_round.
     */
    public int getRound() {
        return m_round;
    }

    /**
     * @param round is set to m_round.
     */
    public void setRound(int round)
    {
        this.m_round = round;
    }

    // Adds to round by one.
    public void addRound() {
        this.m_round++;
    }

    /**
     * @return reference to an array of type char named m_incorrectGuesses.
     */
    public char[] getIncorrectGuesses() {
        return m_incorrectGuesses;
    }

    /**
     * @param incorrectGuesses is set to m_incorrectGuesses.
     */
    public void setIncorrectGuesses(char[] incorrectGuesses)
    {
        this.m_incorrectGuesses = incorrectGuesses;
    }

    // Add the incorrect guess to an array storing all the incorrectly guessed chars.
    public void addIncorrectGuess(char badGuess)
    {
        this.m_incorrectGuesses[6 - this.getRemainingGuesses()] = badGuess;
    }

    /**
     * @return m_gameRules.
     * This also checks to see if the see if anyone won or lost, if so, m_gamerules is assigned to a String with a different value.
     */
    public String getGameRules()
    {
        // Using Html to center jlabel, since jlabel doesn't read line breaks.
        StringJoiner combinedData = new StringJoiner("<br><br>", "<html>", "</html>");
        String status = "";
        if(this.getRound()>99)
        {
            if (this.getLetterLeftToGuess()==0)
            {
                status = "won!";
            }
            else if(this.getRemainingGuesses()==0) //lose if
            {
                status = "lost.";
            }
            combinedData.add("You " + status).add("The word was: " + this.getWord());
        }
        else
        {
            combinedData.add(displayUnderscores(getCorrectGuesses())).add(displayRemainingGuesses()).add(displayIncorrectGuesses());
        }
        m_gameRules = combinedData.toString();
        return m_gameRules;
    }

    /**
     * @param  gameRules is set to m_gameRules.
     */
    public void setGameRules(String gameRules) {
        this.m_gameRules = gameRules;
    }

    /**
     * Combines several strings into a single string.
     * @return combinedData
     */
    public String displayRemainingGuesses()
    {
        StringJoiner combinedData = new StringJoiner(" ");
        combinedData.add("Remaining Guesses: " + this.getRemainingGuesses());
        return combinedData.toString();
    }

    /**
     * Combines several strings into a single string.
     * @return combinedData
     */
    public String displayIncorrectGuesses()
    {
        StringJoiner combinedData = new StringJoiner(" ");
        combinedData.add("Incorrect Guesses: " + this.displayUnderscores(this.getIncorrectGuesses()));
        return combinedData.toString();
    }

    /**
     * @return m_remainingGuesses.
     */
    public int getRemainingGuesses() {
        return m_remainingGuesses;
    }

    /**
     *
     * @param remainingGuesses is set to m_remainingGuesses
     */
    public void setRemainingGuesses(int remainingGuesses) {
        this.m_remainingGuesses = remainingGuesses;
    }

    /**
     *
     * @param input is the wrongly guessed char
     * This method of actions taken if the guess is wrong.
     * adds input to allguessed, and incorrectGuess by method calls.
     * Adds the round, and subtracts from remaining guesses.
     */
    public void wrongGuess(char input)
    {
        this.m_allGuessed[this.getRound()] = input;
        this.addRound();
        this.addIncorrectGuess(input);
        this.m_remainingGuesses--;
    }

    /**
     *
     * @return m_allGuessed.
     */
    public char[] getAllguessed()
    {
        return this.m_allGuessed;
    }

    /**
     *
     * @return m_numLetters.
     */
    public int getNumLetters() {
        return m_numLetters;
    }

    /**
     *
     * @param numLetters set to m_numLetters.
     */
    public void setNumLetters(int numLetters)
    {
        this.m_numLetters = numLetters;
    }

    /**
     *
     * @return m_word.
     */
    public String getWord() {
        return m_word;
    }

    /**
     *
     * @param word is set to m_word.
     * Method is called when user inputs a word to be guessed.
     * Also initializes variables that depend on the word; numLetters, array variable memory allocations.
     */
    public void setWord(String word)
    {
        this.addRound();
        this.setLetterLeftToGuess(word.length());
        this.m_word = word;
        int numLetters = word.length();
        if(numLetters > 0) // If the word exists
        {
            int tempNumLetters = numLetters*2-1;
            this.m_correctGuesses = new char[tempNumLetters]; // initialize the array of underscores/spaces to double the word length.
            int i=0;
            // For the whole underscores array, fill the array with underscores, and spaces.
            while (i<tempNumLetters)
            {
                this.m_correctGuesses[i] = '_';
                if(i+1 < tempNumLetters)
                {
                    this.m_correctGuesses[i+1] = ' ';
                }
                i = i+2;
            }
        }
        this.m_allGuessed = new char[this.getNumLetters()+6];
    }

    /**
     *
     * @return m_correctGuesses.
     */
    public char[] getCorrectGuesses()
    {
        return this.m_correctGuesses;
    }

    /**
     *
     * @param correctGuesses set to m_correctGuesses.
     */
    public void setCorrectGuesses(char[] correctGuesses) {
        this.m_correctGuesses = correctGuesses;
    }

    /**
     *
     * @param arrayA a reference to an array of chars.
     * @return arrayA as a String.
     */
    public String displayUnderscores(char [] arrayA)
    {
        return new String(arrayA);
    }

    // Checks to see if the words contains the letter guessed.
    public boolean check(String letter)
    {
        return this.getWord().contains(letter);
    }

    //If it is a letter and hasn't been guessed before.
    public boolean isValidGuess(String guessS)
    {
        boolean validGuess = true;
        if (!guessS.equals("")) //if not empty.
        {
            char guess = guessS.charAt(0);
            if (Character.isLetter(guess)) // if it's a letter.
            {
                for (int n=0; n<this.getAllguessed().length; n++)
                {
                    if (guess == this.getAllguessed()[n]) //compare each letter to see if it's been guessed before.
                    {
                        validGuess = false;
                    }
                }
            }
            else
            {
                validGuess = false;
            }
        }
        else
        {
            validGuess = false;
        }
        return validGuess;
    }

    /**
     *
     * @param input
     * replaces the underscore with the letter that was guessed correctly; input.
     */
    public void replaceUnderscores(String input)
    {
        char inputChar = input.charAt(0);
        this.m_allGuessed[this.getRound()] = inputChar;
        this.addRound();
        for (int i=0; i<this.m_word.length(); i++)  //n is the current position of the in the word answer.
        {
            if (inputChar == this.getWord().charAt(i))
            {
                this.m_correctGuesses[i*2] = inputChar;
                this.subtLetterLeftToGuess();
            }
        }
    }
    /**
     *
     * @param input String to be modified.
     * @return extraction of all non-letters and converts to upper case.
     */
    public String extractNonLetters(String input)
    {
        String extract = input.replaceAll("[^a-zA-Z]+", "");
        return extract.toUpperCase();
    }

    /**
     * Checks the instance to see the game has been won or lost.
     * If the game is over, set the round to 100.
     */
    public void winOrLose()
    {
        // WIn if
        if (this.getLetterLeftToGuess()==0)
        {
            this.setRound(100);
        }
        else if(this.getRemainingGuesses()==0) //lose if
        {
            this.setRound(100);
        }
    }

} // END CLASS HANGMAN_GAME
