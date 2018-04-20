package park;

import java.util.ArrayList;
import java.util.HashMap;

import park.Level;
import park.Vehicle.VehicleTypeAllowed;

public class LevelController {

	HashMap<VehicleTypeAllowed, Integer> vehicleTypeAndCount1 = new HashMap<VehicleTypeAllowed, Integer>() {{
			put(Vehicle.VehicleTypeAllowed.BIKE, 2);
			put(Vehicle.VehicleTypeAllowed.CAR, 1);
		}};
	public Level level1 = new Level("A", vehicleTypeAndCount1);

	HashMap<VehicleTypeAllowed, Integer> vehicleTypeAndCount2 = new HashMap<VehicleTypeAllowed, Integer>() {{
			put(Vehicle.VehicleTypeAllowed.BIKE, 2);
			put(Vehicle.VehicleTypeAllowed.CAR, 1);
			put(Vehicle.VehicleTypeAllowed.VAN, 2);
		}};
	Level level2 = new Level("B", vehicleTypeAndCount2);

	HashMap<VehicleTypeAllowed, Integer> vehicleTypeAndCount3 = new HashMap<VehicleTypeAllowed, Integer>() {{
			put(Vehicle.VehicleTypeAllowed.CAR, 1);
			put(Vehicle.VehicleTypeAllowed.VAN, 2);
			put(Vehicle.VehicleTypeAllowed.BUS, 3);
		}};
	Level level3 = new Level("C", vehicleTypeAndCount3);

	public ArrayList<Level> getlistOfLevel() {
		ArrayList<Level> listOfLevel = new ArrayList<Level>();
		listOfLevel.add(level1);
		listOfLevel.add(level2);
		listOfLevel.add(level3);

		return listOfLevel;
	}

	public Level getLevelForParking(Vehicle vehicleCreation) {

		for (Level availableLevel : getlistOfLevel()) {
			int count = 0;
			for (Vehicle iterable_element : availableLevel.parkingIdAndVehicle.values()) {
				if (iterable_element.vehicleType.equals(vehicleCreation.vehicleType)) {
					count++;
				}
			}
			if ((availableLevel.vehicleTypeAndCount.containsKey(vehicleCreation.vehicleType)
					&& (count < availableLevel.vehicleTypeAndCount.get(vehicleCreation.vehicleType)))) {
				
				return availableLevel;
			}
		}
		return null;
	}
	
	public Level getLevelForUnParking(String userParkingId) {
		for (Level availableLevel : getlistOfLevel()) {
			if (availableLevel.parkingIdAndVehicle.containsKey(userParkingId)) {
				return availableLevel;
			}
		}
		return null;
	}
}