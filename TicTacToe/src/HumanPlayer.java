import java.awt.*;

public class HumanPlayer extends Player
{
    public HumanPlayer(){}

    public HumanPlayer(SingleCell.Components type)
    {
        super(type);
    }

    @Override
    public int makeMove(Board object, int round)
    {
        m_round = round;
        for(int r = 0; r < 3; r++) // Here I'm trying to add those listening capabilities to each button.
        {
            for (int c=0; c< 3; c++)
            {
                object.getSingleCells()[r][c].addActionListener(new ActionX());
                if (round % 2 == 0)
                {
                    object.getSingleCells()[r][c].addActionListener(new ActionX());
                }
                else
                {
                    object.getSingleCells()[r][c].addActionListener(new ActionO());
                }
            }
        }
        return m_round;
    }
}
