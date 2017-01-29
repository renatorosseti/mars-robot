package mars.robot.service;

import static mars.robot.entity.Orientation.*;
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
        MoveForward moveForward = new MoveForward();
        MoveLeft moveLeft = new MoveLeft();
        MoveRight moveRight = new MoveRight();
        Space position = new Space();
        robot.setPosition(position);
        robot.setMoveForward(moveForward);
        robot.setRotateLeft(moveLeft);
        robot.setRotateRight(moveRight);
    }

    @Test
    public void move_whenMoveToLeft() {
        robot.move("L");
        Assert.assertEquals("Space X should be equal to 0.", 0 ,robot.getPosition().getCoordinateX());
        Assert.assertEquals("Space Y should be equal to 0.", 0 ,robot.getPosition().getCoordinateY());
        Assert.assertEquals("Orientation should be equal to WEST.", WEST, robot.getPosition().getOrientation());
        Assert.assertEquals("Should return (0, 0, W) response.","(0, 0, W)",robot.getPosition().getFinalPositionText());
    }

    @Test
    public void move_whenMoveTwoStepsAndMoveToRight() {
        robot.move("R");
        Assert.assertEquals("Space X should be equal to 0.", 0 ,robot.getPosition().getCoordinateX());
        Assert.assertEquals("Space Y should be equal to 0.", 0 ,robot.getPosition().getCoordinateY());
        Assert.assertEquals("Orientation should be equal to EAST.", EAST, robot.getPosition().getOrientation());
        Assert.assertEquals("Should return (0, 0, E) response.","(0, 0, E)",robot.getPosition().getFinalPositionText());
    }

    @Test
    public void move_whenMoveThreeSteps() {
        robot.move("MMM");
        Assert.assertEquals("Space X should be equal to 0.", 0 ,robot.getPosition().getCoordinateX());
        Assert.assertEquals("Space Y should be equal to 3.", 3 ,robot.getPosition().getCoordinateY());
        Assert.assertEquals("Orientation should be equal to NORTH.", NORTH, robot.getPosition().getOrientation());
        Assert.assertEquals("Should return (0, 3, N) response.","(0, 3, N)",robot.getPosition().getFinalPositionText());
    }

    @Test
    public void move_whenCommandIsInvalid() {
        try {
            robot.move("AAA");
        } catch (Exception exception){
            Assert.assertEquals("An exception should be thrown as a RobotException.", RobotException.class, exception.getClass());
        }
    }

    @Test
    public void move_whenRobotCrossesTheMaxCoordinateAllowed() {
        try {
            robot.move("MMMMM");
        } catch (Exception exception){
            Assert.assertEquals("An exception should be thrown as a RobotException.", RobotException.class, exception.getClass());
        }
    }
}
