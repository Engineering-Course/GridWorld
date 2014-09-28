/*
 *@author Gong Ke
 */

import info.gridworld.actor.Bug;
import java.util.Arrays;
/**
 * A <code>DancingBug</code> dances with an array of times of turn. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug
{
    private int t;
    private int index;
    private int[] turnTimes;
    /**
     * Constructs a dancing bug that dances with an array of times of turn
     * @param times the array of times of turn
     */
    public DancingBug(int[] times)
    {
      index = 0;
      t = 0;
      if (times == null) {
        this.turnTimes = new int[0];
      }
      else {
        this.turnTimes = Arrays.copyOf(times, times.length);
      }
    }
    /**
     *      * Moves to the next location after turning
     */
    public void act()
    {
        if (t < turnTimes[index]) {
          turn();
          t++;
        }
        else {
          if (canMove()) {
            move();
          }
          if (index == turnTimes.length -1) {
            index = 0;
          }
          else {
            index++;
          }
          t = 0;
        }
    }
}
