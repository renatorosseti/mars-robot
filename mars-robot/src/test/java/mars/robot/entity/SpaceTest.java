package mars.robot.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Renato Rosseti on 29/01/17.
 */
public class SpaceTest {

    private Space position;

    @Before
    public void setup() {
        this.position = new Space();
    }

    @Test
    public void isFinalPositionValid_whenPositionIsValid() {
        position.setCoordinateX(4);
        position.setCoordinateY(4);

        boolean result = position.isPositionValid();

        Assert.assertTrue("Should succeed when coordinate X and coordinate Y are valid.",result);
    }

    @Test
    public void isFinalPositionValid_whenCoordinateXIsGreaterThanMaxCoordinate() {
        position.setCoordinateX(5);
        position.setCoordinateY(4);

        boolean result = position.isPositionValid();

        Assert.assertFalse("Should not succeed when coordinate X is greater than 4.",result);
    }

    @Test
    public void isFinalPositionValid_whenCoordinateYIsGreaterThanMaxCoordinate() {
        position.setCoordinateX(4);
        position.setCoordinateY(5);

        boolean result = position.isPositionValid();

        Assert.assertFalse("Should not succeed when coordinate Y is greater than 4.",result);
    }

    @Test
    public void isFinalPositionValid_whenCoordinateXIsSmallerThanMinCoordinate() {
        position.setCoordinateX(-1);
        position.setCoordinateY(4);

        boolean result = position.isPositionValid();

        Assert.assertFalse("Should not succeed when coordinate X is smaller than 0.",result);
    }

    @Test
    public void isFinalPositionValid_whenCoordinateYIsSmallerThanMinCoordinate() {
        position.setCoordinateX(4);
        position.setCoordinateY(-1);

        boolean result = position.isPositionValid();

        Assert.assertFalse("Should not succeed when coordinate Y is smaller than 0.",result);
    }
}
