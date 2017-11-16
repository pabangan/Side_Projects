import javax.swing.*;
import java.awt.*;

public class SingleCell extends JButton
{
    private Components m_space;
    private int m_currentColumn;
    private int m_currentRow;

    public SingleCell()
    {
        m_space = Components.Empty;
        m_currentColumn = 0;
        m_currentRow = 0;

        setBackground(Color.BLACK);
        setSize(new Dimension(100,100));
    }

    public SingleCell(int column, int row)
    {
        m_space = Components.Empty;
        m_currentRow = row;
        m_currentColumn = column;

        setBackground(Color.BLACK);
        setSize(new Dimension(100,100));
    }

    public int getCurrentColumn() {
        return m_currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.m_currentColumn = currentColumn;
    }

    public int getCurrentRow() {
        return m_currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.m_currentRow = currentRow;
    }

    public void makeX()
    {
        if(this.getSpace()==Components.Empty)
        {
            m_space = Components.X;
            this.setBackground(Color.BLUE);
        }
    }

    public void makeO()
    {
        if(this.getSpace()==Components.Empty)
        {
            m_space = Components.O;
            this.setBackground(Color.RED);
        }
    }

    public Components getSpace()
    {
        return m_space;
    }

    public enum Components
    {
        Empty, X, O
    }
}
