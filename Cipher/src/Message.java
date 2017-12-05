/**
 * @author Philip Abangan
 * @version 6 Oct 2017
 * Class Message
 * Contains message, deciphered messaged, and key/n variables with set/get methods.
 * Contains method to calculate the date of Easter.
 * Keep in mind that this Class contains variables to represent two different perspectives of encrypting and decrypting.
 * So there's N array, and Key array which, in the same instance, should contain the same values.
 */
import java.util.Random;

public class Message {
    static private char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '};
    private String m_message; // Message to be communicated.
    private char[] m_DecipheredMessage; // The encryption of the method.
    private char[] m_cipher; // This is the key used to decipher the encrypted message.
    private int[] m_key; // Variable that stores the values used for encryption.

    /**
     * Default constructor
     * Instantiates message, encrypted message, and key array by calling set methods.
     */
    public Message() {
        this.setMessage(null);
        this.setCipher(null);
        this.setKey(null);
    }

    /**
     * Default constructor
     * This constructor takes the message as an argument so that we can initialize the array variables to the correct size.
     * Instantiates message, encrypted message, and key array by calling set methods.
     */
    public Message(String input) {
        this.setMessage(input);
        this.setCipher(input);
        this.setKey(input);
        this.setDecipheredMessage(input);
    }

    /**
     * @return reference to alphabet array.
     */
    public static char[] getAlphabet() {
        return alphabet;
    }

    /**
     * @param check char.
     * Finds the index of the char check in the alphabet.
     * @return position integer that is the index in of that letter in the alphabet.
     * If position = 27, means the char wasn't a space or a letter.
     */
    static private int findPositionInAlph(char check)
    {
        int position = alphabet.length;
        for (int i = 0; i < alphabet.length; i++)
        {
            if (check == alphabet[i])
            {
                position = i;
            }
        }
        return position;
    }

    /**
     * @return m_message.
     */
    public String getMessage() {
        return this.m_message;
    }

    /**
     * @param message
     * converts all letters in message to upper case.
     * m_message is set.
     */
    public void setMessage(String message) {
        String upperCaseMessage = message.toUpperCase(); //This is going to change the message to all lowercase, and store in a temporary variable.
        this.m_message = upperCaseMessage;
    }

    /**
     * @return m_DecipheredMessage.
     */
    public char[] getDecipheredMessage() {
        return this.m_DecipheredMessage;
    }

    /**
     * @param input
     * Instantiates m_message to the length of the deciphered message. This is okay because it is only called in the constructor.
     * m_Decipheredmessage is set.
     */
    public void setDecipheredMessage(String input) {
        int length = input.length();
        this.m_DecipheredMessage = new char[length];
    }

    /**
     * @return m_cipher.
     */
    public char[] getCipher() {
        return this.m_cipher;
    }

    /**
     * @param input
     * Instantiates m_cipher to the length of the message.
     * m_message is set.
     */
    public void setCipher(String input) {
        int length = input.length();
        this.m_cipher = new char[length];
    }

    /**
     * Moves the letter up in the alphabet, by the values in the Key array.
     * It iterates, and does that for each character in the message.
     * The new values are stored in the Cipher Array (encrypted).
     */
    public void encryptMessage() {
        int messageLength = this.getMessage().length();
        int lengthOfAlph = alphabet.length;
        char space = alphabet[26];
        int nonLetter = 27;
        for (int i = 0; i < messageLength; i++) // For each char in the message.
        {
            char charInMessage = this.getMessage().charAt(i); // The char we are going to compare.
            int positionInAlph = findPositionInAlph(charInMessage); // calls method to find the position of the char in the alphabet.
            if (positionInAlph != nonLetter) // If the char is a letter or a space.
            {
                if (charInMessage != space) // If the char is a space.
                {
                    int potNumberToBeAdd = positionInAlph + this.getKey()[i]; //this adds the key value to the position number
                    int actNumberToBeAdd = potNumberToBeAdd;

                    //Checks to see if it moves passed the length of the alphabet.
                    //If it does, it well go back to zero.
                    if (potNumberToBeAdd >= lengthOfAlph)
                    {
                        actNumberToBeAdd = potNumberToBeAdd % lengthOfAlph;
                        actNumberToBeAdd++;
                    }
                    //Because of the space in the array, if we get exactly 26, we have to set it back directly.
                    if (actNumberToBeAdd == 26)
                    {
                        actNumberToBeAdd = 0;
                    }
                    this.m_cipher[i] = alphabet[actNumberToBeAdd];
                }
            } else //If non-letter...
            {
                this.m_cipher[i] = charInMessage;
            }
        }
    }

    /**
     * Uses the key array and subtracts its values from the position (in alphabet) of the Cipher chars.
     * It iterates, and does that for each character in the message.
     * The letter obtained, is stored in decipheredMessage, which is the hidden message.
     */
    public void decryptMessage()
    {
        int cipherLength = this.getCipher().length;
        char space = alphabet[26];
        int nonLetter = alphabet.length;
        //Iterates through the whole cipher.
        for (int i = 0; i < cipherLength; i++) // For each char in the encrypted message.
        {
            //First we need to find the position of the cypher character in the alph.
            char cypherChar = this.getCipher()[i];
            int positionInAlph = findPositionInAlph(cypherChar);

            if (positionInAlph != nonLetter) // If it is a letter or a space.
            {
                if (cypherChar != space) // If it is not a space.
                {
                    // Adding the position in the alphabet to the relative key value to get the position of actual char
                    // in that position of the message.
                    int potNumberToBeSubt = positionInAlph - this.getKey()[i];
                    int actNumberToBeSubt = 0;
                    if (potNumberToBeSubt < 0) // If the potential value to be subtracted is less than zero. Which represent reaching the beginning of the alphabet.
                    {
                        actNumberToBeSubt = 26 + potNumberToBeSubt; // Reset the position to the back of the alphabet.
                    } else //If it didn't extend past the length of the alphabet.
                    {
                        actNumberToBeSubt = potNumberToBeSubt; // Then it is the actual position in the alphabet.
                    }
                    this.m_DecipheredMessage[i] = alphabet[actNumberToBeSubt];
                }
            } else //If non-letter.
            {
                this.m_DecipheredMessage[i] = cypherChar;
            }
        }
    }

    /**
     * @return m_key.
     */
    public int[] getKey() {
        return this.m_key;
    }

    /**
     * @param input
     * Instantiates m_key array to the length of the message.
     * m_key is set.
     */
    public void setKey(String input) {
        int length = input.length();
        this.m_key = new int[length];
    }

    //This creates random values and stores it in key array.
    public void createKey() {
        int messageLength = this.getMessage().length();
        for (int i = 0; i < messageLength; i++)
        {
            Random rand = new Random();
            int n = rand.nextInt(alphabet.length); //Gets an integer within message length.
            this.m_key[i] = n;
        }
    }

    // Prints the message to be communicated to the console.
    public void printMessage() {
        String message = String.format("Message: %s", this.getMessage());
        System.out.println(message);
    }

    // Prints the key array to the console.
    public void printKey() {
        System.out.print("N: ");
        for (int i = 0; i < this.getMessage().length(); i++) {
            System.out.print(this.getKey()[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    // Prints the N array to the console.
    public void printN() {
        System.out.print("Key: ");
        for (int i = 0; i < this.getMessage().length(); i++) {
            System.out.print(this.getKey()[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    // Prints each value in the cipher array to the console.
    public void printEncryption() {
        System.out.print("Cypher Text: ");
        for (int i = 0; i < this.getMessage().length(); i++) {
            System.out.print(this.getCipher()[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    // Prints each value in the deciphered message to the console.
    public void printDecipher() {
        System.out.print("Deciphered Text: ");
        for (int i = 0; i < this.getDecipheredMessage().length; i++) {
            System.out.print(this.getDecipheredMessage()[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    // Calls all methods necessary to encrypt a message, and print it to the console.
    public void doEncryption() {
        //From the instance's message, creates key & encryption.
        this.createKey();
        this.encryptMessage();

        this.printMessage();
        this.printKey();
        this.printEncryption();
    }

    // Calls all the methods necessary to decrypt a encrypted message, and print the information to the console.
    public void doDecryption() {
        //From the instance's message, creates key & encryption.
        this.createKey();
        this.encryptMessage();

        //Decrypts the encryption from the key.
        this.decryptMessage();

        this.printEncryption();
        this.printN();
        this.printDecipher();
    }
}
