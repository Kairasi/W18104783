package W18104783;

public class Level {

	static int LEVEL_0_BIKE_OCCUPANCY = 0;
	static int LEVEL_1_BIKE_OCCUPANCY = 0;

	public static int getLevel(int level) {
		if (level == 0)
			return LEVEL_0_BIKE_OCCUPANCY;
		else if (level == 1)
			return LEVEL_1_BIKE_OCCUPANCY;
		else
			return 0;

	}

	public static void incrementSlots(int level) {
		if (level == 0)
			LEVEL_0_BIKE_OCCUPANCY++;
		else if (level == 1)
			LEVEL_1_BIKE_OCCUPANCY++;
	}

	public static void decrementSlots(int level) {
		if (level == 0)
			LEVEL_0_BIKE_OCCUPANCY--;
		else if (level == 1)
			LEVEL_1_BIKE_OCCUPANCY--;
	}
	
}
