package mars.robot.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Renato Rosseti on 25/01/17.
 */
public class MotionTest {
    private Motion moveLeft = new MoveLeft();
    private Motion moveRight = new MoveRight();
    private Motion moveStraight = new MoveStraight();

    /**
        Tests when robot moves to left.
     */

    @Test
    public void moveLeft_whenCurrentOrientationIsNorth() {
        Space position = new Space();
        moveLeft.move(position);
        Assert.assertEquals("Orientation should be equal to WEST.", Orientation.WEST ,position.getOrientation());
    }

    @Test
    public void moveLeft_whenCurrentOrientationIsWest() {
        Space position = new Space();
        position.setOrientation(Orientation.WEST);
        moveLeft.move(position);
        Assert.assertEquals("Orientation should be equal to SOUTH.", Orientation.SOUTH ,position.getOrientation());
    }

    @Test
    public void moveLeft_whenCurrentOrientationIsSouth() {
        Space position = new Space();
        position.setOrientation(Orientation.SOUTH);
        moveLeft.move(position);
        Assert.assertEquals("Orientation should be equal to EAST.", Orientation.EAST ,position.getOrientation());
    }

    @Test
    public void moveLeft_whenCurrentOrientationIsEast() {
        Space position = new Space();
        position.setOrientation(Orientation.EAST);
        moveLeft.move(position);
        Assert.assertEquals("Orientation should be equal to NORTH.", Orientation.NORTH ,position.getOrientation());
    }

    /**
     Tests when robot moves to right.
     */

    @Test
    public void moveRight_whenCurrentOrientationIsNorth() {
        Space position = new Space();
        moveRight.move(position);
        Assert.assertEquals("Orientation should be equal to EAST.", Orientation.EAST ,position.getOrientation());
    }

    @Test
    public void moveRight_whenCurrentOrientationIsWest() {
        Space position = new Space();
        position.setOrientation(Orientation.WEST);
        moveRight.move(position);
        Assert.assertEquals("Orientation should be equal to NORTH.", Orientation.NORTH ,position.getOrientation());
    }

    @Test
    public void moveRight_whenCurrentOrientationIsSouth() {
        Space position = new Space();
        position.setOrientation(Orientation.SOUTH);
        moveRight.move(position);
        Assert.assertEquals("Orientation should be equal to WEST.", Orientation.WEST ,position.getOrientation());
    }

    @Test
    public void moveRight_whenCurrentOrientationIsEast() {
        Space position = new Space();
        position.setOrientation(Orientation.EAST);
        moveRight.move(position);
        Assert.assertEquals("Orientation should be equal to SOUTH.", Orientation.SOUTH ,position.getOrientation());
    }

    /**
     Tests when robot moves straight ahead.
     */

    @Test
    public void moveStraight_whenCurrentOrientationIsNorthAndSpaceXAndSpaceYAreZEROZERO() {
        Space position = new Space();
        moveStraight.move(position);
        Assert.assertEquals("Space Y should be equal to 1.", 1 ,position.getSpaceY());
        Assert.assertEquals("Space X should be equal to 0.", 0 ,position.getSpaceX());
        Assert.assertEquals("Orientation should be equal to NORTH. Should keep the same value.", Orientation.NORTH ,position.getOrientation());
    }

    @Test
    public void moveStraight_whenCurrentOrientationIsWestAndSpaceXAndSpaceYAreZEROZERO() {
        Space position = new Space();
        position.setOrientation(Orientation.WEST);
        moveStraight.move(position);
        Assert.assertEquals("Space Y should be equal to 0.", 0 ,position.getSpaceY());
        Assert.assertEquals("Space X should be equal to 1.", 1 ,position.getSpaceX());
        Assert.assertEquals("Orientation should be equal to WEST. Should keep the same value.", Orientation.WEST ,position.getOrientation());
    }

    @Test
    public void moveStraight_whenCurrentOrientationIsSouthAndSpaceXAndSpaceYAreZEROZERO() {
        Space position = new Space();
        position.setOrientation(Orientation.SOUTH);
        moveStraight.move(position);
        Assert.assertEquals("Space Y should be equal to 0.", 0 ,position.getSpaceY());
        Assert.assertEquals("Space X should be equal to 0.", 0 ,position.getSpaceX());
        Assert.assertEquals("Orientation should be equal to SOUTH. Should keep the same value.", Orientation.SOUTH ,position.getOrientation());
    }

    @Test
    public void moveStraight_whenCurrentOrientationIsEastAndSpaceXAndSpaceYAreZEROZERO() {
        Space position = new Space();
        position.setOrientation(Orientation.EAST);
        moveStraight.move(position);
        Assert.assertEquals("Space Y should be equal to 0.", 0 ,position.getSpaceY());
        Assert.assertEquals("Space X should be equal to 1.", 0 ,position.getSpaceX());
        Assert.assertEquals("Orientation should be equal to EAST. Should keep the same value.", Orientation.EAST ,position.getOrientation());
    }
}
