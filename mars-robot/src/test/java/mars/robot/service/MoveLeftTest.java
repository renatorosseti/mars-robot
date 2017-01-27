package mars.robot.service;

import mars.robot.entity.Orientation;
import mars.robot.entity.Space;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Renato Rosseti on 26/01/17.
 */
public class MoveLeftTest {

    private Motion moveLeft = new MoveLeft();

    /**
     Left motion tests.
     */

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
