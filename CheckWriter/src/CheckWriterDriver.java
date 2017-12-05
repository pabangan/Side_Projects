import java.util.Scanner;

/**
 * @author Philip Abangan
 * @version 26 November 2017
 * Driver class that prompts the user for an input and prints out the word equivalent.
 */
public class CheckWriterDriver {
    public static void main(String[] args) {
        boolean check = true; // true if the input is NOT between 0-1000.
        while (check) // While the input is not between 0-1000.
        {
            System.out.println("Enter a currency amount between 0.00 and 1000.00");
            System.out.print("Amount: ");

            Double currency = 0.0;
            Scanner input = new Scanner(System.in);
            currency = input.nextDouble(); // Storing input into a double variable.

            if ((currency > 0.0) && (currency < 1000.00)) {
                Money roundOff = new Money(currency); // Creates new Money object.
                System.out.println();
                System.out.print("Money Value = ");
                roundOff.printMoneyValue(); // prints the value with money symbol.
                roundOff.printTotalValue(); // prints the value as a words.
                check = false;
            }
        }
    }
}
