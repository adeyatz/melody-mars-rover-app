package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.Rotator;

import static org.junit.jupiter.api.Assertions.*;

class RotatorTest {

    @Test
    void testRotateLeft() {
        Rotator rotator = new CompassRotator(Rotator.Heading.NORTH);

        rotator.rotateLeft();
        assertEquals("W", rotator.toString());

        rotator.rotateLeft();
        assertEquals("S", rotator.toString());

        rotator.rotateLeft();
        assertEquals("E", rotator.toString());

        rotator.rotateLeft();
        assertEquals("N", rotator.toString());
    }

    @Test
    void testRotateRight() {
        Rotator direction = new CompassRotator(Rotator.Heading.NORTH);

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
    void testConstructorWithString() {

        Rotator dirN = new CompassRotator ("N");
        assertEquals("N", dirN.toString());

         dirN = new CompassRotator ("S");
        assertEquals("S", dirN.toString());

         dirN = new CompassRotator ("E");
        assertEquals("E", dirN.toString());

        dirN = new CompassRotator ("W");
        assertEquals("W", dirN.toString());
    }

    @Test
    void testConstructorWithIllegalString() {

        try {
            Rotator dirN = new CompassRotator("Q");
            fail("Cunstructor should fail with input of Q");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Test
    void testToStringMethodNorthEastSouthWest() {
        Rotator dirN = new CompassRotator(Rotator.Heading.NORTH);
        Rotator dirE = new CompassRotator(Rotator.Heading.EAST);
        Rotator dirS = new CompassRotator(Rotator.Heading.SOUTH);
        Rotator dirW = new CompassRotator(Rotator.Heading.WEST);

        assertEquals("N", dirN.toString());
        assertEquals("E", dirE.toString());
        assertEquals("S", dirS.toString());
        assertEquals("W", dirW.toString());
    }
}