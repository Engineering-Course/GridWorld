/*
 * @author Gong Ke
 */

import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

/**
 * This SparseBoundedGrid is implemented by HashMap
 *   */

public class SparseBoundedGrid3<E> extends UnboundedGrid<E>
{
    private int rows;
    private int cols;
    /**
     * Constructs an SparseBoundedGrid.
     * @param rows number of rows
     * @param cols number of columns
     */
    public SparseBoundedGrid3(int rows, int cols)
    {
            super();
            if (rows <= 0)
            {
                        throw new IllegalArgumentException("rows <= 0");
                    }
            if (cols <= 0)
            {
                        throw new IllegalArgumentException("cols <= 0" );
            }
            this.rows = rows;
            this.cols = cols;
        }
    /*
     * return rows of the grid
     */
    public int getNumRows()
    {
      return rows;
    }
    /*
     * return cols of the grid
     */
    public int getNumCols()
    {
      return cols;
    }
    /*
     *  check out whether the Location loc is valid
     */
    public boolean isValid(Location loc)
    {
            return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }



}
