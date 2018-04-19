package try4;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import try4.Vehicle;

public class Level {

	String levelId;
	HashMap<String, Integer> vehicleTypeAndCount;

	Level(String levelId, HashMap<String, Integer> vehicleTypeAndCount) {
		this.levelId = levelId;
		this.vehicleTypeAndCount = vehicleTypeAndCount;
	}
    int parkingNumber =100;
	String parkingId = "";
	HashMap<String, String> parkingIdAndVehicle = new HashMap<String, String>();

	public HashMap<String, String> parkVehicle(Vehicle vehicle) {
		if (vehicleTypeAndCount.get(vehicle.VehicleName.toString()) > 0) {
			
			
			
			
			
			
			/*vehicleTypeAndCount.put(vehicle.VehicleName.toString(),
					vehicleTypeAndCount.get(vehicle.VehicleName.toString()) - 1);*/
			parkingId = Integer.toString(parkingNumber++);	
			parkingIdAndVehicle.put(levelId+parkingId, vehicle.VehicleName.toString());
			System.out.println(parkingIdAndVehicle);
			Collection<String> vehicleInlevel = parkingIdAndVehicle.values();
			Set<Vehicle> containSet = new HashSet<>();

			for (String vehicleSingle : vehicleInlevel) {
			 System.out.println( Collections.frequency(vehicleInlevel,vehicleSingle)+"count////");
			}
		} else {
			System.out.println(" No more space in this level");
		}

		return parkingIdAndVehicle;
	}

	public String unParkVehicle(String userParkingId) {
		String vehicleInId = "";
		if (parkingIdAndVehicle.containsKey(userParkingId)) {
			vehicleInId = parkingIdAndVehicle.get(userParkingId);
			parkingIdAndVehicle.remove(userParkingId);
			vehicleTypeAndCount.put(vehicleInId, vehicleTypeAndCount.get(vehicleInId) + 1);
		} else {
			System.out.println("Please Enter a proper a parkingId");
		}
		
		return vehicleInId;
	}
}
