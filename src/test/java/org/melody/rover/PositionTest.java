package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.Position;
import org.melody.rover.api.Rotator;

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

        Position pN = p1.getNeighbour(Rotator.Heading.NORTH);
        Position pE = p1.getNeighbour(Rotator.Heading.EAST);
        Position pS = p1.getNeighbour(Rotator.Heading.SOUTH);
        Position pW = p1.getNeighbour(Rotator.Heading.WEST);

        assertEquals(new CartesianPosition(0, 1), pN);
        assertEquals(new CartesianPosition(1, 0), pE);
        assertEquals(new CartesianPosition(0, -1), pS);
        assertEquals(new CartesianPosition(-1, 0), pW);
    }


    @Test
    void testToStringMethod() {
        Position p1 = new CartesianPosition( 0, 0);

        assertEquals("0 0", p1.toString());
        assertEquals("-1 -1", p1.getNeighbour(Rotator.Heading.SOUTH).getNeighbour(Rotator.Heading.WEST).toString());
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