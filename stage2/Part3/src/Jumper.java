/*
 * @author Gong Ke
 */


import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;
import java.awt.Color;

/**
 * A <code>Bug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */

public class Jumper extends Actor
{
    /**
     * Constructs a red Jumper
     */
    public Jumper()
    {
        setColor(Color.RED);
    }
    /**
     * Constructs a jumper of a given color.
     * @param jumperColor the color for this jumper
     */
    public Jumper(Color jumperColor)
    {
        setColor(jumperColor);
    }
    /**
     * Jumps if it can jump, turns otherwise.
     */
    public void act()
    {
        if (canJump())
        {
            jump();
        } else {
            turn();
        }
    }
    /**
     * Turns the Jumper 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }
    /**
     * Jumps the jumper forward
     * occupied.
     */
    public void jump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        next = next.getAdjacentLocation(getDirection());
        if (gr.isValid(next)) {
            moveTo(next);
        } else {
            removeSelfFromGrid();
        }
    }
    /**
     * Tests whether this jumper can move forward into a lovation that is empty
     * ok to jump into empty location or onto flower
     * not ok to move onto any other actor
     * @return true if this bug can jump
     */
    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        next = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(next)) {
            return false;
        }
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
    }
}
