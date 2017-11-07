import javax.swing.*;
import java.awt.*;

public class SingleCell extends JPanel
{
    private boolean m_alive;
    private int m_currentColumn;
    private int m_currentRow;

    //Default Constructor
    public SingleCell()
    {
        m_alive = false;
        m_currentColumn = 0; // x-axis.
        m_currentRow = 0; // y-axis.
        this.setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));

    }

    public SingleCell(int column, int row)
    {
        m_alive = false;
        m_currentColumn = column;
        m_currentRow = row;
        this.setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }

    public boolean isAlive() {
        return this.m_alive;
    }

    public void born() {
        this.m_alive = true;
        this.setBackground(Color.BLUE);
    }

    public void dies()
    {
        this.m_alive = false;
        this.setBackground(Color.WHITE);
    }

    public int getCurrentRow() {
        return m_currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.m_currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return m_currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.m_currentColumn = currentColumn;
    }
}
