package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.IRotator;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class VehicleManagerTest {

    @Test
    void testVehicleManagerConstructor() {
        VehicleManager vm = new VehicleManager();

        assertNotNull(vm);
    }



    @Test
    void testAddVehicle() {
        VehicleManager vm = new VehicleManager();

        Position position = new CartesianPosition(10, 50);
        IRotator heading = new Compass(IRotator.Heading.WEST);
        Vehicle vehicle = new MarsRover (position, heading);
        vm.addVehicle(vehicle);

        assertEquals(1, vm.getVehicleCount());
    }

    @Test
    void testRemoveVehicle() {
        VehicleManager vm = new VehicleManager();

        Vehicle vehicle = new MarsRover (99,-100, IRotator.Heading.NORTH);
        vm.addVehicle(vehicle);
        assertEquals(1, vm.getVehicleCount());

        assertTrue(vm.removeVehicle(vehicle));
        assertEquals(0, vm.getVehicleCount());
        assertFalse(vm.removeVehicle(vehicle));
    }


    @Test
    void testIsPositionBlocked() {
        VehicleManager vm = new VehicleManager();

        Vehicle vehicle = new MarsRover (0,0, IRotator.Heading.NORTH);
        vm.addVehicle(vehicle);     // Position 0,0 should now be blocked by another vehicle

        Position testPosition = new CartesianPosition(0, 0);
        assertTrue(vm.isPositionBlocked(testPosition));

        testPosition = new CartesianPosition(-1, 0);
        assertFalse(vm.isPositionBlocked(testPosition));

    }

    @Test
    void testGetVehicle() {
        VehicleManager vm = new VehicleManager();

        Vehicle vehicle = new MarsRover (99,0, IRotator.Heading.NORTH);
        vm.addVehicle(vehicle);     // Position 0,0 should now be blocked by another vehicle

        assertEquals(vehicle, vm.getVehicle(new CartesianPosition(99,0)));
        assertNull(vm.getVehicle(new CartesianPosition(98,0)));
    }
}