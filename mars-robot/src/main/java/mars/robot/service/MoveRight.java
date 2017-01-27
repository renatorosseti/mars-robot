package mars.robot.service;

import mars.robot.entity.Space;
import org.springframework.stereotype.Service;
import static mars.robot.entity.Orientation.*;
/**
 * Created by Renato Rosseti on 25/01/17.
 */
@Service
public class MoveRight implements Motion {

    @Override
    public void move(Space position) {
        switch (position.getOrientation()) {
            case NORTH:
                position.setOrientation(EAST);
                break;
            case SOUTH:
                position.setOrientation(WEST);
                break;
            case EAST:
                position.setOrientation(SOUTH);
                break;
            case WEST:
                position.setOrientation(NORTH);
                break;
        }
    }
}
