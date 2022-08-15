package W18104783;

public class MiniLorry extends Vehicle {
	
	// Properties
	private int wheelCount;

	// Constructor
	public MiniLorry(String idPlate, String brand, String model, DateTime entryTime, int wheelCount) {
		super(idPlate, brand, model, entryTime, VehicleType.MiniLorry, 0, 10, 0, 0, 0);
		this.wheelCount = wheelCount;
	}

	public int getWheelCount() {
		return wheelCount;
	}

	public void setWheelCount(int wheelCount) {
		this.wheelCount = wheelCount;
	}

}
