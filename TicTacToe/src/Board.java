import javax.swing.*;
import java.awt.*;

public class Board extends JPanel //This class is just one big jpanel containing the grid
{
    private SingleCell[][] m_cells; // A two-dimensional array of single cells.

    public Board()
    {
        int m_columns = 3;
        int m_rows = 3;
        m_cells = new SingleCell[m_columns][m_rows];
        setLayout(new GridLayout(m_rows,m_columns)); // set JPanel's layout

        // Fills a two-dimensional array with single cell jpanel object, then adds it to the jFrame.
        for(int r = 0; r < m_rows; r++)
        {
            for (int c=0; c< m_columns; c++)
            {
                m_cells[r][c] = new SingleCell(r,c);
                add(m_cells[r][c]);
            }
        }

    }

    public SingleCell[][] getSingleCells() {
        return m_cells;
    }

    public boolean emptyBoard()
    {
        for(int r = 0; r < 3; r++)
        {
            for (int c=0; c< 3; c++)
            {
                if (m_cells[c][r].getSpace() != SingleCell.Components.Empty)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean fullBoard()
    {
        for(int r = 0; r < 3; r++)
        {
            for (int c=0; c< 3; c++)
            {
                if (m_cells[c][r].getSpace() == SingleCell.Components.Empty)
                {
                    return false;
                }
            }
        }
        return true;
    }

}
