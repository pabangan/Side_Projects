/**
 * @author Philip Abangan
 * @version 26 November 2017
 * Money class that contains methods for printing the value as words.
 */
public class Money {
    private double m_money; // Holds the total amount as a double.
    private int m_digit0; // Holds the Hundreds integer.
    private int m_digit1; // Holds the Tens integer.
    private int m_digit2; // Holds the Ones integer.
    private int m_cents; // Holds the Decimal integers.

    public Money(double value) {
        m_money = Math.round(value * 100.0) / 100.0; // This rounds the number to the correct decimal places needed.

        // Initializing cents variable.
        double temp = m_money % 1 * 100;
        m_cents = (int) temp;

        // Initializing the hundred digit variable.
        temp = m_money - m_money % 100;
        m_digit0 = (int) temp / 100;

        //Initializing the ten digit.
        double temp2 = m_money - m_money % 10 - m_digit0 * 100;
        temp = temp2 / 10;
        m_digit1 = (int) temp;

        // Initializing the first digit.
        temp = m_money - m_digit0 * 100 - m_digit1 * 10 - m_cents / 100;
        m_digit2 = (int) temp;
    }

    /**
     * Get method for total money value.
     * @return m_money.
     */
    public double getMoney() {
        return m_money;
    }

    /**
     * Prints the money value rounded, and with money symbol.
     */
    public void printMoneyValue() {
        System.out.print(java.text.NumberFormat.getCurrencyInstance().format(getMoney()));
    }

    /**
     * Prints the m_cents to the system console.
     */
    public void printdigit() {
        System.out.print(m_cents);
    }

    /**
     * Method for printing the money value as words.
     */
    public void printTotalValue() {
        String total = null; // Container for holding the total word value.

        // If the hundred digit is greater than 0, print "0" then "hundred".
        if (m_digit0 > 0) {
            total = printSingleValue(m_digit0) + " hundred ";
        }

        /*
         * If the sum of ten and ones digit is greater than 0, then call print2Digit method.
         *  Also add it to the total string.
         */
        int temp = m_digit1 * 10 + m_digit2;
        if (temp > 19) {
            total = total + print2DigitValue(m_digit1) + " ";
            if (m_digit2 > 0) {
                total = total + printSingleValue(m_digit2);
            }
        }

        //Else(if the ten digit is 0) print out just the ones digit.
        else {
            if (temp > 0) {
                total = total + printSingleValue(temp);
            }
        }
        total = total + " and ";
        total = total + m_cents + "/100";
        System.out.println();
        System.out.printf("Word Value: %s", total);
    }

    /**
     * Method for printing the value of the ones digit.
     * Will only be called if the sum of tens and ones is less than 20.
     *
     * @param value is used to check which word String to use.
     * @return word.
     */
    private String printSingleValue(int value) {
        String word = "";
        switch (value) {
            case 0:
                word = "ZERO";
                break;
            case 1:
                word = "ONE";
                break;
            case 2:
                word = "TWO";
                break;
            case 3:
                word = "THREE";
                break;
            case 4:
                word = "FOUR";
                break;
            case 5:
                word = "FIVE";
                break;
            case 6:
                word = "SIX";
                break;
            case 7:
                word = "SEVEN";
                break;
            case 8:
                word = "EIGHT";
                break;
            case 9:
                word = "NINE";
                break;
            case 10:
                word = "TEN";
                break;
            case 11:
                word = "ELEVEN";
                break;
            case 12:
                word = "TWELVE";
                break;
            case 13:
                word = "THIRTEEN";
                break;
            case 14:
                word = "FOURTEEN";
                break;
            case 15:
                word = "FIFTEEN";
                break;
            case 16:
                word = "SIXTEEN";
                break;
            case 17:
                word = "SEVENTEEN";
                break;
            case 18:
                word = "EIGHTEEN";
                break;
            case 19:
                word = "NINETEEN";
                break;
        }
        return word;
    }

    /**
     * Method for returning the word String of the value
     * Should only be called if the ones and tens digits sum up to greater than 19.
     *
     * @param value is used to see which should be the word String value.
     * @return word.
     */
    private String print2DigitValue(int value) {
        String word = "";
        switch (value) {
            case 2:
                word = "TWENTY";
                break;
            case 3:
                word = "THIRTY";
                break;
            case 4:
                word = "FORTY";
                break;
            case 5:
                word = "FIFTY";
                break;
            case 6:
                word = "SIXTY";
                break;
            case 7:
                word = "SEVENTY";
                break;
            case 8:
                word = "EIGHTY";
                break;
            case 9:
                word = "NINETY";
                break;
        }
        return word;
    }


}
