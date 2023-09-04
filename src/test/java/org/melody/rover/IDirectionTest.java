package org.melody.rover;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IDirectionTest {

    @Test
    void testRotateLeft() {
        IDirection direction = new Compass(Compass.Bearing.NORTH);

        direction.rotateLeft();
        assertEquals("W", direction.toString());

        direction.rotateLeft();
        assertEquals("S", direction.toString());

        direction.rotateLeft();
        assertEquals("E", direction.toString());

        direction.rotateLeft();
        assertEquals("N", direction.toString());
    }

    @Test
    void testRotateRight() {
        IDirection direction = new Compass(Compass.Bearing.NORTH);

        direction.rotateRight();
        assertEquals("E", direction.toString());

        direction.rotateRight();
        assertEquals("S", direction.toString());

        direction.rotateRight();
        assertEquals("W", direction.toString());

        direction.rotateRight();
        assertEquals("N", direction.toString());
    }




    @Test
    void testGetNextMovePosition() {
        IDirection direction = new Compass(Compass.Bearing.NORTH);

        Position currentPosition = new CartesianPosition(0,0);
        Position expectedPosition = new CartesianPosition(0,1);

        assertEquals(expectedPosition, direction.getNextMovePosition(currentPosition));
    }


    @Test
    void testGetNextMovePositionBigGrid() {
        IDirection direction = new Compass(Compass.Bearing.EAST);

        Position currentPosition = new CartesianPosition(500,800);
        Position expectedPosition = new CartesianPosition(501,800);

        assertEquals(expectedPosition, direction.getNextMovePosition(currentPosition));
    }



    @Test
    void testPositionAndRotateTestCase1() {
        // Run the test sample 1 2 N, LMLMLMLMM
        // 1 2 N
        Position currentPosition = new CartesianPosition(1,2);
        IDirection direction = new Compass(Compass.Bearing.NORTH);

        String expected = "1 3 N";

        // LMLMLMLMM
        direction.rotateLeft();
        currentPosition = direction.getNextMovePosition(currentPosition);
        direction.rotateLeft();
        currentPosition = direction.getNextMovePosition(currentPosition);
        direction.rotateLeft();
        currentPosition = direction.getNextMovePosition(currentPosition);
        direction.rotateLeft();
        currentPosition = direction.getNextMovePosition(currentPosition);
        currentPosition = direction.getNextMovePosition(currentPosition);

        assertEquals(expected, String.format("%s %s", currentPosition.toString(), direction.toString()));
    }



    @Test
    void testPositionAndRotateTestCase2() {
        // Run the test sample 3 3 E, MMRMMRMRRM
        // 3 3 E
        Position currentPosition = new CartesianPosition(3, 3);
        IDirection direction = new Compass(Compass.Bearing.EAST);

        String expected = "5 1 E";

        //MMRMMRMRRM
        currentPosition = direction.getNextMovePosition(currentPosition);
        currentPosition = direction.getNextMovePosition(currentPosition);
        direction.rotateRight();
        currentPosition = direction.getNextMovePosition(currentPosition);
        currentPosition = direction.getNextMovePosition(currentPosition);
        direction.rotateRight();
        currentPosition = direction.getNextMovePosition(currentPosition);
        direction.rotateRight();
        direction.rotateRight();
        currentPosition = direction.getNextMovePosition(currentPosition);

        assertEquals(expected, String.format("%s %s", currentPosition.toString(), direction.toString()));
    }


    @Test
    void testToStringMethodNorthEastSouthWest() {
        IDirection dirN = new Compass(Compass.Bearing.NORTH);
        IDirection dirE = new Compass(Compass.Bearing.EAST);
        IDirection dirS = new Compass(Compass.Bearing.SOUTH);
        IDirection dirW = new Compass(Compass.Bearing.WEST);

        assertEquals("N", dirN.toString());
        assertEquals("E", dirE.toString());
        assertEquals("S", dirS.toString());
        assertEquals("W", dirW.toString());
    }
}