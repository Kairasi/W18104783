package W18104783;

public abstract class Vehicle extends Object implements Comparable<Vehicle> {
	
	@Override
	public int compareTo(Vehicle o) {
		try {
		return this.entryTime.compareTo(o.entryTime);
		}
		catch(Exception e)
		{
			return -1;
		}
	}

	// Vehicle Properties
	private String idPlate;
	private String brand;
	private String model;
	private DateTime entryTime;
	private Integer priority;
	private Integer levelOneTwoPriority;
	private Integer levelThreeFourFiveSixPriority;
	private Integer levelSevenPriority;
	private int level;
	private int parkedSpaceId;
	private VehicleType vehicleType;
	private boolean isExit;

	// Constructor
	public Vehicle(String idPlate, String brand, String model, DateTime entryTime, VehicleType vehicleType,
			int priority, int levelOneTwoPriority, int levelThreeFourFiveSixPriority, int levelSevenPriority) {
		this.idPlate = idPlate;
		this.brand = brand;
		this.model = model;
		this.entryTime = entryTime;
		this.vehicleType = vehicleType;
		this.priority = priority;
		this.levelOneTwoPriority = levelOneTwoPriority;
		this.levelThreeFourFiveSixPriority = levelThreeFourFiveSixPriority;
		this.levelSevenPriority = levelSevenPriority;
	}

	public Vehicle(String idPlate, String brand, String model, DateTime entryTime, VehicleType vehicleType, int level,
			int priority, int levelOneTwoPriority, int levelThreeFourFiveSixPriority, int levelSevenPriority) {
		this.idPlate = idPlate;
		this.brand = brand;
		this.model = model;
		this.entryTime = entryTime;
		this.vehicleType = vehicleType;
		this.level = level;
		this.priority = priority;
		this.levelOneTwoPriority = levelOneTwoPriority;
		this.levelThreeFourFiveSixPriority = levelThreeFourFiveSixPriority;
		this.levelSevenPriority = levelSevenPriority;
	}

	
	public String getIdPlate() {
		return idPlate;
	}

	public void setIdPlate(String idPlate) {
		this.idPlate = idPlate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public DateTime getEntryDate() {
		return entryTime;
	}

	public void setEntryDate(DateTime entryTime) {
		this.entryTime = entryTime;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParkedSpaceId() {
		return parkedSpaceId;
	}

	public void setParkedSpaceId(int parkedSpaceId) {
		this.parkedSpaceId = parkedSpaceId;
	}
	
	public Integer getLevelOneTwoPriority() {
		return levelOneTwoPriority;
	}

	public void setLevelOneTwoPriority(Integer levelOneTwoPriority) {
		this.levelOneTwoPriority = levelOneTwoPriority;
	}

	public Integer getLevelThreeFourFiveSixPriority() {
		return levelThreeFourFiveSixPriority;
	}

	public void setLevelThreeFourFiveSixPriority(Integer levelThreeFourFiveSixPriority) {
		this.levelThreeFourFiveSixPriority = levelThreeFourFiveSixPriority;
	}

	public Integer getLevelSevenPriority() {
		return levelSevenPriority;
	}

	public void setLevelSevenPriority(Integer levelSevenPriority) {
		this.levelSevenPriority = levelSevenPriority;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public boolean isExit() {
		return isExit;
	}

	public void setExit(boolean isExit) {
		this.isExit = isExit;
	}


}
