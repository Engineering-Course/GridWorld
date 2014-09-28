/*
 * @author Gong Ke
 */

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;


import java.util.ArrayList;

/**
 * A <code>KingCrab</code>causes each actor that it processes to move
 * one locaiton further away form the KingCrab.If the actor cannot move
 * awya, the KingCrab removes it from the grid.
 *     */
public class KingCrab extends CrabCritter
{
    /**
     * Processes the elements of <code>actors</code>.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor who : actors)
        {
            int flag = 0;
            Location loc = who.getLocation();
            ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(loc);
            for (Location goTo : locs)
            {
                if (compare(goTo, loc))
                {
                    who.moveTo(goTo);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
            {
                who.removeSelfFromGrid();
            }
        }

    }
    /**
     * compare the distance.
     */
    public boolean compare(Location next, Location now)
    {
        int nextRow = next.getRow();
        int nextCol = next.getCol();
        int nowRow = now.getRow();
        int nowCol = now.getCol();
        int row = getLocation().getRow();
        int col = getLocation().getCol();
        int nextDis = (nextRow - row) * (nextRow - row) + (nextCol - col) * (nextCol - col);
        int nowDis = (nowRow - row) * (nowRow - row) + (nowCol - col) * (nowCol - col);
        return (nextDis > nowDis);
    }



}
