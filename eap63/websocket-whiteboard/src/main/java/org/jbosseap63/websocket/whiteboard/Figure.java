package org.jbosseap63.websocket.whiteboard;

/**
 * @author Arun Gupta
 */
public class Figure {
    String shape;
    String color;
    Coordinates coords;

    @Override
    public String toString() {
        return "Figure{" + "shape=" + shape + ", color=" + color + ", coords=" + coords + '}';
    }
}
