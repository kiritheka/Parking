package try2;

import java.util.ArrayList;
import java.util.HashMap;

public class LevelDetails {
	
	
	HashMap<String, Integer> vehicleTypeAndCount1 = new HashMap<String, Integer>(){{
		put("bike", 20);
		put("car", 10);
	}};
	Level level1 = new Level(1, vehicleTypeAndCount1);

	HashMap<String, Integer> vehicleTypeAndCount2 = new HashMap<String, Integer>(){{
		put("bike", 20);
		put("car", 10);
		put("van",5);
	}};
	Level level2 = new Level(2, vehicleTypeAndCount2);
	
	HashMap<String, Integer> vehicleTypeAndCount3 = new HashMap<String, Integer>(){{
		put("car", 10);
		put("van",5);
		put("bus",7);

	}};
	Level level3 =  new Level(3, vehicleTypeAndCount3);
	
	public ArrayList<Level> getlistOfLevel() {
		ArrayList<Level> listOfLevel = new ArrayList<Level>();
		listOfLevel.add(level1);
		listOfLevel.add(level2);
		listOfLevel.add(level3);

		return listOfLevel;

	}
	
	
public void addVehicle(String vehicleName) {
		  
		LevelDetails levelDetails = new LevelDetails();
		ArrayList<Level> listOfLevel = levelDetails.getlistOfLevel();
      
		int noOfLevel = listOfLevel.size() - 1;
		if (listOfLevel.get(noOfLevel-2).vehicleTypeAndCount.containsKey(vehicleName)) {
			listOfLevel.get(noOfLevel).vehicleTypeAndCount.put(vehicleName, listOfLevel.get(noOfLevel-2).vehicleTypeAndCount.get(vehicleName) - 1);
		} else if (listOfLevel.get(noOfLevel - 1).vehicleTypeAndCount.containsKey(vehicleName)) {
			listOfLevel.get(noOfLevel).vehicleTypeAndCount.put(vehicleName, listOfLevel.get(noOfLevel - 1).vehicleTypeAndCount.get(vehicleName) - 1);
		} else if (listOfLevel.get(noOfLevel).vehicleTypeAndCount.containsKey(vehicleName)) {
			listOfLevel.get(noOfLevel).vehicleTypeAndCount.put(vehicleName, listOfLevel.get(noOfLevel).vehicleTypeAndCount.get(vehicleName) - 1);
		}
		System.out.println(listOfLevel.get(noOfLevel).vehicleTypeAndCount);

		//return level.vehicleTypeAndCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*HashMap<String, Integer> vehicleTypeAndCount = new HashMap<String, Integer>() ;
	Level level1 = new Level(1, vehicleTypeAndCount);
	Level level2 = new Level(2, vehicleTypeAndCount);;
	Level level3 =  new Level(3, vehicleTypeAndCount);;

	public  HashMap<String, Integer> getLevelRestrictions() {
		HashMap<String, Integer> vehicleTypeAndCount = new HashMap<String, Integer>() {
			{
				put("car", 20);
				put("van", 10);
			}
		};
		level1 = new Level(1, vehicleTypeAndCount);
		vehicleTypeAndCount.put("bike", 30);
		level2 = new Level(2, vehicleTypeAndCount);
		vehicleTypeAndCount.put("bus", 5);
		level3 = new Level(3, vehicleTypeAndCount);
		return vehicleTypeAndCount;
	}

	public ArrayList<Level> getlistOfLevel() {
		ArrayList<Level> listOfLevel = new ArrayList<Level>();
		LevelDetails levelDetails = new LevelDetails();
		levelDetails.getLevelRestrictions();

		listOfLevel.add(level1);
		listOfLevel.add(level2);
		listOfLevel.add(level3);

		return listOfLevel;

	}

	public HashMap<String, Integer> addVehicle(String vehicleName,HashMap<String, Integer> vehicleTypeAndCount) {
		
		LevelDetails levelDetails = new LevelDetails();
		System.out.println(vehicleTypeAndCount+"bfrelevel");
		ArrayList<Level> listOfLevel = levelDetails.getlistOfLevel();
		System.out.println(listOfLevel.get(0).levelId);
		int level = listOfLevel.size() - 1;
        System.out.println(listOfLevel.get(2));
        
		if (listOfLevel.get(level).vehicleTypeAndCount.containsKey(vehicleName)) {
			vehicleTypeAndCount.put(vehicleName, listOfLevel.get(level).vehicleTypeAndCount.get(vehicleName) - 1);
		} else if (listOfLevel.get(level - 1).vehicleTypeAndCount.containsKey(vehicleName)) {
			vehicleTypeAndCount.put(vehicleName, listOfLevel.get(level - 1).vehicleTypeAndCount.get(vehicleName) - 1);
		} else if (listOfLevel.get(level - 2).vehicleTypeAndCount.containsKey(vehicleName)) {
			vehicleTypeAndCount.put(vehicleName, listOfLevel.get(level - 2).vehicleTypeAndCount.get(vehicleName) - 1);

		}
		System.out.println(vehicleTypeAndCount+"afterlevel");
		return vehicleTypeAndCount;
	}
*/
}
