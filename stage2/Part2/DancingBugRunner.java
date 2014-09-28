/*
 *@author Gong Ke
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 */
public class DancingBugRunner
{
    public static void main(String[] args)
    {
            int times1[] = {1, 2, 3, 4, 5, 6, 7, 8};
            int times2[] = {4, 3, 2, 1};
            ActorWorld world = new ActorWorld();
            DancingBug alice = new DancingBug(times1);
            alice.setColor(Color.ORANGE);
            DancingBug bob = new DancingBug(times2);
            world.add(new Location(5, 5), alice);
            world.add(new Location(4, 6), bob);
            world.show();
        }
}
