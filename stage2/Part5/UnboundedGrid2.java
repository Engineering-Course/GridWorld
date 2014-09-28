/*
 * @author Gong Ke
 */

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.AbstractGrid;

import java.util.ArrayList;

/**
 * The UnBoundedGrid has has all valid locaitons which have
 * non-negative row and column values.
 */

public class UnboundedGrid2<E> extends AbstractGrid<E>
{
    private Object[][] occupantArray;
    private int size;
    /**
     * The construct allocates a 16*16 array
     */
    public UnboundedGrid2()
    {
        size = 16;
        occupantArray = new Object[size][size];
    }
    /*
     * row and col reutnr -1
     */
    public  int getNumRows()
    {
        return -1;
    }
    public int getNumCols()
    {
        return -1;
    }
    /**
     * location with non-negative row and column values is valid
     */
    public boolean isValid(Location loc)
    {
        return loc.getRow() >= 0 && loc.getCol() >= 0;
    }
    /**
     * find out the locations which are occupied
     * @return list of ouccupied locations
     */
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> occupiedLocations = new ArrayList<Location>();
        for (int r = 0; r < size; r++)
        {
            for (int c = 0; c < size; c++)
            {
                Location loc = new Location(r, c);
                if (get(loc) != null)
                {
                    occupiedLocations.add(loc);
                }
            }
        }
        return occupiedLocations;

    }
    /**
     * find the Object E by location
     * @return E
     */
    public E get (Location loc)
    {
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Location" + loc
                    + " is not valid");
        }
        if (loc.getRow() >= size || loc.getCol() >= size)
        {
            return null;
        }
        return (E) occupantArray[loc.getRow()][loc.getCol()];
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
                    + " is not valid");
        }
        if (obj == null)
        {
            throw new NullPointerException("obg == null");
        }
        if (loc.getRow() >= size || loc.getCol() >= size)
        {
            int len = size;
            while (loc.getRow() >= len || loc.getCol() >= len)
            {
                len *= 2;
            }
            Object[][] newArray = new Object[len][len];
            for (int r = 0; r < size; r++)
            {
                for (int c = 0; c < size; c++)
                {
                    newArray[r][c] = occupantArray[r][c];
                }
            }
            size = len;
            occupantArray = newArray;
        }
        E oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }
    /**
     * remove the object at locatiaon loc
     * @return E
     */
    public E remove(Location loc)
    {
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Location" + loc
                    + "is not valid");
        }
        if (loc.getRow() >= size || loc.getCol() >= size)
        {
            return null;
        }
        E oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return oldOccupant;
    }


}
