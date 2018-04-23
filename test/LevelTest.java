package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import park.Level;
import park.LevelController;
import park.Vehicle;
import park.Vehicle.VehicleTypeAllowed;

class LevelTest {

	HashMap<String, Vehicle> parkingIdAndVehicle = new HashMap<String, Vehicle>();
	LevelController levelController = new LevelController();
	Vehicle vehicleCar;
	Vehicle vehicleBus;

	@BeforeEach
	void setUp() throws Exception {
		VehicleTypeAllowed userVehicleType = Vehicle.VehicleTypeAllowed.valueOf("CAR");
		VehicleTypeAllowed userVehicle = Vehicle.VehicleTypeAllowed.valueOf("BUS");
		vehicleCar = new Vehicle(userVehicleType, "TN58CH89", "owner1");
		vehicleBus = new Vehicle(userVehicle, "KA67BN8976", "ownerbus");
		parkingIdAndVehicle.put("A100", vehicleCar);
	}

	@Test
	void testParkVehicle() {

		assertEquals(levelController.level1, levelController.getLevelForParking(vehicleCar));
		assertEquals(parkingIdAndVehicle.keySet(), levelController.level1.parkVehicle(vehicleCar).keySet());

	}

	@Test
	void testUnparkVehicle() {
		
		assertEquals(null, levelController.getLevelForUnParking("v67"));
		levelController.level1.parkVehicle(vehicleCar);
		assertTrue(levelController.level1.unParkVehicle("A100").equals(vehicleCar));
		assertEquals(null, levelController.level1.unParkVehicle("A101"));
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	void doCheckingException() {
		exception.expect(NullPointerException.class);
		exception.expectMessage("Invalid Level");
		levelController.level1.parkVehicle(vehicleBus);
		exception.expect(IllegalArgumentException.class);
		//Vehicle.VehicleTypeAllowed.valueOf("CYCLE");


	}

}
