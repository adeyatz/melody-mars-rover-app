package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.Position;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    public void testCartesianPositionConstructor() {

        Position position = new CartesianPosition(0,0);
        assertNotNull( position );
    }

    @Test
    void testEqualsCartesianPosition() {
        Position p1 = new CartesianPosition(0, 0);
        Position p2 = new CartesianPosition( 0, 0);

        assertEquals( p1, p1);  // Same object
        assertEquals( p1, p2);  // Same coordinates
    }


    @Test
    void testEqualsCartesianPosition55() {
        Position p1 = new CartesianPosition(5, 5);
        Position p2 = new CartesianPosition( 5, 5);

        assertEquals( p1, p2);  // Same coordinates
    }


    @Test
    void testNotEqualsCartesianPositionIncNull() {
        Position p1 = new CartesianPosition(0, 0);
        Position p2 = new CartesianPosition( 1, 0);
        Position p3 = new CartesianPosition( 0, 1);

        assertNotEquals( p1, p2);
        assertNotEquals( p1, p3);
        assertNotEquals( p2, p3);
        assertNotEquals( p1, null);
    }


    @Test
    void testGetAdjacentPosition() {
        Position p1 = new CartesianPosition( 0, 0);

        Position pN = p1.getNextDoor(Position.NextDoor.N);
        Position pNE = p1.getNextDoor(Position.NextDoor.NE);
        Position pE = p1.getNextDoor(Position.NextDoor.E);
        Position pSE = p1.getNextDoor(Position.NextDoor.SE);
        Position pS = p1.getNextDoor(Position.NextDoor.S);
        Position pSW = p1.getNextDoor(Position.NextDoor.SW);
        Position pW = p1.getNextDoor(Position.NextDoor.W);
        Position pNW = p1.getNextDoor(Position.NextDoor.NW);

        assertEquals(new CartesianPosition(0, 1), pN);
        assertEquals(new CartesianPosition(1, 1), pNE);
        assertEquals(new CartesianPosition(1, 0), pE);
        assertEquals(new CartesianPosition(1, -1), pSE);
        assertEquals(new CartesianPosition(0, -1), pS);
        assertEquals(new CartesianPosition(-1, -1), pSW);
        assertEquals(new CartesianPosition(-1, 0), pW);
        assertEquals(new CartesianPosition(-1, 1), pNW);

    }


    @Test
    void testToStringMethod() {
        Position p1 = new CartesianPosition( 0, 0);

        assertEquals("0 0", p1.toString());
        assertEquals("-1 -1", p1.getNextDoor(Position.NextDoor.SW).toString());
    }

    @Test
    void testToStringMethodBigNumbers() {
        Position p1 = new CartesianPosition( 1000, 99999);

        assertEquals("1000 99999", p1.toString());
    }


    @Test
    void testCompareToMethodLessThan() {
        Position p1 = new CartesianPosition(0, 0);

        int expected = -1;

        assertEquals(expected, p1.compareTo(new CartesianPosition(-1, 0)));
        assertEquals(expected, p1.compareTo(new CartesianPosition( 0, -1)));
        assertEquals(expected, p1.compareTo(new CartesianPosition(-1, -1)));
        assertEquals(expected, p1.compareTo(new CartesianPosition(-1, 1000)));
    }

    @Test
    void testCompareToMethodEquals() {
        Position p1 = new CartesianPosition(0, 0);

        int expected = 0;

        assertEquals(expected, p1.compareTo(p1));
        assertEquals(expected, p1.compareTo(new CartesianPosition( 0, 0)));

        p1 = new CartesianPosition(1000, 999);
        assertEquals(expected, p1.compareTo(new CartesianPosition(1000, 999)));

        p1 = new CartesianPosition(-333, -222);
        assertEquals(expected, p1.compareTo(new CartesianPosition(-333, -222)));
    }

    @Test
    void testCompareToMethodGreaterThan() {
        Position p1 = new CartesianPosition(0, 0);

        int expected = 1;

        assertEquals(expected, p1.compareTo(new CartesianPosition(1, 0)));
        assertEquals(expected, p1.compareTo(new CartesianPosition( 0, 1)));
        assertEquals(expected, p1.compareTo(new CartesianPosition(1000, 999)));
        assertEquals(expected, p1.compareTo(new CartesianPosition(0, 1000)));
    }

}