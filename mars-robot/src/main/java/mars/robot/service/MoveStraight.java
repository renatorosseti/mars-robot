package mars.robot.service;

import mars.robot.entity.Space;
import org.springframework.stereotype.Service;
import static mars.robot.entity.Space.*;

/**
 * Created by Renato Rosseti on 25/01/17.
 */
@Service
public class MoveStraight implements Motion {

    /**
        @INITIAL_POSITION=0
        @FINAL_POSITION=4
     */
    @Override
    public void move(Space position) {
        int spaceY = position.getSpaceY();
        int spaceX = position.getSpaceX();
        switch (position.getOrientation()) {
            case NORTH:
                if (spaceY <= FINAL_POSITION) {
                    position.setSpaceY(spaceY + 1);
                }
                break;
            case SOUTH:
                if (spaceY >= INITIAL_POSITION) {
                    position.setSpaceY(spaceY - 1);
                }
                break;
            case EAST:
                if (spaceX <= FINAL_POSITION) {
                    position.setSpaceX(spaceX + 1);
                }
                break;
            case WEST:
                if (spaceX >= INITIAL_POSITION) {
                    position.setSpaceX(spaceX - 1);
                }
                break;
        }
    }
}
