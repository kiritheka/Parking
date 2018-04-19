package try4;

import java.util.ArrayList;

public class VehicleController {

	Vehicle car = new Vehicle("car");
	Vehicle bike = new Vehicle("bike");
	Vehicle van = new Vehicle("van");
	Vehicle bus = new Vehicle("bus");

	public ArrayList<Vehicle> getlistOfVehicle() {
		ArrayList<Vehicle> listOfVehicle = new ArrayList<Vehicle>();
		listOfVehicle.add(car);
		listOfVehicle.add(bike);
		listOfVehicle.add(van);
		listOfVehicle.add(bus);
		return listOfVehicle;
	}

	
	
}
