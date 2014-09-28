/*
 * @author Gong Ke
 * @comments author Wang Xinyan
 * @time 2014-08-08
 * @function: SpiderCritter move on the diagonal line, and it will eat 
 *  actors on the north, south, west and east of it. If it can not move
 *  it will darken its color until it gets black.
 */

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Critter;
/**
 * A <code>SpiderCritter</code>
 */

public class SpiderCritter extends Critter
{
    private static final double COLOR_FACTORY = 0.05;
    private static final int COLOR_MIN = 0;
    /**
     * set the original color of SpiderCritter
     */
    public SpiderCritter()
    {
        setColor(Color.PINK);
    }
    /**
     * A SpiderCritter gets the actors in the north, south, west and   
     * east.
     *
     * @return a list of actors occupying locations
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor> ();
        int[] dirs =
            {Location.NORTH, Location.EAST, Location.SOUTH, Location.WEST};

        for (Location loc : getLocationsInDirections(dirs))
        {
            Actor who = getGrid().get(loc);
            if (who != null)
            {
                actors.add(who);
            }
        }
        return actors;
    }

    /**
     * @return list of empty locations in northeast, northwest, 
     * southeast, southwest.
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dir =
            {Location.NORTHEAST, Location.SOUTHEAST, Location.SOUTHWEST,Location.NORTHWEST};

        for (Location loc : getLocationsInDirections(dir))
        {
            if (getGrid().get(loc) == null)
            {
                locs.add(loc);
            }
        }
        return locs;
    }
    /**
     * If the SpiderCritter doesn't move, it darkens it color 
     * individually.
     */

    public void makeMove(Location loc)
    {
        if (loc.equals(getLocation()))
        {
            darken();
        }
        else
        {
            super.makeMove(loc);
        }
    }
    /**
     * Finds the valid adjacent locations of this SpiderCritter
     * @param directors - an array of directions (which are the 
     * possible directions it may move to).
     * @return a set of valid locations that are valid.
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
        for (int dir : directions)
        {
            Location next = loc.getAdjacentLocation(getDirection() + dir);
            if (gr.isValid(next))
            {
                locs.add(next);
            }
        }

        return locs;
    }
    /**
     * the SpiderCritter's color darkens if it can't move;
     */
    public void darken()
    {
        Color c = getColor();
        if (c.getRed() == COLOR_MIN && c.getGreen() == COLOR_MIN && c.getBlue() == COLOR_MIN)
        {
            removeSelfFromGrid();
        }
        else
        {
            int red = (int) (c.getRed() * (1 - COLOR_FACTORY));
            int green = (int) (c.getGreen() * (1 - COLOR_FACTORY));
            int blue = (int) (c.getBlue() * (1 - COLOR_FACTORY));
            setColor(new Color(red, green, blue));
        }

    }

}
