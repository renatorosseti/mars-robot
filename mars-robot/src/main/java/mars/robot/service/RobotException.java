package mars.robot.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Renato Rosseti on 26/01/17.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RobotException extends RuntimeException {
    public RobotException(String message) {
        super(message);
    }
}
