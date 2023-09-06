package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.Position;
import org.melody.rover.api.Rotator;
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
        Rotator heading = new CompassRotator(Rotator.Heading.WEST);
        Vehicle vehicle = new MarsRover (position, heading);
        vm.addVehicle(vehicle);

        assertEquals(1, vm.getVehicleCount());
    }

    @Test
    void testRemoveVehicle() {
        VehicleManager vm = new VehicleManager();

        Vehicle vehicle = new MarsRover (99,-100, "N");
        vm.addVehicle(vehicle);
        assertEquals(1, vm.getVehicleCount());

        assertTrue(vm.removeVehicle(vehicle));
        assertEquals(0, vm.getVehicleCount());
        assertFalse(vm.removeVehicle(vehicle));
    }


    @Test
    void testCanUsePosition () {
        VehicleManager vm = new VehicleManager();

        Vehicle vehicle = new MarsRover (0,0,"N");
        Position testPosition = new CartesianPosition(0, 0);
        assertTrue(vm.canUsePosition(testPosition));

        vm.addVehicle(vehicle);     // Position 0,0 should now be blocked by another vehicle
        assertFalse(vm.canUsePosition(testPosition));


        testPosition = new CartesianPosition(-1, 0);
        assertTrue(vm.canUsePosition(testPosition));
    }

    @Test
    void testGetVehicle() {
        VehicleManager vm = new VehicleManager();

        Vehicle vehicle = new MarsRover (99,0, "N");
        vm.addVehicle(vehicle);     // Position 0,0 should now be blocked by another vehicle

        assertEquals(vehicle, vm.getVehicle(new CartesianPosition(99,0)));
        assertNull(vm.getVehicle(new CartesianPosition(98,0)));
    }


}