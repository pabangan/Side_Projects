/**
 * @author Philip Abangan
 * @version 26 November 2017
 * Class contains method pertaining to an individual position in the maze.
 */
public class SingleCell {
    private Components m_space; // Stores whether it's an X, O, ., or #.
    private int m_currentColumn; // Current column position of that particular object.
    private int m_currentRow; // Current row position of that particular object.

    /**
     * Default Constructor
     * sets m_currentColumn & m_currentRow to 0.
     * sets m_space to a Hash.
     */
    public SingleCell() {
        m_space = Components.Hash;
        m_currentColumn = 0;
        m_currentRow = 0;

    }

    /**
     * Double parameter constructor.
     *
     * @param row    is set to m_currentRow.
     * @param column is set to m_currentColumn.
     */
    public SingleCell(int row, int column) {
        m_space = Components.Hash;
        m_currentRow = row;
        m_currentColumn = column;
    }

    /**
     * Get method for the current columns.
     *
     * @return m_currentColumn.
     */
    public int getCurrentColumn() {
        return m_currentColumn;
    }

    /**
     * Set method for the current column.
     *
     * @param currentColumn is set to m_currentColumn.
     */
    public void setCurrentColumn(int currentColumn) {
        this.m_currentColumn = currentColumn;
    }

    /**
     * Get method for the current row.
     *
     * @return m_currentRow.
     */
    public int getCurrentRow() {
        return m_currentRow;
    }

    /**
     * Set method for the current row.
     *
     * @param currentRow is set to m_currentRow.
     */
    public void setCurrentRow(int currentRow) {
        this.m_currentRow = currentRow;
    }


    // Method for making a particular SingleCell an X.
    public void makeX() {
        m_space = Components.X;
    }

    // Method for making a particular singleCell a Dot.
    public void makeDot() {
        m_space = Components.Dot;
    }

    // Method for making a particular SingleCell an O.
    public void makeO() {
        m_space = Components.O;
    }

    /**
     * Get method for what's in the space.
     *
     * @return m_space.
     */
    public Components getSpace() {
        return m_space;
    }

    /**
     * Method for printing what's in the space.
     */
    public void printSpace() {
        switch (m_space) {
            case Hash:
                System.out.printf("#");
                break;
            case Dot:
                System.out.printf(".");
                break;
            case X:
                System.out.printf("X");
                break;
            case O:
                System.out.printf("O");
                break;
        }
    }

    // Enumerator of what's going to be contained in a SingleCell.
    public enum Components {
        Hash, Dot, X, O
    }
}