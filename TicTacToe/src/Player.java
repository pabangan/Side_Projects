import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player
{
    static int m_round;
    private SingleCell.Components m_type;

    public Player(){}

    public Player(SingleCell.Components type)
    {
        m_round = 0;
        m_type = type;
    }

    public int makeMove(Board object, int round)
    {
        m_round = round;
        for(int r = 0; r < 3; r++) // Here I'm trying to add those listening capabilities to each button.
        {
            for (int c=0; c< 3; c++)
            {
                object.getSingleCells()[r][c].addActionListener(new ActionX());
            }
        }
        return m_round;
    }

    static class ActionX implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            Object source = e.getSource();
            if (source instanceof SingleCell)
            {
                SingleCell button = (SingleCell) source;
                if (button.getSpace()== SingleCell.Components.Empty)
                {
                    button.makeX();
                    m_round++;
                }
            }
        }
    }

    static class ActionO implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            Object source = e.getSource();
            if (source instanceof SingleCell)
            {
                SingleCell button = (SingleCell) source;
                if (button.getSpace()== SingleCell.Components.Empty)
                {
                    button.makeO();
                    m_round++;
                }
            }
        }
    }

    public boolean winCheck(Board object)
    {
        //Check if won horizontally.
        if (
                object.getSingleCells()[0][0].getSpace() == m_type
                        && object.getSingleCells()[0][1].getSpace() == m_type
                        && object.getSingleCells()[0][2].getSpace() == m_type
                ) {return true;}
        else if(
                object.getSingleCells()[1][0].getSpace() == m_type
                        && object.getSingleCells()[1][1].getSpace() == m_type
                        && object.getSingleCells()[1][2].getSpace() == m_type
                ){return  true;}
        else if(
                object.getSingleCells()[2][0].getSpace() == m_type
                        && object.getSingleCells()[2][1].getSpace() == m_type
                        && object.getSingleCells()[2][2].getSpace() == m_type
                ){return  true;}
        // Check if won vertically.
        else if (
                object.getSingleCells()[0][0].getSpace() == m_type
                        && object.getSingleCells()[1][0].getSpace() == m_type
                        && object.getSingleCells()[2][0].getSpace() == m_type
                ) {return true;}
        else if(
                object.getSingleCells()[0][1].getSpace() == m_type
                        && object.getSingleCells()[1][1].getSpace() == m_type
                        && object.getSingleCells()[2][1].getSpace() == m_type
                ){return  true;}
        else if(
                object.getSingleCells()[0][2].getSpace() == m_type
                        && object.getSingleCells()[1][2].getSpace() == m_type
                        && object.getSingleCells()[2][2].getSpace() == m_type
                ){return  true;}
        // Check if won Diagonally.
        else if(
                object.getSingleCells()[0][0].getSpace() == m_type
                        && object.getSingleCells()[1][1].getSpace() == m_type
                        && object.getSingleCells()[2][2].getSpace() == m_type
                ){return  true;}
        else if(
                object.getSingleCells()[0][2].getSpace() == m_type
                        && object.getSingleCells()[1][1].getSpace() == m_type
                        && object.getSingleCells()[2][0].getSpace() == m_type
                ){return  true;}
        else
        {
            return false;
        }
    }

    public boolean isDraw(Board object) {
        for (int r = 0; r < 3; ++r) {
            for (int c = 0; c < 3; ++c) {
                if (object.getSingleCells()[r][c].getSpace() == SingleCell.Components.Empty)
                {
                    return false; // an empty cell found, not a draw, exit
                }
            }
        }
        return true; // no empty cell, it's a draw
    }
}
