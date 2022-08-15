package W18104783;

public class Bus extends Vehicle {
// KARADI
	// Properties
	private int passengerCount;

	// Constructor
	public Bus(String idPlate, String brand, String model, DateTime entryTime, int passengerCount) {
		super(idPlate, brand, model, entryTime, VehicleType.Bus, 0, 10, 0, 0, 0);
		this.passengerCount = passengerCount;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

}
