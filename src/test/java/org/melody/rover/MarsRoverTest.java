package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.IDirection;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {

    @Test
    void testMarsRoverConstructor() {
        Position position = new CartesianPosition(2, 1);
        IDirection direction = new Compass(Compass.Bearing.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertNotNull(rover);
    }

    @Test
    void testMarsRoverGetPosition() {
        Position position = new CartesianPosition(2, 1);
        IDirection direction = new Compass(Compass.Bearing.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(position, rover.getPosition());
    }

    @Test
    void testMarsRoverGetDirection() {
        Position position = new CartesianPosition(2, 1);
        IDirection direction = new Compass(Compass.Bearing.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(direction.toString(), rover.getDirection().toString());
    }

    @Test
    void testMarsRoverToString() {
        Position position = new CartesianPosition(2, 1);
        IDirection direction = new Compass(Compass.Bearing.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(MarsRover.MARS_ROVER,  rover.toString());
    }




}