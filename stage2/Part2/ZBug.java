/*
 *@author Gong Ke
 */

import info.gridworld.actor.Bug;

/**
 *  * A <code>ZBug</code> traces out a "Z" of a given size. <br />
 *   * The implementation of this class is testable on the AP CS A and AB exams.
 *    */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int time;
    /**
     * Constructs a Z bug that traces a "Z" of a given side length
     * @param length the side length
     *                */
    public ZBug(int length)
    {
            time = 0;
            steps = 0;
            sideLength = length;
setDirection(90);
        }

    /**
     * Moves to the next location of the "Z".
     *           */
    public void act()
    {
            if (steps < sideLength)
            {
                if (canMove()) {
                  move();
                  steps++;
                }
            }
            else
            {
                if (time == 0) {
                  setDirection(225);
                  steps = 0;
                  time = 1;
                }
                else if (time == 1){
                  setDirection(90);
                  steps = 0;
                  time = 2;
                }
            }
        }
}
