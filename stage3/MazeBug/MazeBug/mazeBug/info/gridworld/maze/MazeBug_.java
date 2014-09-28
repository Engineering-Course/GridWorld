/*
 * @author Gong Ke
 */
package info.gridworld.maze;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */

public class MazeBug extends Bug {
	public Location next;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown
	public int[] direc = {Location.NORTH, Location.EAST, Location.SOUTH, Location.WEST};


	/**
	 * Constructs a box bug that traces a square of a given side length
	 * @param length the side length
	 */
	public MazeBug() {
		setColor(Color.GREEN);
		isEnd = false;
		crossLocation = new Stack<ArrayList<Location>>();
		stepCount = 0;
		hasShown = false;
		ArrayList<Location> testLocs = new ArrayList<Location> ();
		testLocs.add(getLocation());
		crossLocation.push(testLocs);
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		boolean willMove = canMove();
		if (isEnd) {
    /*
     * to show step count when reach the goal
     */
			if (!hasShown) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		} else if (willMove) {
			move();
    /*
     * increase step count when move or back.
     */
			stepCount++;
		} else {
			back();
			stepCount++;
		}
	}

	/**
	 * Find all positions that can be move to.
	 * @param loc the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return null;
		}
		ArrayList<Location> valid = new ArrayList<Location>();
		if (crossLocation.size() > 0) {
			ArrayList<Location> tempLocs = crossLocation.peek();

			for (int tempdirec : direc) {
				next = loc.getAdjacentLocation(tempdirec);
				if (gr.isValid(next)) {
					Actor who = gr.get(next);
					if (who instanceof Rock && who.getColor().equals(Color.RED)) {
						isEnd = true;
						valid.add(next);
						setDirection(loc.getDirectionToward(next));
						moveTo(next);
					}
					else if(who == null && !tempLocs.contains(next)) {
						valid.add(next);
					}
				}
			}
		}
		return valid;
	}
	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower. 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		return (getValid(getLocation()).size() > 0);
	}
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return;
		}
		Location loc = getLocation();
		
		ArrayList<Location> testLocs = getValid(loc);
		
		next = getPossibleLocation(testLocs);
		
		if (gr.isValid(next)) {
			int dir = loc.getDirectionToward(next);
			setDirection(dir);
			moveTo(next);
			
		} else {
			removeSelfFromGrid();
		}
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
		
		testLocs = crossLocation.pop();
		testLocs.add(loc);
		crossLocation.push(testLocs);
		
		testLocs = new ArrayList<Location>();
		testLocs.add(loc);
		crossLocation.push(testLocs);
	}
	/**
	 * If it cannot move, back to the location that it previous occupied.
	 */
	public void back() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return;
		}
		if(crossLocation.size() > 0) {
			crossLocation.pop();
			if (crossLocation.size() > 0) {
				Location loc = getLocation();
				ArrayList<Location> testLocs = crossLocation.peek();
				next = testLocs.get(testLocs.size() - 1);

				if (gr.isValid(next)) {
					int dir = loc.getDirectionToward(next);
					setDirection(dir);
					moveTo(next);
				} else {
					removeSelfFromGrid();
				}
				Flower flower = new Flower(getColor());
				flower.putSelfInGrid(gr, loc);
			}
		}
	}
	/**
	 * find the best next location using the statistic of smart array.
	 * @param locs the list of possible locations
	 * @return the best next location
	 */
	public Location getPossibleLocation(ArrayList<Location> locs) {
		int n = locs.size();
		if (n == 0) {
			return null;
		} else {
			int x = (int) (Math.random() * n);
			return locs.get(x);
		}

	}
}
