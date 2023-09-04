package org.melody.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartesianPositionTest {

    @Test
    public void testCartesianPositionConstructor() {

        CartesianPosition position = new CartesianPosition(0,0);
        assertNotNull( position );
    }

    @Test
    void testEqualsCartesianPosition() {
        CartesianPosition p1 = new CartesianPosition(0, 0);
        CartesianPosition p2 = new CartesianPosition( 0, 0);

        assertEquals( p1, p1);  // Same object
        assertEquals( p1, p2);  // Same coordinates
    }


    @Test
    void testEqualsCartesianPosition55() {
        CartesianPosition p1 = new CartesianPosition(5, 5);
        CartesianPosition p2 = new CartesianPosition( 5, 5);

        assertEquals( p1, p2);  // Same coordinates
    }


    @Test
    void testNotEqualsCartesianPosition() {
        CartesianPosition p1 = new CartesianPosition(0, 0);
        CartesianPosition p2 = new CartesianPosition( 1, 0);
        CartesianPosition p3 = new CartesianPosition( 0, 1);

        assertNotEquals( p1, p2);
        assertNotEquals( p1, p3);
        assertNotEquals( p2, p3);
    }


    @Test
    void getAdjacentPosition() {
        CartesianPosition p1 = new CartesianPosition( 0, 0);
        Position expected = new CartesianPosition( 0,1);
        Position pNorth = p1.getAdjacentPosition (Position.AdjacentPositions.N);
        assertEquals(expected, pNorth);
    }

    @Test
    void compareTo() {
    }
}