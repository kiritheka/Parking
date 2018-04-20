package try5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import try5.LevelController;
import try5.Vehicle.VehicleTypeAllowed;
import try5.Level;

public class ParkingSystem {

	public static void main(String args[]) {
		LevelController levelController = new LevelController();
		ArrayList<Vehicle> listOfVehicle = new ArrayList<Vehicle>();
		HashMap<String, Vehicle> parkingIdAndVehicle = new HashMap<String, Vehicle>();
		Vehicle vehicleCreation;

		Scanner scan = new Scanner(System.in);
		String userAction = "";
		while (!userAction.equals("exit")) {

			System.out.println("Do you wish to park or unpark or exit?");
			userAction = scan.nextLine();

			if (userAction.equals("park")) {
				System.out.println("Enter the type of vehicle to park?");
				String vehicleType = scan.nextLine();
				vehicleType = vehicleType.toUpperCase();
				System.out.println("Enter the registration Id of vehicle to park?");
				String uniqueId = scan.nextLine();
				System.out.println("Enter the owner Name of vehicle to park?");
				String ownerName = scan.nextLine();

				VehicleTypeAllowed userVehicleType = Vehicle.VehicleTypeAllowed.valueOf(vehicleType);
				vehicleCreation = new Vehicle(userVehicleType, uniqueId, ownerName);
				listOfVehicle.add(vehicleCreation);

				if ((Vehicle.VehicleTypeAllowed.valueOf(vehicleType)) != null) {
					for (Level availableLevel : levelController.getlistOfLevel()) {
						int count = 0;
						for (Vehicle iterable_element : availableLevel.parkingIdAndVehicle.values()) {
							if (iterable_element.vehicleType.equals(vehicleCreation.vehicleType)) {
								count++;
							}
						}
						if ((availableLevel.vehicleTypeAndCount
								.containsKey(Vehicle.VehicleTypeAllowed.valueOf(vehicleType))
								&& (count < availableLevel.vehicleTypeAndCount.get(vehicleCreation.vehicleType)))) {
							parkingIdAndVehicle.putAll(availableLevel.parkVehicle(vehicleCreation));
							System.out.println("Your vehicle is succesfully parked...ID is--> " + availableLevel.levelId
									+ availableLevel.parkingId);
							break;
						} else {
							System.out.println("Sorry No more space available in the level");
						}
					}
				}
			} else if (userAction.equals("unpark")) {
				System.out.println("Enter the Parking Id to unpark your Vehicle?");
				String userParkingId = scan.next();
				for (Level availableLevel : levelController.getlistOfLevel()) {
					if (availableLevel.parkingIdAndVehicle.containsKey(userParkingId)) {
						Vehicle vehicleInId = availableLevel.unParkVehicle(userParkingId);
						if (vehicleInId != null) {
							parkingIdAndVehicle.remove(userParkingId);
							System.out.println("Your Vehicle -- " + vehicleInId.vehicleType + " --is unparked now..");
							break;
						}
					}
				}
			} else {
				System.out.println("Please....Enter a proper value action to follow");
			}
		}
	}
}