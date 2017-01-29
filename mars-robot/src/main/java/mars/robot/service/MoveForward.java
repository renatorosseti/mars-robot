package mars.robot.service;

import mars.robot.entity.Space;
import org.springframework.stereotype.Service;
import static mars.robot.entity.Space.*;

/**
 * Created by Renato Rosseti on 25/01/17.
 */
@Service
public class MoveForward implements Motion {

    /**
     * @MIN_COORDINATE = 0
     * @MAX_COORDINATE = 4
     */

    @Override
    public void move(Space position) {
        int spaceY = position.getCoordinateY();
        int spaceX = position.getCoordinateX();
        switch (position.getOrientation()) {
            case NORTH:
                if (spaceY <= MAX_COORDINATE) {
                    position.setCoordinateY(spaceY + 1);
                }
                break;
            case SOUTH:
                if (spaceY >= MIN_COORDINATE) {
                    position.setCoordinateY(spaceY - 1);
                }
                break;
            case EAST:
                if (spaceX <= MAX_COORDINATE) {
                    position.setCoordinateX(spaceX + 1);
                }
                break;
            case WEST:
                if (spaceX >= MIN_COORDINATE) {
                    position.setCoordinateX(spaceX - 1);
                }
                break;
        }
    }
}
