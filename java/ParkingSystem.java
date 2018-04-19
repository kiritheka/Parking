package try4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import try4.LevelController;
import try4.VehicleController;
import try4.Level;

public class ParkingSystem {
	ArrayList<Level> listOfCopyLevel = new ArrayList<Level>();

	public ArrayList<Level> getlistOfCopyLevel() {
		LevelController levelController = new LevelController();
		listOfCopyLevel.addAll(levelController.getlistOfLevel());

		return listOfCopyLevel;
	}

	public static void main(String args[]) {

		VehicleController vehicleController = new VehicleController();
		ParkingSystem parkingSystem = new ParkingSystem();
		HashMap<String, String> parkingIdAndVehicle = new HashMap<String, String>();

		Scanner scan = new Scanner(System.in);
		String userAction = "";
		while (!userAction.equals("exit")) {

			System.out.println("Do you wish to park or unpark or exit?");
			userAction = scan.nextLine();

			if (userAction.equals("park")) {
				System.out.println("Enter the type of vehicle to park?");
				String vehicleType = scan.nextLine();
				Vehicle UserVehicleType = null;

				switch (vehicleType) {
				case "bus":
					UserVehicleType = vehicleController.bus;
					break;
				case "van":
					UserVehicleType = vehicleController.van;
					break;
				case "bike":
					UserVehicleType = vehicleController.bike;
					break;
				case "car":
					UserVehicleType = vehicleController.car;
					break;
				}
				if ((vehicleController.getlistOfVehicle().contains(UserVehicleType))) {
					for (Level availableLevel : parkingSystem.getlistOfCopyLevel()) {
						if ((availableLevel.vehicleTypeAndCount.containsKey(UserVehicleType.VehicleName))
								&& (availableLevel.vehicleTypeAndCount.get(UserVehicleType.VehicleName) > 0)) {
							parkingIdAndVehicle.putAll(availableLevel.parkVehicle(UserVehicleType));
							availableLevel.vehicleTypeAndCount.put(UserVehicleType.VehicleName.toString(),
									availableLevel.vehicleTypeAndCount.get(UserVehicleType.VehicleName.toString()) - 1);
							break;
						}
					}
				} else {
					System.out.println("Sorry!This vehicle type is not allowed in this parking level");
				}
				//System.out.println("Sorry No more Space available");
			} else if (userAction.equals("unpark")) {
				System.out.println("Enter the Parking Id to unpark your Vehicle?");
				String userParkingId = scan.next();
				for (Level availableLevel : parkingSystem.getlistOfCopyLevel()) {
					if (availableLevel.parkingIdAndVehicle.containsKey(userParkingId)) {
						String userVehicleParked = availableLevel.unParkVehicle(userParkingId);
						if (userVehicleParked != null) {
							parkingIdAndVehicle.remove(userParkingId);
							System.out.println("Your Vehicle " + userVehicleParked + " is unparked now..");
							System.out.println(parkingIdAndVehicle);
							break;
						}
					}

				}
				//System.out.println("Given userId doesnot Exist..Enter a proper Id");
			}
		}
	}
}