import java.util.Scanner;

/**
 * @author Philip Abangan
 * @version 6 Oct 2017
 * Prompts user.
 * Creates new object.
 * Calls the doEncryption method.
 *
 * Given that the message, "Meet Me At Three!" is previously encrypted.
 * Using the key values and encrypted message, decrypt the message.
 */
public class EncryptionTest
{
    public static void main(String[] args)
    {
        //Prompt the user to input a message
        Scanner input = new Scanner(System.in);
        System.out.println("Enter message to be coded: ");
        String inputMessage = input.nextLine();
        Message Uncrypted = new Message(inputMessage);
        Uncrypted.doEncryption();

        //Now this is my program that decrypts a cipher text.
        System.out.println();
        System.out.println("Decryption Program");
        String secretMessage = "Meet me at three!";
        Message Encrypt = new Message(secretMessage);
        Encrypt.doDecryption();
    }
}
