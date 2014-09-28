/*
 * @author Gong Ke
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 *  A <code>BlusterCritter</code>looks at all of the neighbors within two
 *  steps of its current location.
 *  It counts the number of critters in those locations.
 *  If there are fewer than c critters, the BlusterCritter's color getsbrighter
 *  If there are c or more critters, the BlusterCritter's color darkens.
 *  Here c is a value that indicates the courage of the critter.
 */
public class BlusterCritter extends Critter
{
    private static final double COLOR_FACTOR = 0.95;
    private static final int COLOR_UNIT = 2;
    private static final int COLOR_MAX = 255;
    private int count;
    /**
     * Constructs a BlusterCritter
     * @param c the value that indicates the courage of the critter
     */
    public BlusterCritter(int c)
    {
      count = c;
    }
    /**
     * Gets the actor for prcessing.
     * It looks at all of the neighbors within tow steps of its current location.
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor> ();
        Location loc = getLocation();
        int row = loc.getRow();
        int col = loc.getCol();
        for (int i = row - 2; i <= row + 2; i++)
        {
            for (int j = col - 2; j <= col + 2; j++)
            {
                Location neighborLoc = new Location(i, j);
                if (getGrid().isValid(neighborLoc))
                {
                    Actor neighbor = getGrid().get(neighborLoc);
                    if (neighbor != null && neighbor != this)
                    {
                        actors.add(neighbor);
                    }
                }
            }
        }
        return actors;
    }
    /**
     * Processes the elements of <code>actors</code>.
     * It counts the number of critters in those locations.
     * If there are fewer than count critters, the BlusterCritter's color gets brighter.
     * Else darkens.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int number = 0;
        for (Actor who : actors)
        {
            if (who instanceof Critter)
            {
                number++;
            }
        }

        if (number < count)
        {
            Color c = getColor();

            int red = c.getRed() + COLOR_UNIT;
            int green = c.getGreen() + COLOR_UNIT;
            int blue = c.getBlue() + COLOR_UNIT;

            if (red > COLOR_MAX)
            {
                red = COLOR_MAX;
            }
            if (blue > COLOR_MAX)
            {
                blue = COLOR_MAX;
            }
            if (green > COLOR_MAX)
            {
                green = COLOR_MAX;
            }

            setColor(new Color(red, green, blue));
        }
        else
        {
            Color c = getColor();
            int red = (int) (c.getRed() * COLOR_FACTOR);
            int green = (int) (c.getGreen() * COLOR_FACTOR);
            int blue = (int) (c.getBlue() * COLOR_FACTOR);
            setColor(new Color(red, green, blue));
        }
        return;
    }
}

