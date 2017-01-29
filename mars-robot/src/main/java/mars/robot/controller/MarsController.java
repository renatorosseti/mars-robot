package mars.robot.controller;

import mars.robot.service.RobotException;
import mars.robot.service.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Renato Rosseti on 24/01/17.
 */

@RestController(value = "rest/mars")
public class MarsController {

    @Autowired
    private Robot robot;

    @RequestMapping(value = "/rest/mars/{command}", method = RequestMethod.POST)
    public ResponseEntity<String> controlRobot(@PathVariable String command) throws RobotException {
        String response = robot.move(command);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @ExceptionHandler({RobotException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleRobotExceptions(HttpServletResponse response, RobotException exception) throws IOException {
        response.getWriter().write(exception.getMessage());
    }
}
