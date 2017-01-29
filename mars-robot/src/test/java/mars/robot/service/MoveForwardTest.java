package mars.robot.service;

import mars.robot.entity.Orientation;
import mars.robot.entity.Space;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Renato Rosseti on 26/01/17.
 */
public class MoveForwardTest {

    /**
     * Forward motion tests.
     * All tests start the position with coordinateX = 0 and coordinateY = 0.
     */

    private Motion moveForward;

    @Before
    public void setup() {
        this.moveForward = new MoveForward();
    }

    @Test
    public void moveForward_whenCurrentOrientationIsNorth() {
        Space position = new Space();
        moveForward.move(position);
        Assert.assertEquals("Space Y should be equal to 1.", 1 ,position.getCoordinateY());
        Assert.assertEquals("Space X should be equal to 0.", 0 ,position.getCoordinateX());
        Assert.assertEquals("Orientation should be equal to NORTH. Should keep the same value.", Orientation.NORTH, position.getOrientation());
    }

    @Test
    public void moveForward_whenCurrentOrientationIsWest() {
        Space position = new Space();
        position.setOrientation(Orientation.WEST);
        moveForward.move(position);
        Assert.assertEquals("Space Y should be equal to 0.", 0 ,position.getCoordinateY());
        Assert.assertEquals("Space X should be equal to -1.", -1 ,position.getCoordinateX());
        Assert.assertEquals("Orientation should be equal to WEST. Should keep the same value.", Orientation.WEST, position.getOrientation());
    }

    @Test
    public void moveForward_whenCurrentOrientationIsSouth() {
        Space position = new Space();
        position.setOrientation(Orientation.SOUTH);
        moveForward.move(position);
        Assert.assertEquals("Space Y should be equal to -1.", -1 ,position.getCoordinateY());
        Assert.assertEquals("Space X should be equal to 0.", 0 ,position.getCoordinateX());
        Assert.assertEquals("Orientation should be equal to SOUTH. Should keep the same value.", Orientation.SOUTH, position.getOrientation());
    }

    @Test
    public void moveForward_whenCurrentOrientationIsEast() {
        Space position = new Space();
        position.setOrientation(Orientation.EAST);
        moveForward.move(position);
        Assert.assertEquals("Space Y should be equal to 0.", 0 ,position.getCoordinateY());
        Assert.assertEquals("Space X should be equal to 1.", 1 ,position.getCoordinateX());
        Assert.assertEquals("Orientation should be equal to EAST. Should keep the same value.", Orientation.EAST, position.getOrientation());
    }
}
