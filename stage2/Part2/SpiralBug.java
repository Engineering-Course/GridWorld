/*
 *@author Gong Ke
 */

import info.gridworld.actor.Bug;

/**
 * A <code>SpiralBug</code> drops flowers in a spiral pattern. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class SpiralBug extends Bug
{
    private int steps;
    private int sideLength;

    /**
     * Constructs a spiral bug that drops flowers in a spiral pattern
     * @param length the side length
     */
    public SpiralBug(int length)
    {
            steps = 0;
            sideLength = length;
        }

    /**
     * Moves to the next location of the spiral pattern
     * sideLength++ after each double turn
     */
    public void act()
    {
            if (steps < sideLength && canMove())
            {
                        move();
                        steps++;
                    }
            else
            {
                        turn();
                        turn();
                        steps = 0;
                        sideLength++;
                    }
        }
}
