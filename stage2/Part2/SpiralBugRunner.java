/*
 * @author Gong Ke
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 */
public class SpiralBugRunner
{
    public static void main(String[] args)
    {
            ActorWorld world = new ActorWorld();
            SpiralBug bob = new SpiralBug(3);
            bob.setColor(Color.ORANGE);
            world.add(new Location(5, 5), bob);
            world.show();
        }
}
