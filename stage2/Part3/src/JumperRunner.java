/*
 * @author Gong Ke
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

/**
 * This class runs a world that contains a jumper, a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class.
 * This class is not tested on the AP CS A and AB exams.
 */

public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Jumper());
        world.add(new Rock());
        world.add(new Bug());
        world.show();
    }
}

());
        world.show();
    }
}

