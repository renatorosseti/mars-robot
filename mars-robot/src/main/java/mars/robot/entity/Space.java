package mars.robot.entity;

import java.util.List;

import static mars.robot.entity.Orientation.*;
import static mars.robot.entity.Command.*;

/**
 * Created by Renato Rosseti on 24/01/17.
 */
public class Space {
    private int spaceX;
    private int spaceY;
    private Orientation orientation;

    public Space(){
        setSpaceX(0);
        setSpaceY(0);
        setOrientation(N);
    }

    public void moveRobot(String inputMotion) {
        Movement movement = new Movement(inputMotion);
        List<Command> commands = movement.getCommands();
        commands.forEach(command -> {
            if(getOrientation().equals(N)) {
                if(command.equals(M)) {
                    setSpaceY(getSpaceY() + 1);
                } else if(command.equals(L)) {
                    setOrientation(W);
                } else if(command.equals(R)) {
                    setOrientation(E);
                }
            }
        });
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
