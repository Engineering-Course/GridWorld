/*
 * @author Gong Ke
 */


import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;

/**
 *  A <code>QuickCrab</code>moves to one of the two locations, randomly
 *  selected,that are two spaces to its right or left, if that locaion and
 *  the intervening location are both empty.
 */
public class QuickCrab extends CrabCritter
{

    /**
     * Finds the valid adjacnt locations of this critter in left and right.
     * Finds the valid adjacent locations of this critter in left and right.
     * @return a set of valid locations
     */
    public ArrayList<Location> getMoveLocations()
    {
        int count = 0;
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
        Location left = loc.getAdjacentLocation(getDirection() + Location.LEFT);
        Location lLeft = left.getAdjacentLocation(getDirection() + Location.LEFT);
        Location right = loc.getAdjacentLocation(getDirection() + Location.RIGHT);
        Location rRight = right.getAdjacentLocation(getDirection() + Location.RIGHT);
        if (gr.isValid(left) && gr.isValid(lLeft))
        {
            if ((gr.get(left) == null) && (gr.get(lLeft) == null))
            {
                locs.add(lLeft);
                count++;
            }
        }
        if (gr.isValid(right) && gr.isValid(rRight))
        {
            if ((gr.get(right) == null) && (gr.get(rRight) == null))
            {
                locs.add(rRight);
                count++;
            }
        }
        if (count != 0)
        {
            return locs;
        }
        else
        {
            if (gr.isValid(left) && gr.get(left) == null)
            {
                locs.add(left);
            }
            if (gr.isValid(right) && gr.get(right) == null)
            {
                locs.add(right);
            }
        }
        return locs;
    }


}
