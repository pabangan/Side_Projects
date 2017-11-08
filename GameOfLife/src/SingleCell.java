import javax.swing.*;
import java.awt.*;

/**
 * @author Philip Abangan
 * @version 8 November 2017
 * Class that stores information pertaining to an individual cell, supposed to be in a grid.
 * Contains variables to store if it's alive, and it's location.
 */
public class SingleCell extends JPanel
{
    private boolean m_alive; // m_alive stores if it's alive or not.
    private int m_currentColumn; // m_currentColumn & m_currentRow store it's location.
    private int m_currentRow;

    /**
     * Default Constructor
     * Automatically initializes the cell to dead: m_alive = false, and color = white.
     */
    public SingleCell()
    {
        m_alive = false;
        m_currentColumn = 0; // x-axis.
        m_currentRow = 0; // y-axis.
        this.setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));

    }

    /**
     * Double parameter constructor.
     * @param column is set to m_currentColumn.
     * @param row is set to m_currentRow.
     */
    public SingleCell(int column, int row)
    {
        m_alive = false;
        m_currentColumn = column;
        m_currentRow = row;
        this.setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }

    /**
     * Alive get method.
     * @return m_alive.
     */
    public boolean isAlive() {
        return this.m_alive;
    }

    /**
     * Method to make the cell alive.
     * m_alive is set to true.
     * color is set to Blue.
     */
    public void born() {
        this.m_alive = true;
        this.setBackground(Color.BLUE);
    }

    /**
     * Method to make the cell dead.
     * m_alive is set to dead.
     * Color is set to White.
     */
    public void dies()
    {
        this.m_alive = false;
        this.setBackground(Color.WHITE);
    }

    /**
     * Row get method.
     * @return m_currentRow.
     */
    public int getCurrentRow() {
        return m_currentRow;
    }

    /**
     * Row set method.
     * @param currentRow is set to m_currentRow.
     */
    public void setCurrentRow(int currentRow) {
        this.m_currentRow = currentRow;
    }

    /**
     * Column get method.
     * @return m_currentColumn.
     */
    public int getCurrentColumn() {
        return m_currentColumn;
    }

    /**
     * Column set method.
     * @param currentColumn is set to m_currentColumn.
     */
    public void setCurrentColumn(int currentColumn) {
        this.m_currentColumn = currentColumn;
    }
}
