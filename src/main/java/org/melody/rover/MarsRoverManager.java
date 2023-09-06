package org.melody.rover;

import org.melody.rover.api.ICheckPosition;
import org.melody.rover.api.Plateau;
import org.melody.rover.api.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MarsRoverManager {
    Plateau plateau;
    VehicleManager vm;
    // TODO add MarsObjectManager
    Vehicle currentVehicle;

    ArrayList < ICheckPosition> pChecker;

    public MarsRoverManager() {
        plateau = null;
        currentVehicle = null;
        vm = new VehicleManager();
    }


    public void createPlateau(int width, int height) {
        plateau = new RectangularCartesianPlateau(width,height);
        pChecker = new ArrayList<>(List.of (plateau, vm));      // TODO add MarsObjectManager to this list so we check for mars obstructions too
    }


    public void createMarsRover(int x, int y, String heading) {
        if (pChecker == null)
            throw new IllegalArgumentException("Must create Plateau before creating a Mars Rover");

        // First check that the space is free
        if (CheckPosition.check(pChecker, new CartesianPosition(x,y))) {
            currentVehicle = new MarsRover(x, y, heading);
            vm.addVehicle(currentVehicle);
        }
    }
}
