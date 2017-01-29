package mars.robot.service;

import mars.robot.entity.Orientation;
import mars.robot.entity.Space;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Renato Rosseti on 26/01/17.
 */
public class MoveLeftTest {

    /**
     * Left motion tests.
     * All tests start the position with coordinateX = 0 and coordinateY = 0.
     */

    private Motion moveLeft;

    @Before
    public void setup() {
        this.moveLeft = new MoveLeft();
    }

    @Test
    public void moveLeft_whenCurrentOrientationIsNorth() {
        Space position = new Space();
        moveLeft.move(position);
        Assert.assertEquals("Orientation should be equal to WEST.", Orientation.WEST, position.getOrientation());
    }

    @Test
    public void moveLeft_whenCurrentOrientationIsWest() {
        Space position = new Space();
        position.setOrientation(Orientation.WEST);
        moveLeft.move(position);
        Assert.assertEquals("Orientation should be equal to SOUTH.", Orientation.SOUTH, position.getOrientation());
    }

    @Test
    public void moveLeft_whenCurrentOrientationIsSouth() {
        Space position = new Space();
        position.setOrientation(Orientation.SOUTH);
        moveLeft.move(position);
        Assert.assertEquals("Orientation should be equal to EAST.", Orientation.EAST, position.getOrientation());
    }

    @Test
    public void moveLeft_whenCurrentOrientationIsEast() {
        Space position = new Space();
        position.setOrientation(Orientation.EAST);
        moveLeft.move(position);
        Assert.assertEquals("Orientation should be equal to NORTH.", Orientation.NORTH, position.getOrientation());
    }
}
