package W18104783;

public class MiniBus extends Vehicle {
	
	// Properties
	private int passengerCount;

	// Constructor
	public MiniBus(String idPlate, String brand, String model, DateTime entryTime, int passengerCount) {
		super(idPlate, brand, model, entryTime, VehicleType.MiniBus, 0, 10, 0, 0, 0);
		this.passengerCount = passengerCount;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

}
