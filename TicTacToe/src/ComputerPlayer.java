import java.awt.*;

public class ComputerPlayer extends Player
{
    public ComputerPlayer(){}

    public ComputerPlayer(SingleCell.Components type)
    {
        super(type);
    }

    @Override
    public int makeMove(Board object, int round)
    {
        m_round = round;
        boolean notMoved = true;
        for(int r = 0; r < 3; r++) // Here I'm trying to add those listening capabilities to each button.
        {
            for (int c=0; c< 3; c++)
            {
                if(object.getSingleCells()[r][c].getSpace()== SingleCell.Components.Empty)
                {
                    if(notMoved)
                    {
                        if (round % 2 == 0)
                        {
                            object.getSingleCells()[r][c].makeX();
                            notMoved=false;
                        }
                        else
                        {
                            object.getSingleCells()[r][c].makeO();
                            notMoved=false;
                        }
                    }
                }
            }
        }
        return m_round+1;
    }

}
