package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.melody.rover.api.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class MoverTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testMoves.csv", numLinesToSkip = 1)
    void testMoveVehicle (String startPosition, String moveInstructions, String expectedResult) {
        String[] stPos = startPosition.split(" ");
        assertEquals(3, stPos.length);
        assertTrue(stPos[2].matches("[NSEW]"));




/*       Vehicle vehicle = new MarsRover(Integer.parseInt(stPos[0]),
                                        Integer.parseInt(stPos[1]),
                                        new CompassRotator(stPos[2]));
*/
    }
}