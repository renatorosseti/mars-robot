package mars.robot.entity;

/**
 * Created by Renato Rosseti on 25/01/17.
 */
public class Robot {
    private Space position;

    public Robot() {
        this.position = new Space();
    }

    public void move(String inputMotion) {
        Motion rotateLeft = new MoveLeft();
        Motion rotateRight = new MoveRight();
        Motion moveStraight = new MoveStraight();

        String[] moves = inputMotion.split("");
        for (String move : moves) {
            if (move.equals("M")) {
                moveStraight.move(position);
            } else if (move.equals("L")) {
                rotateLeft.move(position);
            } else if (move.equals("R")) {
                rotateRight.move(position);
            }
        }
    }

    public Space getPosition() {
        return position;
    }
}
