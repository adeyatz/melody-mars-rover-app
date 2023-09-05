package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.IRotator;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {

    @Test
    void testMarsRoverConstructor() {
        Position position = new CartesianPosition(2, 1);
        IRotator direction = new Compass(Compass.Bearing.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertNotNull(rover);
    }

    @Test
    void testMarsRoverGetPosition() {
        Position position = new CartesianPosition(2, 1);
        IRotator direction = new Compass(Compass.Bearing.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(position, rover.getPosition());
    }

    @Test
    void testMarsRoverGetDirection() {
        Position position = new CartesianPosition(2, 1);
        IRotator direction = new Compass(Compass.Bearing.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(direction.toString(), rover.getRotation().toString());
    }

    @Test
    void testMarsRoverToString() {
        Position position = new CartesianPosition(2, 1);
        IRotator direction = new Compass(Compass.Bearing.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(MarsRover.MARS_ROVER,  rover.toString());
    }

    @Test
    void testMarsRoverMoves() {
        Position startPosition = new CartesianPosition(2, 1);
        IRotator direction = new Compass(Compass.Bearing.SOUTH);

        Position expectedPosition = new CartesianPosition(2, 0);

        Vehicle rover = new MarsRover(startPosition, direction);
        rover.move();
        assertEquals(expectedPosition, rover.getPosition());

        rover.rotateLeft();     // EAST
        rover.move();           // 3,0
        rover.move();           // 4,0
        expectedPosition = new CartesianPosition(4, 0);

        assertEquals(expectedPosition, rover.getPosition());

    }


}