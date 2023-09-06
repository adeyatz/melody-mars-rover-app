package org.melody.rover;

import org.melody.rover.api.Plateau;
import org.melody.rover.api.Vehicle;

public class MarsRoverManager {
    Plateau plateau;
    VehicleManager vm;
    Vehicle currentVehicle;

    public MarsRoverManager() {
        plateau = null;
        currentVehicle = null;
        vm = new VehicleManager();
    }



}
