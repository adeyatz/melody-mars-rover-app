package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.melody.rover.api.ICheckPosition;
import org.melody.rover.api.Plateau;
import org.melody.rover.api.Rotator;
import org.melody.rover.api.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoverTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/MoverTest.csv")
    void testMoveVehicle (String startPosition, String moveInstructions, String expectedResult) {
        String[] stPos = startPosition.split(" ");
        assertEquals(3, stPos.length);
        assertTrue(stPos[2].matches("[NSEW]"));

        Vehicle vehicle = new MarsRover(Integer.parseInt(stPos[0]),
                                       Integer.parseInt(stPos[1]),
                                        stPos[2]);

        Plateau plateau = new RectangularCartesianPlateau(5, 5);

        ArrayList < ICheckPosition> pChecker = new ArrayList<>(List.of (plateau));

        Mover myMover = new Mover(pChecker, vehicle, moveInstructions);
        myMover.moveVehicle();

        assertEquals(expectedResult, vehicle.toString());

    }
}