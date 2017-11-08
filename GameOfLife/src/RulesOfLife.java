import javax.swing.*;
import java.awt.*;

/**
 * @author Philip Abangan
 * @version 8 November 2017
 * This is a class that contains methods to play the Rule of Life.
 */
public class RulesOfLife extends JFrame
{
    private int m_columns; // Total number of columns in the grid.
    private int m_rows; // Total number of rows in the grid.
    private CellGrid currentGrid; // The current grid shown on the GUI.
    private CellGrid nextGrid; // The grid that's going to be next.

    /**
     * Default Constructor
     * Creates a JFrame full of JPanels, and makes them visible.
     */
    public RulesOfLife()
    {
        super("Game of Life");

        m_columns = 43;
        m_rows = 43;

        currentGrid = new CellGrid(m_columns, m_rows);
        nextGrid = new CellGrid(m_columns, m_rows);

        setLayout(new GridLayout(m_columns,m_rows));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for(int c = 0; c < m_columns; c++)
        {
            for (int r=0; r< m_rows; r++)
            {
                add(currentGrid.getSingleCells()[c][r]);
            }
        }

        // Validate performs relayout. It means invalid content is asked for all the sizes and all the subcomponents' sizes are set to proper values by LayoutManager.
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Current Grid get method.
     * @return currentGrid.
     */
    public CellGrid getCurrentGrid() {
        return this.currentGrid;
    }

    /**
     * Current Grid set method.
     * @param currentGrid is set to currentGrid.
     */
    public void setCurrentGrid(CellGrid currentGrid) {
        this.currentGrid = currentGrid;
    }

    /**
     * Next grid get method.
     * @return nextGrid.
     */
    public CellGrid getNextGrid() {
        return nextGrid;
    }

    /**
     * Next grid set method.
     * @param nextGrid
     */
    public void setNextGrid(CellGrid nextGrid) {
        this.nextGrid = nextGrid;
    }

    /**
     * Columns get method.
     * @return m_columns.
     */
    public int getColumns() {
        return m_columns;
    }

    /**
     * Columns set method.
     * @param columns is set to m_columns.
     */
    public void setColumns(int columns) {
        this.m_columns = columns;
    }

    /**
     * Rows get method.
     * @return m_rows.
     */
    public int getRows() {
        return this.m_rows;
    }

    /**
     * Rows set method.
     * @param rows is set to m_rows.
     */
    public void setRows(int rows) {
        this.m_rows = rows;
    }

    /**
     * Based on the number of neighbors alive does the following actions:
     * 1) Any live cell with fewer than two live neighbors dies, as if by loneliness.
     * 2) Any live cell with more than three live neighbors dies, as if by overcrowding.
     * 3) Any live cell with two or three live neighbors lives, unchanged, to the next generation.
     * 4) Any dead cell with exactly three live neighbors comes to life.
     */
    public void runGame()
    {
        int neighborsAlive=0;
        while(!currentGrid.deadGrid(currentGrid.getColumns(),getRows()))
        {
            try {
                Thread.sleep(100); // do nothing for 1000 milliseconds (1 second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int r=0; r<currentGrid.getRows(); r++)
            {
                for (int c=0; c<currentGrid.getColumns(); c++)
                {
                    // Get number of neighbors alive.
                    neighborsAlive = getCurrentGrid().neighborsAlive(currentGrid.getSingleCells()[c][r]);
                    if (currentGrid.getSingleCells()[c][r].isAlive()) // If the cell is alive.
                    {
                        if (neighborsAlive<2 || neighborsAlive>3) // If number of numbers alive is <2 or >3.
                        {
                            nextGrid.getSingleCells()[c][r].dies(); // The cell will die.
                        }
                    }
                    else // If the cell is dead.
                    {
                        if(neighborsAlive==3) // If the neighbors alive is 3.
                        {
                            nextGrid.getSingleCells()[c][r].born(); // The becomes alive.
                        }
                    }
                }
            }

            //This is to copy nextgrid into current grid.
            for (int r=0; r<currentGrid.getRows(); r++)
            {
                for (int c=0; c<currentGrid.getColumns(); c++)
                {
                    if (nextGrid.getSingleCells()[c][r].isAlive())
                    {
                        currentGrid.getSingleCells()[c][r].born();
                    }
                    else
                    {
                        currentGrid.getSingleCells()[c][r].dies();
                    }
                }
            }
        }
    }



}
