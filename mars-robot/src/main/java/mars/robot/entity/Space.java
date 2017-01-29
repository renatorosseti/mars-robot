package mars.robot.entity;

import org.springframework.stereotype.Repository;
import static mars.robot.entity.Orientation.*;

/**
 * Created by Renato Rosseti on 24/01/17.
 */

@Repository
public class Space {
    private int coordinateX;
    private int coordinateY;
    private Orientation orientation;

    public static final int MIN_COORDINATE = 0;
    public static final int MAX_COORDINATE = 4;

    public Space() {
        init();
    }

    public void init() {
        setCoordinateX(0);
        setCoordinateY(0);
        setOrientation(NORTH);
    }

    public String getFinalPositionResponse() {
        return  "(" + coordinateX +", "+ coordinateY +", " + orientation.getAcronym()+")";
    }

    public boolean isPositionValid() {
        return ((coordinateX >= MIN_COORDINATE && coordinateX <= MAX_COORDINATE) && (coordinateY >= MIN_COORDINATE && coordinateY <= MAX_COORDINATE));
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
