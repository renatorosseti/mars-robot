package mars.robot.service;

import mars.robot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Renato Rosseti on 25/01/17.
 */

@Service
public class Robot {

    @Autowired
    private Space position;

    @Autowired
    private MoveLeft rotateLeft;

    @Autowired
    private MoveRight rotateRight;

    @Autowired
    private MoveForward moveForward;

    private final String VALID_COMMANDS_RULE = "[MRL]+";

    public Robot() {
    }

    public String move(String inputCommand) throws RobotException {
        if (!hasOnlyValidCommands(inputCommand)) {
            throw new RobotException("400 Bad Request");
        }
        position.init();
        String[] moves = inputCommand.split("");
        for (String move : moves) {
            if (move.equals("M")) {
                moveForward.move(position);
                if(!position.isPositionValid()) {
                    throw new RobotException("400 Bad Request");
                }
            } else if (move.equals("L")) {
                rotateLeft.move(position);
            } else if (move.equals("R")) {
                rotateRight.move(position);
            }
        }
        return position.getFinalPositionResponse();
    }

    private boolean hasOnlyValidCommands(String inputMotion) {
        return inputMotion.matches(VALID_COMMANDS_RULE);
    }

    public Space getPosition() {
        return position;
    }

    public void setPosition(Space position) {
        this.position = position;
    }

    public void setMoveForward(MoveForward moveForward) {
        this.moveForward = moveForward;
    }

    public void setRotateRight(MoveRight rotateRight) {
        this.rotateRight = rotateRight;
    }

    public void setRotateLeft(MoveLeft rotateLeft) {
        this.rotateLeft = rotateLeft;
    }
}
