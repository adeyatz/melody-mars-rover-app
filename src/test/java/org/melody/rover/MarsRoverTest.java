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
        IRotator direction = new Compass(IRotator.Heading.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertNotNull(rover);
    }

    @Test
    void testMarsRoverGetPosition() {
        Position position = new CartesianPosition(2, 1);
        IRotator direction = new Compass(IRotator.Heading.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(position, rover.getPosition());
    }

    @Test
    void testMarsRoverGetDirection() {
        Position position = new CartesianPosition(2, 1);
        IRotator direction = new Compass(IRotator.Heading.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(direction.toString(), rover.getRotation().toString());
    }

    @Test
    void testMarsRoverGetType() {
        Position position = new CartesianPosition(2, 1);
        IRotator direction = new Compass(IRotator.Heading.SOUTH);
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(MarsRover.MARS_ROVER,  rover.getType());
    }

    @Test
    void testMarsRoverToString() {
        Position position = new CartesianPosition(2, 1);
        IRotator direction = new Compass(IRotator.Heading.SOUTH);
        String expected = "2 1 S";
        Vehicle rover = new MarsRover(position, direction);
        assertEquals(expected,  rover.toString());

        expected = "2 1 W";
        rover.rotateRight();
        assertEquals(expected,  rover.toString());

        expected = "-999 10101 E";
        position = new CartesianPosition(-999, 10101);
        rover = new MarsRover(position, new Compass (IRotator.Heading.EAST));
        assertEquals(expected,  rover.toString());
    }



    @Test
    void testMarsRoverMoves() {
        Position startPosition = new CartesianPosition(2, 1);
        IRotator direction = new Compass(IRotator.Heading.SOUTH);

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


    @Test
    void testMarsRoverMovesSet1() {
        // Initial position 1 2 N

        Position startPosition = new CartesianPosition(1, 2);
        String expected = "1 3 N";

        IRotator direction = new Compass(IRotator.Heading.NORTH);

        Vehicle rover = new MarsRover(startPosition, direction);

        //Move input: LMLMLMLMM
        rover.rotateLeft();
        rover.move();
        rover.rotateLeft();
        rover.move();
        rover.rotateLeft();
        rover.move();
        rover.rotateLeft();
        rover.move();
        rover.move();

        assertEquals(expected, rover.toString());
    }

    @Test
    void testMarsRoverMovesSet2() {
        // Initial position 3 3 E
        String expected = "5 1 E";

        Position startPosition = new CartesianPosition(3, 3);

        IRotator direction = new Compass(IRotator.Heading.EAST);

        Vehicle rover = new MarsRover(startPosition, direction);

        //Move input: MMRMMRMRRM
        rover.move();
        rover.move();
        rover.rotateRight();
        rover.move();
        rover.move();
        rover.rotateRight();
        rover.move();
        rover.rotateRight();
        rover.rotateRight();
        rover.move();

        assertEquals(expected, rover.toString());
    }

}