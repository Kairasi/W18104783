package W18104783;

import W18104783.DateTime;
import W18104783.VehicleType;

public class MotorBike extends Vehicle {
	
	private String engineSize;
	private int totalLevelOccupancy;

	public MotorBike(String idPlate, String brand, String model, DateTime entryTime, String engineSize) {
		super(idPlate, brand, model, entryTime, VehicleType.Motorbike, 5, 5, 5, 0);
		this.engineSize = engineSize;
	}

	public String getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	public int getTotalLevelOccupancy() {
		return totalLevelOccupancy;
	}

	public void setTotalLevelOccupancy(int totalLevelOccupancy) {
		this.totalLevelOccupancy = totalLevelOccupancy;
	}

}
