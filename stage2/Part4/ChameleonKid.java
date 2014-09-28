/*
 * @author Gong Ke
 */

 import info.gridworld.actor.Actor;

 import info.gridworld.grid.Grid;
 import info.gridworld.grid.Location;


 import java.util.ArrayList;

 /**
  * A <code>ChameleonKid</code> takes on the color of one of the actors immediately in front or behind.
  * it moves through the grid. <br />
  * The implementation of this class is testable on the AP CS A and AB exams.
  */
 public class ChameleonKid extends ChameleonCritter
{
  /**
   * A ChameleonKid gets the actor immediately in front or behind.
   * @return a list of actors occupying these locations
   */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs = {0, 180};
        for (Location loc : getLocationsInDirections(dirs))
        {
            Actor a = getGrid().get(loc);
            if (a != null)
            {
                actors.add(a);
            }
        }
        return actors;
    }
    /**
     * Finds the valid adjacent locations of this critter in different directions.
     * @param directions -an array of directions (which are relative to the current direction)
     * @return a set of valid location that are neighbors of the current location in the given
     * directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
        for(int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc)) {
              locs.add(neighborLoc);
            }
        }
        return locs;
    }
}
