import javax.swing.*;
import java.awt.*;

public class RulesOfLife extends JFrame //implements ActionListener
{
    private int m_columns;
    private int m_rows;
    private CellGrid currentGrid;
    private CellGrid nextGrid;

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

    public CellGrid getCurrentGrid() {
        return this.currentGrid;
    }

    public void setCurrentGrid(CellGrid currentGrid) {
        this.currentGrid = currentGrid;
    }

    public CellGrid getNextGrid() {
        return nextGrid;
    }

    public void setNextGrid(CellGrid nextGrid) {
        this.nextGrid = nextGrid;
    }

    public int getColumns() {
        return m_columns;
    }

    public void setColumns(int columns) {
        this.m_columns = columns;
    }

    public int getRows() {
        return this.m_rows;
    }

    public void setRows(int rows) {
        this.m_rows = rows;
    }

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
                    neighborsAlive = getCurrentGrid().neighborsAlive(currentGrid.getSingleCells()[c][r]);
                    if (currentGrid.getSingleCells()[c][r].isAlive())
                    {
                        if (neighborsAlive<2 || neighborsAlive>3)
                        {
                            nextGrid.getSingleCells()[c][r].dies();
                        }
                    }
                    else
                    {
                        if(neighborsAlive==3)
                        {
                            nextGrid.getSingleCells()[c][r].born();
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
