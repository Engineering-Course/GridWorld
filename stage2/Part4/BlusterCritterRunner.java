/*
 * @author Gong Ke
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;
import java.awt.Color;

/**
 * This class runs a world that contains BlusterCritter. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
 public final class BlusterCritterRunner
{
    private static final int A = 1;
    private static final int B = 3;
    private static final int C = 10;
    private BlusterCritterRunner(){}
    public static void main(String[] args)
    {
                    ActorWorld world = new ActorWorld();
                    world.add(new Location(1, 1), new Rock());
                    world.add(new Location(3, 3), new Critter());
                    world.add(new Location(4, 5), new Critter());
                    world.add(new Location(4, 6), new Critter());
                    world.add(new Location(5, 4), new Critter());
                    world.add(new Location(5, 6), new Critter());
                    BlusterCritter bob = new BlusterCritter(A);
                    bob.setColor(Color.red);
                    world.add(new Location(4, 4), bob);
                    world.add(new Location(6, 6), new BlusterCritter(B));
                    world.add(new Location(5, 5), new BlusterCritter(C));
                    world.show();
                }
}
