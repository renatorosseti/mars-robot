package mars.robot.entity;

/**
 * Created by Renato Rosseti on 24/01/17.
 */

import java.util.ArrayList;
import java.util.List;

public class Movement {
    private List<Command> commands = new ArrayList<>();

    public Movement(String inputMove) {
        String[] moves = inputMove.split("");
        for (String move : moves){
            if (move.equals("M")) {
                commands.add(Command.M);
            } else if (move.equals("L")) {
                commands.add(Command.L);
            } else if (move.equals("R")) {
                commands.add(Command.R);
            }
        }
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}
