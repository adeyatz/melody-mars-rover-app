package org.melody.rover;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IDirectionTest {

    @Test
    void rotateLeft() {
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
    void rotateRight() {
    }

    @Test
    void getNextMovePosition() {
        IDirection direction = new Compass(Compass.Bearing.NORTH);
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