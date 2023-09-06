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
/*
    public Position getNextPosition () {
        return switch (rotation.getHeading()) {
            case NORTH -> position.getNeighbour(Position.Neighbour.N);
            case EAST -> position.getNeighbour(Position.Neighbour.E);
            case SOUTH -> position.getNeighbour(Position.Neighbour.S);
            case WEST -> position.getNeighbour(Position.Neighbour.W);
        };
    }
*/
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
        return String.format("%s %s", type, printPostion());
    }


    public String printPostion() {
        return String.format("%s %s", position.toString(), rotation.toString());
    }
}
