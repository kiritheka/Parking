package try5;

public class Vehicle {
	
	enum VehicleTypeAllowed {
		BIKE,CAR, BUS, VAN
	}

	String uniqueId;
	String ownerName; 
	VehicleTypeAllowed vehicleType;
	
	Vehicle(VehicleTypeAllowed vehicleType,String uniqueId,String ownerName){
		this.vehicleType = vehicleType;
		this.uniqueId = uniqueId;
		this.ownerName = ownerName;
	}

}
