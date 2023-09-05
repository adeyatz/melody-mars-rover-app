package org.melody.rover.api;

public abstract class Vehicle implements IMover, IRotator {
    protected Position position;
    protected IRotator rotation;

    private String type;

    public Vehicle (Position position, IRotator direction, String type) {
        this.position = position;
        this.rotation = direction;
        this.type = type;
    }

    public Position getPosition () {
        return position;
    }

    public Position getNextPosition () {
        return switch (rotation.getBearing()) {
            case NORTH -> position.getNextDoor(Position.NextDoor.N);
            case EAST -> position.getNextDoor(Position.NextDoor.E);
            case SOUTH -> position.getNextDoor(Position.NextDoor.S);
            case WEST -> position.getNextDoor(Position.NextDoor.W);
        };
    }

    public void rotateRight() {
        rotation.rotateRight();
    }

    public void rotateLeft() {
        rotation.rotateLeft();
    }

    public Bearing getBearing() {
        return rotation.getBearing();
    }

    public IRotator getRotation() {
        return rotation;
    }

    public String toString () {
        return type;
    }

}
