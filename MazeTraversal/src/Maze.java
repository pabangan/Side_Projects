import java.util.Scanner;

/**
 * @author Philip Abangan
 * @version 26 November 2017
 * Class for creating an modifying Maze. Contains a grid of SingleCells.
 * Anything that has to do with a singleCell object relating to its neighbors will be in this class.
 */
public class Maze {
    private final int endRowIndex = 4; // Contains the row position of the exit in the maze.
    private final int endColumnIndex = 11; // Contains the columns position  of the exit in the Maze.
    private int row; // Contains total amount of rows in the Maze.
    private int column; // Contains total amount of columns in the Maze.
    private SingleCell[][] m_maze; // Contains a grid of singleCells, representing a Maze.

    /**
     * Default Constructor.
     * Makes the default grid of 12 by 12 grid.
     */
    public Maze() {
        //Initializing row, column, m_maze, and each index of the array.
        row = 12;
        column = 12;
        m_maze = new SingleCell[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                m_maze[r][c] = new SingleCell(r, c);
            }
        }

        initialSetup(); // Initializes the standard grid given in problem.
        System.out.println();
    }

    /**
     * Method for printing the maze.
     */
    public void printMaze() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                m_maze[r][c].printSpace();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * Recursive method for moving through the maze.
     *
     * @param maze          passes in the object to be modified.
     * @param currentRow    passes in the current row of the object to be checked.
     * @param currentColumn passes in the current columnn of the object to be checked.
     */
    public void mazeTraversal(Maze maze, int currentRow, int currentColumn) {
        m_maze[currentRow][currentColumn].makeX(); // Marks the current position an X to show that the objects been there.
        printMaze(); // prints the maze to the screen, showing it new position.
        System.out.println();
        if (currentColumn != endColumnIndex || currentRow != endRowIndex) // If the object isn't at the end.
        {
            System.out.println("Hit '1' and 'ENTER'");
            int a;
            Scanner s = new Scanner(System.in);
            a = s.nextInt();
            if (a == 1) {
                if (possibleDirections(currentRow, currentColumn) > 0) // If there's possible directions to move in.
                {
                    if (up(currentRow, currentColumn)) //If the object can go up.
                    {
                        mazeTraversal(maze, currentRow - 1, currentColumn);
                    } else if (right(currentRow, currentColumn)) // If the object can go right.
                    {
                        mazeTraversal(maze, currentRow, currentColumn + 1);
                    } else if (down(currentRow, currentColumn)) // If the object can go down.
                    {
                        mazeTraversal(maze, currentRow + 1, currentColumn);
                    } else if (left(currentRow, currentColumn)) // If the object can go left.
                    {
                        mazeTraversal(maze, currentRow, currentColumn - 1);
                    }
                } else // If at dead-end, call a backtrack method to go backwards.
                {
                    System.out.println("Ran into deadend.");
                    backtrack(maze, currentRow, currentColumn);
                }
            }
        } else // If at end point.
        {
            System.out.print("Reached the END ZONE!");
        }
    }


    /**
     * Method for checking to see if any of the neighbors are dots, which mean the object can move in that direction.
     *
     * @param currentRow    is used to know the row position of the current object.
     * @param currentColumn is used to know the column position of the current object.
     * @return possDir, which is the number of potential directions to move in.
     */
    private int possibleDirections(int currentRow, int currentColumn) {
        int possDir = 0;
        if (up(currentRow, currentColumn)) // Checks up.
        {
            possDir++;
        }
        if (down(currentRow, currentColumn)) // Checks down.
        {
            possDir++;
        }
        if (right(currentRow, currentColumn)) // Checks right.
        {
            possDir++;
        }
        if (left(currentRow, currentColumn)) // Checks left.
        {
            possDir++;
        }
        return possDir;
    }

    /**
     * Checks to see if the location above is a Dot.
     *
     * @param currentRow    is the row position of the object.
     * @param currentColumn is the column position of the object.
     * @return boolean whether if it's a Dot or not.
     */
    private boolean up(int currentRow, int currentColumn) {
        boolean temp = false;
        if (currentRow - 1 >= 0) {
            if ((m_maze[currentRow - 1][currentColumn].getSpace() == SingleCell.Components.Dot)  /*|| (m_maze[currentRow-1][currentColumn].getSpace()== SingleCell.Components.X)*/) {
                temp = true;
            }
        }
        return temp;
    }

    /**
     * Method for checking if the location below is a Dot.
     *
     * @param currentRow    is the row of the position of the object.
     * @param currentColumn is the column of the position of the object.
     * @return boolean whether if it's a Dot or not.
     */
    private boolean down(int currentRow, int currentColumn) {
        boolean temp = false;
        if (currentRow + 1 < row) {
            if ((m_maze[currentRow + 1][currentColumn].getSpace() == SingleCell.Components.Dot) /* || (m_maze[currentRow+1][currentColumn].getSpace()== SingleCell.Components.X)*/) {
                temp = true;
            }
        }
        return temp;
    }

    /**
     * Method for checking if the location to the right is a Dot.
     *
     * @param currentRow    is the row of the position of the object.
     * @param currentColumn is the column of the position of the object.
     * @return boolean whether if it's a Dot or not.
     */
    private boolean right(int currentRow, int currentColumn) {
        boolean temp = false;
        if (currentColumn + 1 < column) {
            if ((m_maze[currentRow][currentColumn + 1].getSpace() == SingleCell.Components.Dot)  /*|| (m_maze[currentRow][currentColumn+1].getSpace()== SingleCell.Components.X)*/) {
                temp = true;
            }
        }
        return temp;
    }

    private boolean left(int currentRow, int currentColumn) {
        boolean temp = false;
        if (currentColumn - 1 >= 0) {
            if ((m_maze[currentRow][currentColumn - 1].getSpace() == SingleCell.Components.Dot)  /*|| (m_maze[currentRow][currentColumn-1].getSpace()== SingleCell.Components.X)*/) {
                temp = true;
            }
        }
        return temp;
    }

    /**
     * Recursive method that goes to a previous location until there's a possible new direction.
     *
     * @param maze          is the object to be modified.
     * @param currentRow    is the row position of the object.
     * @param currentColumn is the column position of the object.
     */
    public void backtrack(Maze maze, int currentRow, int currentColumn) {
        m_maze[currentRow][currentColumn].makeO(); // Makes the current position an O, which means not to go in that direction again.
        printMaze(); // Prints the maze with new update.
        System.out.println();
        if (m_maze[currentRow - 1][currentColumn].getSpace() == SingleCell.Components.X) // Checks above.
        {
            m_maze[currentRow][currentColumn].makeO();
            mazeTraversal(maze, currentRow - 1, currentColumn);
        } else if (m_maze[currentRow][currentColumn + 1].getSpace() == SingleCell.Components.X) // Checks right.
        {
            m_maze[currentRow][currentColumn].makeO();
            mazeTraversal(maze, currentRow, currentColumn + 1);
        } else if (m_maze[currentRow + 1][currentColumn].getSpace() == SingleCell.Components.X) // Checks below.
        {
            m_maze[currentRow][currentColumn].makeO();
            mazeTraversal(maze, currentRow + 1, currentColumn);
        } else if (m_maze[currentRow][currentColumn - 1].getSpace() == SingleCell.Components.X) // Checks left.
        {
            m_maze[currentRow][currentColumn].makeO();
            mazeTraversal(maze, currentRow, currentColumn - 1);
        }
    }

    /**
     * This is a method for making a default maze setup.
     */
    public void initialSetup() {
        m_maze[1][1].makeDot();
        m_maze[1][2].makeDot();
        m_maze[1][3].makeDot();
        m_maze[1][5].makeDot();
        m_maze[1][6].makeDot();
        m_maze[1][7].makeDot();
        m_maze[1][8].makeDot();
        m_maze[1][9].makeDot();
        m_maze[1][10].makeDot();

        m_maze[2][0].makeDot();
        m_maze[2][1].makeDot();
        m_maze[2][3].makeDot();
        m_maze[2][5].makeDot();
        m_maze[2][10].makeDot();

        m_maze[3][3].makeDot();
        m_maze[3][5].makeDot();
        m_maze[3][6].makeDot();
        m_maze[3][7].makeDot();
        m_maze[3][8].makeDot();
        m_maze[3][10].makeDot();

        m_maze[4][1].makeDot();
        m_maze[4][2].makeDot();
        m_maze[4][3].makeDot();
        m_maze[4][4].makeDot();
        m_maze[4][8].makeDot();
        m_maze[4][10].makeDot();
        m_maze[4][11].makeDot();

        m_maze[5][4].makeDot();
        m_maze[5][6].makeDot();
        m_maze[5][8].makeDot();
        m_maze[5][10].makeDot();

        m_maze[6][1].makeDot();
        m_maze[6][2].makeDot();
        m_maze[6][4].makeDot();
        m_maze[6][6].makeDot();
        m_maze[6][8].makeDot();
        m_maze[6][10].makeDot();

        m_maze[7][2].makeDot();
        m_maze[7][4].makeDot();
        m_maze[7][6].makeDot();
        m_maze[7][8].makeDot();
        m_maze[7][10].makeDot();

        m_maze[8][1].makeDot();
        m_maze[8][2].makeDot();
        m_maze[8][3].makeDot();
        m_maze[8][4].makeDot();
        m_maze[8][5].makeDot();
        m_maze[8][6].makeDot();
        m_maze[8][7].makeDot();
        m_maze[8][8].makeDot();
        m_maze[8][10].makeDot();

        m_maze[9][6].makeDot();
        m_maze[9][10].makeDot();

        m_maze[10][1].makeDot();
        m_maze[10][2].makeDot();
        m_maze[10][3].makeDot();
        m_maze[10][4].makeDot();
        m_maze[10][5].makeDot();
        m_maze[10][6].makeDot();
        m_maze[10][8].makeDot();
        m_maze[10][9].makeDot();
        m_maze[10][10].makeDot();
    }


}