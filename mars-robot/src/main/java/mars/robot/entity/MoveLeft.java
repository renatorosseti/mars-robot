package mars.robot.entity;

import static mars.robot.entity.Orientation.*;

/**
 * Created by Renato Rosseti on 25/01/17.
 */
public class MoveLeft implements Motion {

    @Override
    public void move(Space position) {
        switch (position.getOrientation()) {
            case NORTH:
                position.setOrientation(WEST);
                break;
            case SOUTH:
                position.setOrientation(EAST);
                break;
            case EAST:
                position.setOrientation(NORTH);
                break;
            case WEST:
                position.setOrientation(SOUTH);
                break;
        }
    }
}
