package mars.robot.service;

import mars.robot.entity.Orientation;
import mars.robot.entity.Space;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Renato Rosseti on 24/01/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RobotTest {

    private Robot robot;

    @Before
    public void setup() {
        robot = new Robot();
        MoveStraight moveStraight = new MoveStraight();
        MoveLeft moveLeft = new MoveLeft();
        MoveRight moveRight = new MoveRight();
        Space position = new Space();
        robot.setPosition(position);
        robot.setMoveStraight(moveStraight);
        robot.setRotateLeft(moveLeft);
        robot.setRotateRight(moveRight);
    }

    @Test
    public void move_whenMoveTwoStepsAndMoveToLeft() {
        robot.move("MML");
        Assert.assertEquals("Space X should be equal to 0.", 0 ,robot.getPosition().getSpaceX());
        Assert.assertEquals("Space Y should be equal to 2.", 2 ,robot.getPosition().getSpaceY());
        Assert.assertEquals("Orientation should be equal to WEST.", Orientation.WEST, robot.getPosition().getOrientation());
    }

    @Test
    public void move_whenMoveTwoStepsAndMoveToRight() {
        robot.move("MMR");
        Assert.assertEquals("Space X should be equal to 0.", 0 ,robot.getPosition().getSpaceX());
        Assert.assertEquals("Space Y should be equal to 2.", 2 ,robot.getPosition().getSpaceY());
        Assert.assertEquals("Orientation should be equal to EAST.", Orientation.EAST, robot.getPosition().getOrientation());
    }

    @Test
    public void move_whenMoveToRightAndMoveTwoSteps() {
        robot.move("RMM");
        Assert.assertEquals("Space X should be equal to 2.", 2 ,robot.getPosition().getSpaceX());
        Assert.assertEquals("Space Y should be equal to 0.", 0 ,robot.getPosition().getSpaceY());
        Assert.assertEquals("Orientation should be equal to EAST.", Orientation.EAST, robot.getPosition().getOrientation());
    }

    @Test
    public void move_whenCommandIsInvalid() {
        try {
            robot.move("AAA");
        } catch (Exception exception){
            Assert.assertEquals("Exception should be a RobotException.", RobotException.class, exception.getClass());
        }
    }

    @Test
    public void move_whenRobotCrossTheFinalPosition() {
        try {
            robot.move("AAA");
        } catch (Exception exception){
            Assert.assertEquals("Exception should be a RobotException.", RobotException.class, exception.getClass());
        }
    }
}
