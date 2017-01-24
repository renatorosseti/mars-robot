package mars.robot.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Renato Rosseti on 24/01/17.
 */
public class SpaceTest {

    @Test
    public void moveRobot_whenMoveToLeft() {
        Space space = new Space();
        space.moveRobot("MML");
        Assert.assertEquals("Space X should be equal to 0.", 0 ,space.getSpaceX());
        Assert.assertEquals("Space Y should be equal to 2.", 2 ,space.getSpaceY());
        Assert.assertEquals("Orientation should be equal to W.", Orientation.W ,space.getOrientation());
    }

    @Test
    public void moveRobot_whenMoveToRight() {
        Space space = new Space();
        space.moveRobot("MMR");
        Assert.assertEquals("Space X should be equal to 0.", 0 ,space.getSpaceX());
        Assert.assertEquals("Space Y should be equal to 2.", 2 ,space.getSpaceY());
        Assert.assertEquals("Orientation should be equal to W.", Orientation.E ,space.getOrientation());
    }
}
