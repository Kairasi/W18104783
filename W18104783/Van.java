package W18104783;

import W18104783.DateTime;
import W18104783.VehicleType;

public class Van extends Vehicle {

	// Properties
	private double cargoVolume;

	// Constructor
	public Van(String idPlate, String brand, String model, DateTime entryTime, double cargoVolume) {
		super(idPlate, brand, model, entryTime, VehicleType.Van, 5, 10, 5, 0);
		this.cargoVolume = cargoVolume;
	}

	public double getCargoVolume() {
		return cargoVolume;
	}

	public void setCargoVolume(double cargoVolume) {
		this.cargoVolume = cargoVolume;
	}

	
}
