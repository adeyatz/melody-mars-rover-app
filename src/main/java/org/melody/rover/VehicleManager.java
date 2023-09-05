package org.melody.rover;

import org.melody.rover.api.IBlocked;
import org.melody.rover.api.IPlateau;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

import java.util.ArrayList;

public class VehicleManager implements IBlocked {
    private ArrayList<Vehicle> vehicles;
    private Vehicle currentVehicle;

    public VehicleManager () {
        vehicles = new ArrayList<Vehicle>();
        currentVehicle = null;
    }

    public void addVehicle (Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public boolean removeVehicle (Vehicle vehicle) {
        return vehicles.remove(vehicle);
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    public Vehicle getVehicle (Position position) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPosition().equals(position))
                return vehicle;
        }

        return null;
    }


    @Override
    public boolean isPositionBlocked(Position newPosition) {

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPosition().equals(newPosition))
                return true;
        }

        return false;
    }
}
