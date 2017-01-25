package mars.robot.entity;

/**
 * Created by Renato Rosseti on 24/01/17.
 */
public enum Orientation {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private String acronym;

    Orientation(String acronym) {
        this.acronym = acronym;
    }
}
