import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
/**
 * * This class runs a world with additional grid choices.
 * */
public final class SparseGridRunner
{
  private SparseGridRunner(){}
  public static void main(String[] args)
  {
      ActorWorld world = new ActorWorld();
      world.addGridClass("SparseBoundedGrid");
      world.addGridClass("SparseBoundedGrid2");
      world.addGridClass("SparseBoundedGrid3");
      world.addGridClass("UnboundedGrid2");
      world.add(new Location(2, 2), new Critter());
      world.add(new Location(3, 3), new Rock());
      world.add(new Location(5, 5), new Flower());
      world.add(new Location(2, 3), new Actor());
      world.show();
    }
}

