package park;

public class Vehicle {
	
	 public enum VehicleTypeAllowed {
		BIKE,CAR, BUS, VAN
	}

	String uniqueId;
	String ownerName; 
	VehicleTypeAllowed vehicleType;
	
	 public Vehicle(VehicleTypeAllowed vehicleType,String uniqueId,String ownerName){
		this.vehicleType = vehicleType;
		this.uniqueId = uniqueId;
		this.ownerName = ownerName;
	}

}
