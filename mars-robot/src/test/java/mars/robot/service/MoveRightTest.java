package mars.robot.service;

import mars.robot.entity.Orientation;
import mars.robot.entity.Space;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Renato Rosseti on 26/01/17.
 */
public class MoveRightTest {

    /**
     * Right motion tests.
     * All tests start the position with coordinateX = 0 and coordinateY = 0.
     */

    private Motion moveRight;

    @Before
    public void setup() {
        this.moveRight = new MoveRight();
    }

    @Test
    public void moveRight_whenCurrentOrientationIsNorth() {
        Space position = new Space();
        moveRight.move(position);
        Assert.assertEquals("Orientation should be equal to EAST.", Orientation.EAST, position.getOrientation());
    }

    @Test
    public void moveRight_whenCurrentOrientationIsWest() {
        Space position = new Space();
        position.setOrientation(Orientation.WEST);
        moveRight.move(position);
        Assert.assertEquals("Orientation should be equal to NORTH.", Orientation.NORTH, position.getOrientation());
    }

    @Test
    public void moveRight_whenCurrentOrientationIsSouth() {
        Space position = new Space();
        position.setOrientation(Orientation.SOUTH);
        moveRight.move(position);
        Assert.assertEquals("Orientation should be equal to WEST.", Orientation.WEST, position.getOrientation());
    }

    @Test
    public void moveRight_whenCurrentOrientationIsEast() {
        Space position = new Space();
        position.setOrientation(Orientation.EAST);
        moveRight.move(position);
        Assert.assertEquals("Orientation should be equal to SOUTH.", Orientation.SOUTH, position.getOrientation());
    }
}
