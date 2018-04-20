package try5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import try5.LevelController;
import try5.Vehicle.VehicleTypeAllowed;
import try5.Level;

public class ParkingSystem {

	public static void main(String args[]) {
		Logger LOGGER = Logger.getLogger(ParkingSystem.class.getName());
	
		LevelController levelController = new LevelController();
		ArrayList<Vehicle> listOfVehicle = new ArrayList<Vehicle>();
		HashMap<String, Vehicle> parkingIdAndVehicle = new HashMap<String, Vehicle>();
		Vehicle vehicleCreation;

		LOGGER.info("Inside parking System");

		Scanner scan = new Scanner(System.in);
		String vehicleType = "";
		String uniqueId = "";
		String ownerName = "";
		String userAction = "";
		
		while (!userAction.equals("exit")) {

			System.out.println("Do you wish to park or unpark or exit?");
			userAction = scan.nextLine();
			try {
				if (userAction.equals("park")) {
					System.out.println("Enter the type of vehicle to park?");
					vehicleType = scan.nextLine();
					vehicleType = vehicleType.toUpperCase();
					System.out.println("Enter the registration Id of vehicle to park?");
					uniqueId = scan.nextLine();
					System.out.println("Enter the owner Name of vehicle to park?");
					ownerName = scan.nextLine();

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
								LOGGER.info("Your vehicle is succesfully parked...ID is--> " + availableLevel.levelId
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
								LOGGER.info("Your Vehicle -- " + vehicleInId.vehicleType + " --is unparked now..");
								break;
							}
						}
					}
				}
			} catch (InputMismatchException e) {
				LOGGER.severe("Enter a proper Input" + e);

			}
		}
	}
}
