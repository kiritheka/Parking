package try2;

import java.util.ArrayList;
import java.util.HashMap;

public class Level {

	
	int levelId;
	HashMap<String, Integer> vehicleTypeAndCount;

	public Level(int levelId, HashMap<String, Integer> vehicleTypeAndCount) {
		this.levelId = levelId;
		this.vehicleTypeAndCount = vehicleTypeAndCount;
	}
	
}
