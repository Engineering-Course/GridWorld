/*
 * @author Gong Ke
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Bug;
import java.awt.Color;

/**
 *This class runs a world that contains KingCrab. <br />
 *This class is not tested on the AP CS A and AB exams.
 *    *    */
 public final class KingCrabRunner
{
    private KingCrabRunner(){}
    public static void main(String[] args)
    {
                            ActorWorld world = new ActorWorld();
                            world.add(new Location(1, 1), new Rock());
                            world.add(new Location(3, 3), new Rock());
                            world.add(new Location(4, 5), new Rock());
                            world.add(new Location(4, 6), new Rock());
                            world.add(new Location(5, 4), new Rock());
                            world.add(new Location(5, 6), new Rock());
                            world.add(new Bug());
                            KingCrab bob = new KingCrab();
                            bob.setColor(Color.red);
                            world.add(new Location(4, 4), bob);
                            world.add(new Location(6, 6), new KingCrab());
                            world.add(new Location(5, 5), new KingCrab());
                            world.show();
        }
}
