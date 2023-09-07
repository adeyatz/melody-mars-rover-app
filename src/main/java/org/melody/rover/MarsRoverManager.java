package org.melody.rover;

import org.melody.rover.api.ICheckPosition;
import org.melody.rover.api.Plateau;
import org.melody.rover.api.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MarsRoverManager {
    Plateau plateau;
    VehicleManager vm;
    ArrayList < ICheckPosition> positionCheckers;
    // TODO add MarsObjectManager object
    public MarsRoverManager() {
        plateau = null;
        vm = new VehicleManager();
    }


    public void createPlateau(int width, int height) {
        plateau = new RectangularCartesianPlateau(width,height);
        positionCheckers = new ArrayList<>(List.of (plateau, vm));      // TODO add MarsObjectManager to this list so we check for mars obstructions too
    }


    public Vehicle createMarsRover(int x, int y, String heading) {
        if (positionCheckers == null)
            throw new IllegalArgumentException("Must create Plateau before creating a Mars Rover");

        // First check that the space is free
        if (CheckPosition.check(positionCheckers, new CartesianPosition(x,y))) {
            Vehicle newMarsRover = new MarsRover(x, y, heading);
            vm.addVehicle(newMarsRover);
            return newMarsRover;
        }
        throw new IllegalArgumentException("Mars Rover must be located on the plateau in an empty cell");
    }

    public VehicleManager getVehicleManager() {
        return vm;
    }

    public String moveMarsRover(Vehicle rover, String moveInstructions) {
        if (positionCheckers == null)
            throw new IllegalArgumentException("Must create Plateau before creating a Mars Rover");

        Mover mover = new Mover(positionCheckers,rover,moveInstructions);

        mover.moveVehicle();
        return rover.printPostion();
    }
}
