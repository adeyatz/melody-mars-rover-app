package org.melody.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartesianPositionTest {

    @Test
    public void testCartesianPostionContructor() {

        CartesianPosition position = new CartesianPosition(0,0);
        assertNotNull( position );
    }

    @Test
    void testEquals() {
    }

    @Test
    void getAdjacentPosition() {
    }

    @Test
    void compareTo() {
    }
}