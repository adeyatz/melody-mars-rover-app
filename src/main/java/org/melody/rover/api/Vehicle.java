package org.melody.rover.api;

public abstract class Vehicle implements IMover {
    private Position position;
    private IDirection direction;

    private String type;

    public Vehicle (Position position, IDirection direction, String type) {
        this.position = position;
        this.direction = direction;
        this.type = type;
    }

    public Position getPosition () {
        return position;
    }

    public IDirection getDirection () {
        return direction;
    }

    public String toString () {
        return type;
    }

}
