package mars.robot.entity;

import static mars.robot.entity.Orientation.*;

/**
 * Created by Renato Rosseti on 24/01/17.
 */
public class Space {
    private int spaceX;
    private int spaceY;
    private Orientation orientation;

    public Space() {
        setSpaceX(0);
        setSpaceY(0);
        setOrientation(NORTH);
    }

    public int getSpaceX() {
        return spaceX;
    }

    public void setSpaceX(int spaceX) {
        this.spaceX = spaceX;
    }

    public int getSpaceY() {
        return spaceY;
    }

    public void setSpaceY(int spaceY) {
        this.spaceY = spaceY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
