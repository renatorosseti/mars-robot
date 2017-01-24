package mars.robot.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Renato Rosseti on 24/01/17.
 */
public class MovementTest {

    @Test
    public void createMovement_whenInputCommandIsMML() {
        Movement movement = new Movement("MML");
        List<Command> expectedCommands = new ArrayList<>();
        expectedCommands.add(Command.M);
        expectedCommands.add(Command.M);
        expectedCommands.add(Command.L);
        Assert.assertEquals("Should return a list with M, M, L commands.", expectedCommands, movement.getCommands());
    }

    @Test
    public void createMovement_whenInputCommandIsMMR() {
        Movement movement = new Movement("MMR");
        List<Command> expectedCommands = new ArrayList<>();
        expectedCommands.add(Command.M);
        expectedCommands.add(Command.M);
        expectedCommands.add(Command.R);
        Assert.assertEquals("Should return a list with M, M, R commands.", expectedCommands, movement.getCommands());
    }
}
