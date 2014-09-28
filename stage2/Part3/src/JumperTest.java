/*
 * @author Gong Ke
 */


import static org.junit.Assert.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/**
 * JumperTest is a class to test Jumper class.
 */

public class JumperTest {
/*
 * Create a gridworld and a jumper which location is (3, 3).
 */
  private static ActorWorld world = new ActorWorld();
  private static Jumper jumper = new Jumper();
  @Before
  public void setUp() throws Exception {
    jumper = new Jumper();
    world.add(new Location(3, 3), jumper);
  }
/*
 * Test act method
 * If there is a rock or a bug two cells in front of it,
 * it cannot jump but turn.
 * If there is a flower, it can jump.
 */
  @Test
  public void testAct() {
    world.add(new Location(1, 3), new Rock());
    world.add(new Location(3, 5), new Bug());
    world.add(new Location(5, 5), new Flower());
    jumper.act();
    assertEquals(new Location(3, 3), jumper.getLocation());
    assertEquals(45, jumper.getDirection());
    jumper.turn();
    jumper.act();
    assertEquals(new Location(3, 3), jumper.getLocation());
    assertEquals(135, jumper.getDirection());
    jumper.act();
    assertEquals(new Location(5, 5), jumper.getLocation());
  }

/*
 * A jumper is red, if there is no parameter in construction function
 *
 */

  @Test
  public void testJumper() {
    assertEquals(Color.RED, jumper.getColor());
  }
/*
 * A construction funciton with a parameter can create a jumper with the color
 */

  @Test
  public void testJumperColor() {
    Jumper jumper2 = new Jumper(Color.BLUE);
    assertEquals(Color.BLUE, jumper2.getColor());
  }
/*
 * The jumper calls turn once and trun 45 degredd
 */
  @Test
  public void testTurn() {
    jumper.turn();
    jumper.turn();
    assertEquals(90, jumper.getDirection());
 }
/*
 * Test the location after the jumper jumps
 */
 @Test
 public void testJump() {
    jumper.jump();
    assertEquals(new Location(1, 3), jumper.getLocation());
    jumper.setDirection(90);
    jumper.jump();
    assertEquals(new Location(1, 5), jumper.getLocation());
 }

/*
 * Test the setdirection function
 */

 @Test
 public void testSetDirection() {
    jumper.setDirection(180);
    assertEquals(180, jumper.getDirection());
 }


}
