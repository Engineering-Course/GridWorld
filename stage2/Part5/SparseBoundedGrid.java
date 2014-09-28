/*
 * @author Gong Ke
 */

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.AbstractGrid;

import java.util.ArrayList;

/**
 * a SparseBoundedGrid has a very large bounded grid that contains very
 * few objects and it frequntly calls the getOccupiedLocations method.
 */

public class SparseBoundedGrid<E> extends AbstractGrid<E>
{
    private SparseGridNode[] occupantArray;
    private int rows;
    private int cols;
    /**
     * Constructs an empty sparse bounded grid with the given dimensions.
     * (Precondition:<code>rows > 0 </code> and <code> cols > 0 </code>
     * @param rows number of rows in SparseBoundedGrid
     * @param cols number of columns in SparseBoundedGrid
     */
    public SparseBoundedGrid(int rows, int cols)
    {
        if (rows <= 0)
        {
            throw new IllegalArgumentException("rows <= 0");
        }
        if (cols <= 0)
        {
            throw new IllegalArgumentException("cols <= 0");
        }
        this.rows = rows;
        this.cols = cols;
        occupantArray = new SparseGridNode[rows];
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
     * check out whether the Location loc is valid
     */
    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
            && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }
    /**
     * find out the locations which are occupied.
     * @return list of ouccupied locations
     */
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> occupiedLocations = new ArrayList<Location>();
        for (int row = 0; row < getNumRows(); row++)
        {
            SparseGridNode sNode = occupantArray[row];
            while (sNode != null)
            {
                Location loc = new Location(row, sNode.getTheCol());
                occupiedLocations.add(loc);
                sNode = sNode.getNext();
            }
        }
        return occupiedLocations;
    }
    /**
     * find the object E by location
     * @return type E
     */
    public E get(Location loc)
    {
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Location" + loc
                    + " is not valid");
        }
        SparseGridNode sNode = occupantArray[loc.getRow()];
        while (sNode != null)
        {
            if (sNode.getTheCol() == loc.getCol())
            {
                return (E)sNode.getOccupant();
            }
            else
            {
                sNode = sNode.getNext();
            }
        }
        return null;
    }
    /**
     * put E obj at location loc
     * @return old occupant
     */
    public E put(Location loc, E obj)
    {
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Location" + loc
                    + "is not valid");
        }
        if (obj == null)
        {
            throw new NullPointerException("obj == null");
        }
        E oldOccupant = get(loc);
        SparseGridNode sNode = occupantArray[loc.getRow()];
        occupantArray[loc.getRow()] = new SparseGridNode(obj, loc.getCol(), sNode);
        return oldOccupant;
    }
    /**
     * remove the objct at location loc.
     * @return E
     */
    public E remove(Location loc)
    {
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Location" + loc
                    + " is not valid");
        }
        E oldOccupant = get (loc);
        SparseGridNode sNode = occupantArray[loc.getRow()];
        while (sNode != null)
        {
            if (sNode.getTheCol() == loc.getCol())
            {
                occupantArray[loc.getRow()] = sNode.getNext();
                break;
            }
            else
            {
                sNode = sNode.getNext();
            }
        }
        return oldOccupant;
    }

}
