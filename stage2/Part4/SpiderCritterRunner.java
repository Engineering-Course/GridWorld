/*
 * @author Gong Ke
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Bug;



/**
 *   This class runs a world that contains SpiderCritter. <br />
 *   This class is not tested on the AP CS A and AB exams.
 */
 public final class SpiderCritterRunner
{
    private SpiderCritterRunner(){}
    public static void main(String[] args)
    {
                            ActorWorld world = new ActorWorld();
                            world.add(new Location(1, 1), new Rock());
 

                            world.add(new Location(6, 5), new Bug());
                            world.add(new Location(5, 6), new Bug());
                            world.add(new Bug());

                            world.add(new Location(6, 6), new SpiderCritter());
                            world.add(new Location(5, 5), new SpiderCritter());
                            world.show();
        }
}
