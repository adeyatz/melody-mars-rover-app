package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.IRotator;

import static org.junit.jupiter.api.Assertions.*;

class IRotatorTest {

    @Test
    void testRotateLeft() {
        IRotator direction = new Compass(IRotator.Heading.NORTH);

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
        IRotator direction = new Compass(IRotator.Heading.NORTH);

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
    void testToStringMethodNorthEastSouthWest() {
        IRotator dirN = new Compass(IRotator.Heading.NORTH);
        IRotator dirE = new Compass(IRotator.Heading.EAST);
        IRotator dirS = new Compass(IRotator.Heading.SOUTH);
        IRotator dirW = new Compass(IRotator.Heading.WEST);

        assertEquals("N", dirN.toString());
        assertEquals("E", dirE.toString());
        assertEquals("S", dirS.toString());
        assertEquals("W", dirW.toString());
    }
}