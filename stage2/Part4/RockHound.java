/*
 * @author Gong Ke
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

import java.util.ArrayList;

/**
 * A <code>RockHound</code> behaves like a critter, but eat rocks.
 * it moves through the grid. <br />
 */
public class RockHound extends Critter
{
    /**
     * Processes the elements of <code>actors</code>.
     * It removes any rocks in the list.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (!(a instanceof Critter)) {
              a.removeSelfFromGrid();
            }
        }
    }

}

