package org.melody.rover;

import org.melody.rover.api.ICheckPosition;
import org.melody.rover.api.Vehicle;

import java.util.ArrayList;

public class Mover {
    ArrayList<ICheckPosition> positionCheckers;
    Vehicle vehicle;
    String moveInstructions;
    public Mover (ArrayList<ICheckPosition> positionCheckers, Vehicle vehicle, String moveInstructions) {
        this.positionCheckers = positionCheckers;
        this.vehicle = vehicle;
        this.moveInstructions = moveInstructions;
    }

    public void moveVehicle () {

    }
}
