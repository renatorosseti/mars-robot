package mars.robot.entity;

import org.springframework.stereotype.Repository;
import static mars.robot.entity.Orientation.*;

/**
 * Created by Renato Rosseti on 24/01/17.
 */

@Repository
public class Space {
    private int spaceX;
    private int spaceY;
    private Orientation orientation;

    public static final int INITIAL_POSITION = 0;
    public static final int FINAL_POSITION = 4;

    public Space() {
        init();
    }

    public void init() {
        setSpaceX(0);
        setSpaceY(0);
        setOrientation(NORTH);
    }

    public String getFinalPositionText() {
        return  "(" +spaceX +", "+ spaceY +", " + orientation.getAcronym()+")";
    }

    public boolean isPositionValid() {
        return !((spaceX < INITIAL_POSITION || spaceX > FINAL_POSITION) || (spaceY < INITIAL_POSITION || spaceY > FINAL_POSITION));
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
