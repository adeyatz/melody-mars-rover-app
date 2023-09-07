package org.melody.rover.api;

public abstract class Vehicle implements IMovable {
    protected Position position;
    protected Rotator rotation;

    private String type;

    public Vehicle (Position position, Rotator direction, String type) {
        this.position = position;
        this.rotation = direction;
        this.type = type;
    }

    public Position getPosition () {
        return position;
    }

    public void rotateRight() {
        rotation.rotateRight();
    }

    public void rotateLeft() {
        rotation.rotateLeft();
    }

    public Rotator getRotation() {
        return rotation;
    }

    public String getType () {
        return type;
    }

    public String toString () {
        return String.format("%s %s",position, rotation);
    }

}
