public class CellGrid
{
    private SingleCell[][] m_cells;
    private int m_columns;
    private int m_rows;

    public CellGrid(){}

    public CellGrid(int columns, int rows)
    {
        m_columns = columns;
        m_rows = rows;
        m_cells = new SingleCell[m_columns][m_rows];

        for(int r = 0; r < m_rows; r++)
        {
            for (int c=0; c< m_columns; c++)
            {
                m_cells[c][r] = new SingleCell(c,r);
            }
        }
        gosperGliderGun();
        pulsarPeriod3();
    }

    public int getColumns() {
        return m_columns;
    }

    public void setColumns(int columns) {
        this.m_columns = columns;
    }

    public int getRows() {
        return m_rows;
    }

    public void setRows(int rows) {
        this.m_rows = rows;
    }

    public SingleCell[][] getSingleCells() {
        return m_cells;
    }

    //Need to make a method that checks and returns HOW MANY of the cell's neighbors are alive. Might be private.
    public int neighborsAlive(SingleCell cell)
    {
        int aliveCount = 0;
        int x = cell.getCurrentColumn();
        int y = cell.getCurrentRow();

        if (x>0 && x+1<this.getColumns())
        {
            if (y>0 && y+1<this.getRows())
            {
                if (this.getSingleCells()[x-1][y+1].isAlive())
                {
                    aliveCount++;
                }
                if (this.getSingleCells()[x-1][y].isAlive())
                {
                    aliveCount++;
                }
                if (this.getSingleCells()[x-1][y-1].isAlive())
                {
                    aliveCount++;
                }
                if (this.getSingleCells()[x][y+1].isAlive())
                {
                    aliveCount++;
                }
                if (this.getSingleCells()[x][y-1].isAlive())
                {
                    aliveCount++;
                }
                if (this.getSingleCells()[x+1][y+1].isAlive())
                {
                    aliveCount++;
                }
                if (this.getSingleCells()[x+1][y].isAlive())
                {
                    aliveCount++;
                }
                if (this.getSingleCells()[x+1][y-1].isAlive())
                {
                    aliveCount++;
                }
            }
        }
        return aliveCount;
    }

    public boolean deadGrid(int columns, int rows)
    {
        for(int r = 0; r < rows; r++)
        {
            for (int c=0; c< columns; c++)
            {
                if (m_cells[c][r].isAlive())
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void gosperGliderGun()
    {
        try
        {
            // Gosper Glider Gun
            this.getSingleCells()[5][2].born();
            this.getSingleCells()[5][3].born();
            this.getSingleCells()[6][2].born();
            this.getSingleCells()[6][3].born();

            this.getSingleCells()[5][12].born();
            this.getSingleCells()[6][12].born();
            this.getSingleCells()[7][12].born();
            this.getSingleCells()[4][13].born();
            this.getSingleCells()[8][13].born();
            this.getSingleCells()[3][14].born();
            this.getSingleCells()[9][14].born();
            this.getSingleCells()[3][15].born();
            this.getSingleCells()[9][15].born();
            this.getSingleCells()[6][16].born();
            this.getSingleCells()[4][17].born();
            this.getSingleCells()[8][17].born();
            this.getSingleCells()[5][18].born();
            this.getSingleCells()[6][18].born();
            this.getSingleCells()[7][18].born();
            this.getSingleCells()[6][19].born();

            this.getSingleCells()[3][22].born();
            this.getSingleCells()[4][22].born();
            this.getSingleCells()[5][22].born();
            this.getSingleCells()[3][23].born();
            this.getSingleCells()[4][23].born();
            this.getSingleCells()[5][23].born();
            this.getSingleCells()[2][24].born();
            this.getSingleCells()[6][24].born();
            this.getSingleCells()[1][26].born();
            this.getSingleCells()[2][26].born();
            this.getSingleCells()[6][26].born();
            this.getSingleCells()[7][26].born();

            this.getSingleCells()[3][36].born();
            this.getSingleCells()[4][36].born();
            this.getSingleCells()[3][37].born();
            this.getSingleCells()[4][37].born();
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public void pulsarPeriod3()
    {
        try
        {
            // Pulsar Period 3.
            this.getSingleCells()[37][4].born();
            this.getSingleCells()[36][4].born();
            this.getSingleCells()[35][4].born();
            this.getSingleCells()[31][4].born();
            this.getSingleCells()[30][4].born();
            this.getSingleCells()[29][4].born();

            this.getSingleCells()[39][6].born();
            this.getSingleCells()[34][6].born();
            this.getSingleCells()[32][6].born();
            this.getSingleCells()[27][6].born();

            this.getSingleCells()[39][7].born();
            this.getSingleCells()[34][7].born();
            this.getSingleCells()[32][7].born();
            this.getSingleCells()[27][7].born();

            this.getSingleCells()[39][8].born();
            this.getSingleCells()[34][8].born();
            this.getSingleCells()[32][8].born();
            this.getSingleCells()[27][8].born();

            this.getSingleCells()[37][9].born();
            this.getSingleCells()[36][9].born();
            this.getSingleCells()[35][9].born();
            this.getSingleCells()[31][9].born();
            this.getSingleCells()[30][9].born();
            this.getSingleCells()[29][9].born();

            this.getSingleCells()[37][11].born();
            this.getSingleCells()[36][11].born();
            this.getSingleCells()[35][11].born();
            this.getSingleCells()[31][11].born();
            this.getSingleCells()[30][11].born();
            this.getSingleCells()[29][11].born();

            this.getSingleCells()[39][12].born();
            this.getSingleCells()[34][12].born();
            this.getSingleCells()[32][12].born();
            this.getSingleCells()[27][12].born();

            this.getSingleCells()[39][13].born();
            this.getSingleCells()[34][13].born();
            this.getSingleCells()[32][13].born();
            this.getSingleCells()[27][13].born();

            this.getSingleCells()[39][14].born();
            this.getSingleCells()[34][14].born();
            this.getSingleCells()[32][14].born();
            this.getSingleCells()[27][14].born();

            this.getSingleCells()[37][16].born();
            this.getSingleCells()[36][16].born();
            this.getSingleCells()[35][16].born();
            this.getSingleCells()[31][16].born();
            this.getSingleCells()[30][16].born();
            this.getSingleCells()[29][16].born();
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
