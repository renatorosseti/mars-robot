package mars.robot.entity;

/**
 * Created by Renato Rosseti on 25/01/17.
 */

public class MoveStraight implements Motion {

    @Override
    public void move(Space position) {
        int spaceY = position.getSpaceY();
        int spaceX = position.getSpaceX();
        switch (position.getOrientation()) {
            case NORTH:
                if (spaceY <= 3) {
                    position.setSpaceY(spaceY + 1);
                }
                break;
            case SOUTH:
                if (spaceY >= 1) {
                    position.setSpaceY(spaceY - 1);
                }
                break;
            case EAST:
                if (spaceX >= 1) {
                    position.setSpaceX(spaceX - 1);
                }
                break;
            case WEST:
                if (spaceX <= 3) {
                    position.setSpaceX(spaceX + 1);
                }
                break;
        }
    }
}
