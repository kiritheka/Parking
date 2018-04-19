package try4;

import java.util.ArrayList;
import java.util.HashMap;

import try4.Level;

public class LevelController {
	ParkingSystem parkingSystem = new ParkingSystem();

	HashMap<String, Integer> vehicleTypeAndCount1 = new HashMap<String, Integer>() {{
			put("bike", 2);
			put("car", 1);
		}};
	Level level1 = new Level("A", vehicleTypeAndCount1);

	HashMap<String, Integer> vehicleTypeAndCount2 = new HashMap<String, Integer>() {{
			put("bike", 2);
			put("car", 1);
			put("van", 2);
		}};
	Level level2 = new Level("B", vehicleTypeAndCount2);

	HashMap<String, Integer> vehicleTypeAndCount3 = new HashMap<String, Integer>() {{
			put("car", 1);
			put("van", 2);
			put("bus", 3);
		}};
	Level level3 = new Level("C", vehicleTypeAndCount3);
	
	
	public ArrayList<Level> getlistOfLevel() {
		ArrayList<Level> listOfLevel = new ArrayList<Level>();
		listOfLevel.add(level1);
		listOfLevel.add(level2);
		listOfLevel.add(level3);

		return listOfLevel;
	}

		
	}

	

