package mars.robot.service;

import mars.robot.entity.Orientation;
import mars.robot.entity.Space;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Renato Rosseti on 26/01/17.
 */
public class MoveStraightTest {

    /**
     Straight motion tests.
     */

    private Motion moveStraight = new MoveStraight();

    @Test
    public void moveStraight_whenCurrentOrientationIsNorthAndPositionIsInTheInitial() {
        Space position = new Space();
        moveStraight.move(position);
        Assert.assertEquals("Space Y should be equal to 1.", 1 ,position.getSpaceY());
        Assert.assertEquals("Space X should be equal to 0.", 0 ,position.getSpaceX());
        Assert.assertEquals("Orientation should be equal to NORTH. Should keep the same value.", Orientation.NORTH, position.getOrientation());
    }

    @Test
    public void moveStraight_whenCurrentOrientationIsWestAndPositionIsInTheInitial() {
        Space position = new Space();
        position.setOrientation(Orientation.WEST);
        moveStraight.move(position);
        Assert.assertEquals("Space Y should be equal to 0.", 0 ,position.getSpaceY());
        Assert.assertEquals("Space X should be equal to -1.", -1 ,position.getSpaceX());
        Assert.assertEquals("Orientation should be equal to WEST. Should keep the same value.", Orientation.WEST, position.getOrientation());
    }

    @Test
    public void moveStraight_whenCurrentOrientationIsSouthAndPositionIsInTheInitial() {
        Space position = new Space();
        position.setOrientation(Orientation.SOUTH);
        moveStraight.move(position);
        Assert.assertEquals("Space Y should be equal to -1.", -1 ,position.getSpaceY());
        Assert.assertEquals("Space X should be equal to 0.", 0 ,position.getSpaceX());
        Assert.assertEquals("Orientation should be equal to SOUTH. Should keep the same value.", Orientation.SOUTH, position.getOrientation());
    }

    @Test
    public void moveStraight_whenCurrentOrientationIsEastAndPositionIsTheInInitial() {
        Space position = new Space();
        position.setOrientation(Orientation.EAST);
        moveStraight.move(position);
        Assert.assertEquals("Space Y should be equal to 0.", 0 ,position.getSpaceY());
        Assert.assertEquals("Space X should be equal to 1.", 1 ,position.getSpaceX());
        Assert.assertEquals("Orientation should be equal to EAST. Should keep the same value.", Orientation.EAST, position.getOrientation());
    }
}
