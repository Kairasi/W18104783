package W18104783;

import java.math.BigDecimal;

import W18104783.DateTime;
import W18104783.Vehicle;

public interface CarParkManager {

	public static final int MAX_CAPACITY = 60;

	// console methods
	public void addVehicle(Vehicle vehicle);

	public Vehicle deleteVehicle(String IdPlate);

	public void printCurrentVehicles();

	public void printLongestPark();

	public void printLatestPark();

	public void printVehicleByDay(DateTime entryTime);

	public BigDecimal calculateChargers(String plateID, DateTime currentTime);

	public void printVehiclePercentage();

	// thread methods
	public void arrive(Vehicle vehicle, int level);

	public void depart(Vehicle vehicle, int level);
	
}
