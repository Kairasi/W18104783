package W18104783;

public class ParkingSpace {
	
	String parkingSpaceName;
	int parkingSpaceId;
	int level;
	boolean isOccupied;
	int bikeOccupancy;

	public ParkingSpace(String parkingSpaceName, int parkingSpaceId, int level) {
		this.parkingSpaceName = parkingSpaceName;
		this.parkingSpaceId = parkingSpaceId;
		this.isOccupied = false;
		this.level = level;
		this.bikeOccupancy = 0;
	}

	public String getParkingSpaceName() {
		return parkingSpaceName;
	}

	public void setParkingSpaceName(String parkingSpaceName) {
		this.parkingSpaceName = parkingSpaceName;
	}

	public int getParkingSpaceId() {
		return parkingSpaceId;
	}

	public void setParkingSpaceId(int parkingSpaceId) {
		this.parkingSpaceId = parkingSpaceId;
	}

	public boolean getIsOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getBikeOccupancy() {
		return bikeOccupancy;
	}

	public void setBikeOccupancy(int bikeOccupancy) {
		this.bikeOccupancy = bikeOccupancy;
	}

}
