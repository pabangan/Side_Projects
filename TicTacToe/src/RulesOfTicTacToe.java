import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class RulesOfTicTacToe extends JFrame {
    static Board m_space;
    static int round;
    final int m_columns = 3;
    final int m_rows = 3;
    // Making a Polymorphic array.
    private Player players[] = new Player[2];

    public RulesOfTicTacToe() {
        super("Phil's Fancy TicTacToe");
        round = 0;
        m_space = new Board();

        System.out.println("How many Players are playing?");
        Scanner s = new Scanner(System.in);

        boolean validInput = false;
        int n = 0;
        while (!validInput) {
            n = s.nextInt();
            if (n < 0 || n > 2) {
                System.out.println("Not a valid input. Choose 0, 1, or 2");
            } else {
                validInput = true;
            }
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(500, 500));
        add(m_space);
        setLocationByPlatform(true);
        setVisible(true);

        PlayerGame(n);
    }

    public void PlayerGame(int n)
    {
        System.out.println("Should print out TWO player game only.");

        if (n == 0)
        {
            System.out.println("Number of players playing is: " + n);
            players[0] = new ComputerPlayer(SingleCell.Components.X);
            players[1] = new ComputerPlayer(SingleCell.Components.O);
        }
        else if (n == 1)
        {
            System.out.println("Number of players playing is: " + n);
            players[0] = new HumanPlayer(SingleCell.Components.X);
            players[1] = new ComputerPlayer(SingleCell.Components.O);
        }
        else
        {
            System.out.println("Number of players playing is: " + n);
            players[0] = new HumanPlayer(SingleCell.Components.X);
            players[1] = new HumanPlayer(SingleCell.Components.O);
        }
        JFrame frame = new JFrame("Status");
        frame.setSize(100,100);
        JLabel label = new JLabel();
        boolean inside = true;
        while (inside)
        {
            if (round % 2 == 0)
            {
                round  = players[0].makeMove(m_space, round);
            }
            else
            {
                round = players[1].makeMove(m_space, round);
            }
            if (players[0].winCheck(m_space))
            {
                System.out.println("Player 1 WINS!!!");
                label.setText("Player 1 WINS!!!");
                inside=false;
            }
            else if(players[1].winCheck(m_space))
            {
                label.setText("Player 2 WINS!!!");
                inside=false;
            }
            else if (m_space.fullBoard())
            {
                label.setText("It's a Draw!!!");
                inside = false;
            }
        }
        JPanel panel = new JPanel();
        panel.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

