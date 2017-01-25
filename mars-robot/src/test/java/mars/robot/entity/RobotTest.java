package mars.robot.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Renato Rosseti on 24/01/17.
 */
public class RobotTest {

    @Test
    public void move_whenMoveToLeft() {
        Robot robot = new Robot();
        robot.move("MML");
        Assert.assertEquals("Space X should be equal to 0.", 0 ,robot.getPosition().getSpaceX());
        Assert.assertEquals("Space Y should be equal to 2.", 2 ,robot.getPosition().getSpaceY());
        Assert.assertEquals("Orientation should be equal to WEST.", Orientation.WEST ,robot.getPosition().getOrientation());
    }

    @Test
    public void move_whenMoveToRight() {
        Robot robot = new Robot();
        robot.move("MMR");
        Assert.assertEquals("Space X should be equal to 0.", 0 ,robot.getPosition().getSpaceX());
        Assert.assertEquals("Space Y should be equal to 2.", 2 ,robot.getPosition().getSpaceY());
        Assert.assertEquals("Orientation should be equal to EAST.", Orientation.EAST ,robot.getPosition().getOrientation());
    }
}
