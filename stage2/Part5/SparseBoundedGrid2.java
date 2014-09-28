/*
 * @author Gong Ke
 */

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.AbstractGrid;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * This SparseBoundedGrid is implemented by HashMap
 */

public class SparseBoundedGrid2<E> extends AbstractGrid<E>
{
    private Map<Location, E> occupantMap;
    private int rows;
    private int cols;
    /**
     * Constructs an SparseBoundedGrid.
     * @param rows number of rows
     * @param cols number of columns
     */
    public SparseBoundedGrid2(int rows, int cols)
    {
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
        occupantMap = new HashMap<Location, E>();
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
     * find out the locations which are occupied
     * @return list of occupied locations
     */
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> occupiedLations = new ArrayList<Location> ();
        for (Location loc : occupantMap.keySet())
        {
            occupiedLations.add(loc);
        }
        return occupiedLations;
    }
    /**
     * find the object E by location
     * @return E
     */
    public E get(Location loc)
    {
        if (loc == null)
        {
            throw new NullPointerException("loc == null");
        }
        return occupantMap.get(loc);
    }
    /**
     * put obj E at location loc
     * @return E
     */
    public E put(Location loc, E obj)
    {
        if (loc == null)
        {
            throw new NullPointerException("loc == null");
        }
        if (obj == null)
        {
            throw new NullPointerException("obj == null");
        }
        return occupantMap.put(loc, obj);
    }
    /**
     * remove the objec at location loc
     * @return E
     */
    public E remove(Location loc)
    {
        if (loc == null)
        {
            throw new NullPointerException("loc == null");
        }
        return occupantMap.remove(loc);
    }

}
