package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.Rotator;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {

    @Test
    void testMarsRoverConstructor() {
        Position position = new CartesianPosition(2, 1);
        Rotator direction = new CompassRotator(Rotator.Heading.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertNotNull(rover);
    }


    @Test
    void testMarsRoverConvenienceConstructor() {
        Vehicle rover = new MarsRover (10, 20, Rotator.Heading.EAST);
        assertNotNull(rover);
        String expected = "10 20 E";
        assertEquals(expected, rover.toString());
        assertEquals(new CartesianPosition(10, 20), rover.getPosition());
    }


    @Test
    void testMarsRoverGetPosition() {
        Position position = new CartesianPosition(2, 1);
        Rotator direction = new CompassRotator(Rotator.Heading.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(position, rover.getPosition());
    }

    @Test
    void testMarsRoverGetDirection() {
        Position position = new CartesianPosition(2, 1);
        Rotator direction = new CompassRotator(Rotator.Heading.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(direction.toString(), rover.getRotation().toString());
    }

    @Test
    void testMarsRoverGetType() {
        Position position = new CartesianPosition(2, 1);
        Rotator direction = new CompassRotator(Rotator.Heading.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(MarsRover.MARS_ROVER,  rover.getType());
    }

    @Test
    void testMarsRoverToString() {
        Position position = new CartesianPosition(2, 1);
        Rotator direction = new CompassRotator(Rotator.Heading.SOUTH);
        String expected = "2 1 S";
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(expected,  rover.toString());

        expected = "2 1 W";
        rover.rotateRight();
        assertEquals(expected,  rover.toString());

        expected = "-999 10101 E";
        position = new CartesianPosition(-999, 10101);
        rover = new MarsRover(position, new CompassRotator(Rotator.Heading.EAST));
        assertEquals(expected,  rover.toString());
    }



    @Test
    void testMarsRoverMoves() {
        Position startPosition = new CartesianPosition(2, 1);
        Rotator direction = new CompassRotator(Rotator.Heading.SOUTH);

        Position expectedPosition = new CartesianPosition(2, 0);

        Vehicle rover = new MarsRover(startPosition, direction);

        moveRover(rover);
        assertEquals(expectedPosition, rover.getPosition());

        rover.rotateLeft();     // EAST
        moveRover(rover);
        moveRover(rover);
        expectedPosition = new CartesianPosition(4, 0);

        assertEquals(expectedPosition, rover.getPosition());
    }


    @Test
    void testMarsRoverMovesSet1() {
        // Initial position 1 2 N

        Position startPosition = new CartesianPosition(1, 2);
        String expected = "1 3 N";

        Rotator direction = new CompassRotator(Rotator.Heading.NORTH);

        Vehicle rover = new MarsRover(startPosition, direction);

        //Move input: LMLMLMLMM
        rover.rotateLeft();
        moveRover(rover);
        rover.rotateLeft();
        moveRover(rover);
        rover.rotateLeft();
        moveRover(rover);
        rover.rotateLeft();
        moveRover(rover);
        moveRover(rover);

        assertEquals(expected, rover.toString());
    }

    @Test
    void testMarsRoverMovesSet2() {
        // Initial position 3 3 E
        String expected = "5 1 E";

        Position startPosition = new CartesianPosition(3, 3);

        Rotator direction = new CompassRotator(Rotator.Heading.EAST);

        Vehicle rover = new MarsRover(startPosition, direction);

        //Move input: MMRMMRMRRM
        moveRover(rover);
        moveRover(rover);
        rover.rotateRight();
        moveRover(rover);
        moveRover(rover);
        rover.rotateRight();
        moveRover(rover);
        rover.rotateRight();
        rover.rotateRight();
        moveRover(rover);

        assertEquals(expected, rover.toString());
    }

    void moveRover (Vehicle rover) {
        Position nextPos = rover.getPosition().getNeighbour(rover.getRotation().getHeading());
        rover.move(nextPos);
    }
}