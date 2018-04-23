package park;

import java.util.HashMap;
import java.util.logging.Logger;

import park.Vehicle.VehicleTypeAllowed;

public class Level {

	String levelId;
	HashMap<VehicleTypeAllowed, Integer> vehicleTypeAndCount;
	Logger LOGGER = Logger.getLogger(Level.class.getName());


	Level(String levelId, HashMap<VehicleTypeAllowed, Integer> vehicleTypeAndCount) {
		this.levelId = levelId;
		this.vehicleTypeAndCount = vehicleTypeAndCount;
	}

	int parkingNumber = 100;
	String parkingId = "";
	HashMap<String, Vehicle> parkingIdAndVehicle = new HashMap<String, Vehicle>();

	public  HashMap<String, Vehicle> parkVehicle(Vehicle vehicle) {
		try {
		if (vehicleTypeAndCount.get(vehicle.vehicleType) > 0) {
			parkingId = Integer.toString(parkingNumber++);
			parkingIdAndVehicle.put(levelId + parkingId, vehicle);
		}
		return parkingIdAndVehicle;
		}catch(Exception e) {
			LOGGER.info("Please enter proper level to park");
			
		}
		return null;
	}

	public Vehicle unParkVehicle(String userParkingId) {
		Vehicle vehicleInId = null;
		if (parkingIdAndVehicle.containsKey(userParkingId)) {
			vehicleInId = parkingIdAndVehicle.get(userParkingId);
			parkingIdAndVehicle.remove(userParkingId);
		} else {
			System.out.println("Please Enter a proper parkingId");
		}

		return vehicleInId;
	}
}
