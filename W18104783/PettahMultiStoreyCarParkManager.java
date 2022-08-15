package W18104783;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import W18104783.DateTime;
import W18104783.ElevatorController;
import W18104783.Level;
import W18104783.Operator;
import W18104783.ParkingSpace;
import W18104783.Vehicle;
import W18104783.VehicleType;

public class PettahMultiStoreyCarParkManager implements CarParkManager {

	
	private static PettahMultiStoreyCarParkManager instance = null;

	public Queue<Vehicle> vehicleList = new LinkedList<Vehicle>();
	private ArrayList<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();
	private ArrayList<Vehicle> historyVehicleList = new ArrayList<Vehicle>();

	private int maxCount[] = new int[] { MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY };
	private int availableCount[] = new int[] { MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY, MAX_CAPACITY };

	// holds priority queues
	public Operator operator = new Operator();

	// charge related variables
	private double chargePerHour = 50;
	private double addCharge = 75;
	private double maxCharge = 1200;
	private int addFromthisHour = 3;

	PettahMultiStoreyCarParkManager() {

		// initialize parking spaces
		for (int j = 0; j < maxCount[0]; j++) {
			ParkingSpace parking = new ParkingSpace("Ground" + j, j, 0);
			parkingSpaces.add(parking);
		}

		for (int j = 0; j < maxCount[1]; j++) {
			ParkingSpace parking = new ParkingSpace("First" + j, j, 1);
			parkingSpaces.add(parking);
		}

		for (int j = 0; j < maxCount[2]; j++) {
			ParkingSpace parking = new ParkingSpace("Second" + j, j, 2);
			parkingSpaces.add(parking);
		}
		
		for (int j = 0; j < maxCount[3]; j++) {
			ParkingSpace parking = new ParkingSpace("Third" + j, j, 3);
			parkingSpaces.add(parking);
		}
		
		for (int j = 0; j < maxCount[4]; j++) {
			ParkingSpace parking = new ParkingSpace("Fourth" + j, j, 4);
			parkingSpaces.add(parking);
		}
		
		for (int j = 0; j < maxCount[5]; j++) {
			ParkingSpace parking = new ParkingSpace("Fifth" + j, j, 5);
			parkingSpaces.add(parking);
		}
		
		for (int j = 0; j < maxCount[6]; j++) {
			ParkingSpace parking = new ParkingSpace("Sixth" + j, j, 6);
			parkingSpaces.add(parking);
		}
		
		for (int j = 0; j < maxCount[7]; j++) {
			ParkingSpace parking = new ParkingSpace("Seventh" + j, j, 7);
			parkingSpaces.add(parking);
		}
		
		for (int j = 0; j < maxCount[8]; j++) {
			ParkingSpace parking = new ParkingSpace("Eighth" + j, j, 8);
			parkingSpaces.add(parking);
		}

	}

	// method which returns an object of same type
	public static PettahMultiStoreyCarParkManager getInstance() {
		if (instance == null) {
			synchronized (PettahMultiStoreyCarParkManager.class) {
				if (instance == null) {
					instance = new PettahMultiStoreyCarParkManager();
				}
			}
		}
		return instance;
	}

	// check slot availability
	public synchronized boolean checkSlotAvailability(Vehicle vehicle, int level) {
		

		if (vehicle.getVehicleType() == VehicleType.Car && availableCount[level] >= 1) // single slot
		{
			return true;
		} else if (vehicle.getVehicleType() == VehicleType.Van && availableCount[level] >= 2) // 2 continuous slot
		{
			for (int i = 0; i < parkingSpaces.size(); i++) {
				ParkingSpace parkingSpace = parkingSpaces.get(i);
				ParkingSpace nextSpace = null;
				try {
					nextSpace = parkingSpaces.get(i + 1);
				} catch (IndexOutOfBoundsException e) {
					return false;
				}

				if (parkingSpace.getLevel() == level && !parkingSpace.getIsOccupied() && nextSpace != null
						&& !nextSpace.getIsOccupied()) {
					return true;
				}
			}
			return false;
		} else if (level != 2 && vehicle.getVehicleType() == VehicleType.Motorbike) // 3 bikes per slot
		{

			if (availableCount[level] >= 1)
				return true;
			else {
				// no free slots but check availability in bike parked slots.
				for (int i = 0; i < parkingSpaces.size(); i++) {
					ParkingSpace parkingSpace = parkingSpaces.get(i);
					if (parkingSpace.getLevel() == level && parkingSpace.getIsOccupied()
							&& parkingSpace.getBikeOccupancy() > 0 && parkingSpace.getBikeOccupancy() < 3) {
						return true;
					}
				}
				return false;
			}
		} else if(level == 0 && (vehicle.getVehicleType() == VehicleType.MiniBus || vehicle.getVehicleType() == VehicleType.MiniLorry) 
				  && availableCount[0] >=3 )
		{
			for (int i = 0; i < parkingSpaces.size(); i++) {
				ParkingSpace parkingSpace = parkingSpaces.get(i);
				ParkingSpace secondSpace = null;
				ParkingSpace thirdSpace = null;
				try {
					secondSpace = parkingSpaces.get(i + 1);
					thirdSpace = parkingSpaces.get(i+2);
				} catch (IndexOutOfBoundsException e) {
					return false;
				} 

				if (parkingSpace.getLevel() == 0 && !parkingSpace.getIsOccupied() && secondSpace != null
						&& !secondSpace.getIsOccupied() && thirdSpace != null && !thirdSpace.getIsOccupied()) {
					return true;
				}
			}
			return false;
		} else if(level == 0 && (vehicle.getVehicleType() == VehicleType.Bus || vehicle.getVehicleType() == VehicleType.Lorry) 
				  && availableCount[0] >=5 )
		{
			for (int i = 0; i < parkingSpaces.size(); i++) {
				ParkingSpace parkingSpace = parkingSpaces.get(i);
				ParkingSpace secondSpace = null;
				ParkingSpace thirdSpace = null;
				ParkingSpace fourthSpace = null;
				ParkingSpace fifthSpace = null;
				try {
					secondSpace = parkingSpaces.get(i + 1);
					thirdSpace = parkingSpaces.get(i+2);
					fourthSpace = parkingSpaces.get(i+3);
					fifthSpace = parkingSpaces.get(i+4);
				} catch (IndexOutOfBoundsException e) {
					return false;
				} 

				if (parkingSpace.getLevel() == 0 && !parkingSpace.getIsOccupied() && secondSpace != null
						&& !secondSpace.getIsOccupied() && thirdSpace != null && !thirdSpace.getIsOccupied() 
						&& fourthSpace != null && !fourthSpace.getIsOccupied() 
						&& fifthSpace !=null && !fifthSpace.getIsOccupied()) {
					return true;
				}
			}
			return false;
		}

		return false;

	}

	// get level of the available slot
	public synchronized int getLevel(Vehicle vehicle) {

		int level = -1;
		if (checkSlotAvailability(vehicle, 0)) {
			level = 0;
		} else if (checkSlotAvailability(vehicle, 1)) {
			level = 1;
		} else if (checkSlotAvailability(vehicle, 2)) {
			level = 2;
		} else if (checkSlotAvailability(vehicle, 3)) {
			level = 3;
		} else if (checkSlotAvailability(vehicle, 4)) {
			level = 4;
		} else if (checkSlotAvailability(vehicle, 5)) {
			level = 5;
		} else if (checkSlotAvailability(vehicle, 6)) {
			level = 6;
		} else if (checkSlotAvailability(vehicle, 7)) {
			level = 7;
		} else if (checkSlotAvailability(vehicle, 8)) {
			level = 8;
		}
		return level;

	}

	// park vehicle and update parking slots with relevant information
	public synchronized void occupySlot(Vehicle vehicle, int level) {

		// check for a slot that has bikes already
		ParkingSpace parkingSpaceForBikes = null;
		int parkingPositionForBikes = 0;
		if (vehicle.getVehicleType() == VehicleType.Motorbike) {
			for (int i = 0; i < parkingSpaces.size(); i++) {
				ParkingSpace parkingSpace = parkingSpaces.get(i);
				if (parkingSpace.getLevel() == level && parkingSpace.getIsOccupied()
						&& parkingSpace.getBikeOccupancy() > 0 && parkingSpace.getBikeOccupancy() < 3) {
					parkingPositionForBikes = i;
					parkingSpaceForBikes = parkingSpace;
					break;
				}
			}

		}

		// find suitable parking slot
		for (int i = 0; i < parkingSpaces.size(); i++) {
			ParkingSpace parkingSpace = parkingSpaces.get(i);

			if (vehicle.getVehicleType() == VehicleType.Car) // single slot
			{

				if (!parkingSpace.getIsOccupied()) {
					availableCount[level] = availableCount[level] -= 1;
					parkingSpace.setIsOccupied(true);
					parkingSpaces.set(i, parkingSpace);
					vehicle.setParkedSpaceId(parkingSpace.getParkingSpaceId());
					break;
				}

			}

			else if (vehicle.getVehicleType() == VehicleType.Van) // two continuous slots
			{
				ParkingSpace nextSpace = parkingSpaces.get(i + 1);

				if (!parkingSpace.getIsOccupied() && !nextSpace.getIsOccupied()) {
					availableCount[level] = availableCount[level] -= 2;
					parkingSpace.setIsOccupied(true);
					nextSpace.setIsOccupied(true);
					parkingSpaces.set(i, parkingSpace);
					parkingSpaces.set(i + 1, nextSpace);
					vehicle.setParkedSpaceId(parkingSpace.getParkingSpaceId());
					break;
				}

			}
			
			else if (vehicle.getVehicleType() == VehicleType.MiniBus || vehicle.getVehicleType() == VehicleType.MiniLorry) // three continuous slots
			{
				ParkingSpace nextSpace = parkingSpaces.get(i + 1);
				ParkingSpace finalSpace = parkingSpaces.get(i + 2);

				if (!parkingSpace.getIsOccupied() && !nextSpace.getIsOccupied() && !finalSpace.getIsOccupied()) {
					availableCount[0] = availableCount[0] -= 3;
					parkingSpace.setIsOccupied(true);
					nextSpace.setIsOccupied(true);
					finalSpace.setIsOccupied(true);
					parkingSpaces.set(i, parkingSpace);
					parkingSpaces.set(i + 1, nextSpace);
					parkingSpaces.set(i + 2, finalSpace);
					vehicle.setParkedSpaceId(parkingSpace.getParkingSpaceId());
					break;
				}

			}
			
			else if (vehicle.getVehicleType() == VehicleType.Bus || vehicle.getVehicleType() == VehicleType.Lorry) // five continuous slots
			{
				ParkingSpace nextSpace = parkingSpaces.get(i + 1);
				ParkingSpace thirdSpace = parkingSpaces.get(i + 2);
				ParkingSpace fourthSpace = parkingSpaces.get(i + 3);
				ParkingSpace fifthSpace = parkingSpaces.get(i + 4);

				if (!parkingSpace.getIsOccupied() && !nextSpace.getIsOccupied() && !thirdSpace.getIsOccupied()
					&& !fourthSpace.getIsOccupied() && !fifthSpace.getIsOccupied()) {
					availableCount[0] = availableCount[0] -= 5;
					parkingSpace.setIsOccupied(true);
					nextSpace.setIsOccupied(true);
					thirdSpace.setIsOccupied(true);
					fourthSpace.setIsOccupied(true);
					fifthSpace.setIsOccupied(true);
					parkingSpaces.set(i, parkingSpace);
					parkingSpaces.set(i + 1, nextSpace);
					parkingSpaces.set(i + 2, thirdSpace);
					parkingSpaces.set(i + 3, fourthSpace);
					parkingSpaces.set(i + 4, fifthSpace);
					vehicle.setParkedSpaceId(parkingSpace.getParkingSpaceId());
					break;
				}

			}

			if (vehicle.getVehicleType() == VehicleType.Motorbike) // 3 bikes per slot
			{
			
				if(parkingSpaceForBikes != null)
				{
					int currentOccupancy = parkingSpaceForBikes.getBikeOccupancy();
					parkingSpaceForBikes.setBikeOccupancy(++currentOccupancy);
					parkingSpaces.set(parkingPositionForBikes, parkingSpaceForBikes);
					vehicle.setParkedSpaceId(parkingSpaceForBikes.getParkingSpaceId());
					Level.decrementSlots(level);
					break;
				}
				else if(!parkingSpace.getIsOccupied())
				{
					
						int currentOccupancy = parkingSpace.getBikeOccupancy();

						availableCount[level] = availableCount[level] -= 1;
						parkingSpace.setIsOccupied(true);
						parkingSpace.setBikeOccupancy(++currentOccupancy);
						parkingSpaces.set(i, parkingSpace);
						vehicle.setParkedSpaceId(parkingSpace.getParkingSpaceId());
						Level.decrementSlots(level);
						break;
					
				}
			}
		}

	}
	
	
	@Override
	public synchronized void arrive(Vehicle vehicle, int level) {

		while (availableCount[0] == 0 && availableCount[1] == 0 && availableCount[2] == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

//		if (checkSlotAvailability(vehicle, level)) {
//			vehicle.setLevel(level);
//			occupySlot(vehicle, level);
//			vehicleList.offer(vehicle);
			
		if (checkSlotAvailability(vehicle, level)) {
			if(vehicle.getVehicleType() == VehicleType.MiniBus || vehicle.getVehicleType() == VehicleType.MiniLorry || vehicle.getVehicleType() == VehicleType.Bus || vehicle.getVehicleType() == VehicleType.Lorry) {
				vehicle.setLevel(0);
				occupySlot(vehicle, 0);
			}
			else {
				vehicle.setLevel(level);
				occupySlot(vehicle, level);
			}
			vehicleList.offer(vehicle);
			
			

			// an array to hold history records
			historyVehicleList.add(vehicle);

			System.out.println(Thread.currentThread().getName() + " arrived: " + vehicle.getVehicleType() + " "
					+ vehicle.getIdPlate());
			System.out.println("Free slots in level " + level + " - " + availableCount[level] + "/" + maxCount[level]);
			controlLifts();
			System.out.println("---------------------------------");

		} else {
			if (checkSlotAvailability(vehicle, 1)) {
				operator.getFirstEntryVehicleList().offer(vehicle);
			} else if (checkSlotAvailability(vehicle, 2)) {
				operator.getSecondEntryExitVehicleList().offer(vehicle);
			} else if (checkSlotAvailability(vehicle, 0)) {
				operator.getEntryVehicleList().offer(vehicle);
			} else {
				operator.getEntryVehicleList().offer(vehicle);
			}

		}

		notifyAll();

	}

	@Override
	public synchronized void depart(Vehicle vehicle, int level) {
		
		while (availableCount[0] == maxCount[0] && availableCount[1] == maxCount[1]
				&& availableCount[2] == maxCount[2]) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// re update parking slots with relevant information
		ParkingSpace parkingSpace = null;
		for (int i = 0; i < parkingSpaces.size(); i++) {
			parkingSpace = parkingSpaces.get(i);

			if (parkingSpace.getParkingSpaceId() == vehicle.getParkedSpaceId()) {

				if (vehicle.getVehicleType() == VehicleType.Car) // single slot
				{
					availableCount[level] += 1;
					parkingSpace.setIsOccupied(false);
					parkingSpaces.set(i, parkingSpace);
				} else if (vehicle.getVehicleType() == VehicleType.Van) // two continuous slots
				{
					availableCount[level] += 2;
					ParkingSpace nextSpace = parkingSpaces.get(i + 1);
					parkingSpace.setIsOccupied(false);
					nextSpace.setIsOccupied(false);
					parkingSpaces.set(i, parkingSpace);
					parkingSpaces.set(i + 1, parkingSpace);
				} else if (vehicle.getVehicleType() == VehicleType.Motorbike) // 3 per slot
				{
					int occupancy = parkingSpace.getBikeOccupancy();
					if (occupancy == 1) {
						availableCount[level] += 1;
						parkingSpace.setIsOccupied(false);
					}
					parkingSpace.setBikeOccupancy(--occupancy);
					parkingSpaces.set(i, parkingSpace);
					Level.incrementSlots(level);
				} else if (vehicle.getVehicleType() == VehicleType.MiniBus || vehicle.getVehicleType() == VehicleType.MiniLorry)
				{
					availableCount[0] += 3;
					ParkingSpace nextSpace = parkingSpaces.get(i+1);
					ParkingSpace thirdSpace = parkingSpaces.get(i+2);
					parkingSpace.setIsOccupied(false);
					nextSpace.setIsOccupied(false);
					thirdSpace.setIsOccupied(false);
					parkingSpaces.set(i,  parkingSpace);
					parkingSpaces.set(i+1,  parkingSpace);
					parkingSpaces.set(i+2, parkingSpace);
				}else if (vehicle.getVehicleType() == VehicleType.Bus || vehicle.getVehicleType() == VehicleType.Lorry)
				{
					availableCount[0] += 5;
					ParkingSpace nextSpace = parkingSpaces.get(i+1);
					ParkingSpace thirdSpace = parkingSpaces.get(i+2);
					ParkingSpace fourthSpace = parkingSpaces.get(i+3);
					ParkingSpace fifthSpace = parkingSpaces.get(i+4);
					parkingSpace.setIsOccupied(false);
					nextSpace.setIsOccupied(false);
					thirdSpace.setIsOccupied(false);
					fourthSpace.setIsOccupied(false);
					fifthSpace.setIsOccupied(false);
					parkingSpaces.set(i,  parkingSpace);
					parkingSpaces.set(i+1,  parkingSpace);
					parkingSpaces.set(i+2, parkingSpace);
					parkingSpaces.set(i+3, parkingSpace);
					parkingSpaces.set(i+4,  parkingSpace);
				}
				
					break;
			}
		}

		System.out.println(Thread.currentThread().getName() + " departed: " + vehicle.getVehicleType() + " "
				+ vehicle.getIdPlate());
		System.out.println("Free slots in level " + level + " - " + availableCount[level] + "/" + maxCount[level]);
		controlLifts();
		System.out.println("---------------------------------");

		notifyAll();

	}
	
	private synchronized void controlLifts() {
		ElevatorController.UP_FIRST_FLOOR_ALLOWED = availableCount[0] == 0 && availableCount[1] > 0;
		ElevatorController.UP_SECOND_FLOOR_ALLOWED = availableCount[0] == 0 && availableCount[1] == 0
				&& availableCount[2] > 0;

		//System.out.println("Lift controller status first floor:" + ElevatorController.UP_FIRST_FLOOR_ALLOWED + " & second floor:" + ElevatorController.UP_SECOND_FLOOR_ALLOWED);
	}
	
	
	@Override
	public synchronized void addVehicle(Vehicle newVehicle) {
		// check whether the vehicle is already parked or not
		Iterator<Vehicle> iterator = vehicleList.iterator();
		while (iterator.hasNext()) {
			Vehicle vehicle = iterator.next();
			if (vehicle.getIdPlate().equals(newVehicle.getIdPlate())) {
				System.out.println("This vehicle is already parked.");
				return;
			}
		}

		operator.getEntryVehicleList().offer(newVehicle);

		if (getLevel(newVehicle) == -1) {
			System.out.println(
					"No parking space available for " + newVehicle.getVehicleType() + " " + newVehicle.getIdPlate());
		}

	}

	@Override
	public synchronized Vehicle deleteVehicle(String IdPlate) {

		Iterator<Vehicle> iterator = vehicleList.iterator();
		boolean found = false;
		Vehicle vehicle = null;

		while (iterator.hasNext()) {
			vehicle = iterator.next();
			if (vehicle.getIdPlate().equals(IdPlate)) {
				found = true;
				iterator.remove();
				break;
			}
		}

		if (found) {
			if (vehicle.getLevel() == 0) {
				operator.getExitVehicleList().offer(vehicle);
			} else if (vehicle.getLevel() == 1) {
				operator.getExitFirstVehicleList().offer(vehicle);
			} else {
				vehicle.setExit(true);
				operator.getSecondEntryExitVehicleList().offer(vehicle);
			}
		} else {
			System.out.println("Vehicle " + IdPlate + " not found.");
		}

		return vehicle;
		
	}

	@Override
	public void printCurrentVehicles() {

		List<Vehicle> reversedList = vehicleList.stream().collect(Collectors.toList());
		Collections.reverse(reversedList);

		for (Vehicle vehicle : reversedList) {
			printData(vehicle);
		}
		
	}
	
	private void printData(Vehicle vehicle) {
		
		System.out.println("******************");
		System.out.println("Vehicle Type is a " + vehicle.getVehicleType());
		System.out.println("ID Plate : " + vehicle.getIdPlate());
		System.out
				.println("Entry Time : " + vehicle.getEntryDate().getHours() + ":" + vehicle.getEntryDate().getMinutes()
						+ ":" + vehicle.getEntryDate().getSeconds() + "-" + vehicle.getEntryDate().getDate() + "/"
						+ vehicle.getEntryDate().getMonth() + "/" + vehicle.getEntryDate().getYear());
		System.out.println("\n");
	}

	@Override
	public void printLongestPark() {
		
		Iterator<Vehicle> iterator = vehicleList.iterator();
		Vehicle vehicle = null;

		while (iterator.hasNext()) {
			vehicle = iterator.next();
			break;
		}
		if (vehicle != null) {
			System.out.println("Longest parked vehicle details:");
			printData(vehicle);
		} else {
			System.out.println("Cannot find the longest parked vehicle.");
		}

	}

	@Override
	public void printLatestPark() {

		List<Vehicle> reversedList = vehicleList.stream().collect(Collectors.toList());
		Collections.reverse(reversedList);

		if (reversedList.size() > 0) {
			System.out.println("Last parked vehicle details:");
			printData(reversedList.get(0));
		} else {
			System.out.println("Cannot find the last parked vehicle.");
		}
		
	}

	@Override
	public void printVehicleByDay(DateTime givenDate) {

		boolean found = false;
		for (Vehicle vehicle : historyVehicleList) {
			if (givenDate.getYear() == vehicle.getEntryDate().getYear()
					&& givenDate.getMonth() == vehicle.getEntryDate().getMonth()
					&& givenDate.getDate() == vehicle.getEntryDate().getDate()) {

				found = true;
				printData(vehicle);
			}
		}

		if (!found) {
			System.out.println("Cannot find any vehicles parked on this date.");
		}
	}

	@Override
	public BigDecimal calculateChargers(String plateID, DateTime currentTime) {

		BigDecimal charges = null;

		Iterator<Vehicle> iterator = vehicleList.iterator();
		boolean found = false;
		Vehicle vehicle = null;

		while (iterator.hasNext()) {
			vehicle = iterator.next();
			if (vehicle.getIdPlate().equals(plateID)) {
				found = true;
				break;
			}
		}

		if (found) {

			// vehicle parked time
			System.out.println(
					"Entry Time : " + vehicle.getEntryDate().getDate() + "/" + vehicle.getEntryDate().getMonth() + "/"
							+ vehicle.getEntryDate().getYear() + "-" + vehicle.getEntryDate().getHours() + ":"
							+ vehicle.getEntryDate().getMinutes() + ":" + vehicle.getEntryDate().getSeconds());
			
			// making the charges
			DateTime entryDateTime = vehicle.getEntryDate();
			int differenceInSeconds = currentTime.compareTo(entryDateTime);
			double differenceInHours = differenceInSeconds / (60.0 * 60.0 * 365);
			//System.out.println(differenceInHours);

			double dayCharge = 0;
			double hourCharge = 0;
			double totalCost = 0;
			double days = differenceInHours / 24;

			if (days > 1) {
				dayCharge = maxCharge * (int) days;
			}
			else if (differenceInHours >= 3 && differenceInHours <24) {
				double additional = (differenceInHours - addFromthisHour);
				hourCharge = (additional * addCharge) + (addFromthisHour * chargePerHour);
				//System.out.printf("Hour Charge : %.2f", hourCharge);
				//System.out.print("\n");
			} else if (differenceInHours < 1) {
				hourCharge = chargePerHour;
			} else {
				hourCharge = (differenceInHours * chargePerHour);
			}

			totalCost = dayCharge + hourCharge;
			charges = new BigDecimal(totalCost);
			System.out.printf("Total charge for the vehicle " + plateID + " is LKR %.2f", charges);
			System.out.println("\n");
		} else {
			System.out.println("Vehicle not found.");
		}

		return charges;
	}

	@Override
	public void printVehiclePercentage() {
		
		double numCars = 0;
		double numBikes = 0;
		double numVans = 0;

		Iterator<Vehicle> iterator = vehicleList.iterator();
		Vehicle vehicle = null;

		while (iterator.hasNext()) {
			vehicle = iterator.next();
			if (vehicle.getVehicleType() == VehicleType.Car) {
				numCars++;
			} else if (vehicle.getVehicleType() == VehicleType.Motorbike) {
				numBikes++;
			} else {
				numVans++;
			}
		}

		if (vehicle == null) {
			System.out.println("No vehicles are parked.");
		} else {

			double carPercentage = (numCars / vehicleList.size()) * 100;
			double bikePercentage = (numBikes / vehicleList.size()) * 100;
			double vanPercentage = (numVans / vehicleList.size()) * 100;

			System.out.printf("Car Percentage is : %.02f ", carPercentage);
			System.out.printf("\nBike Percentage is : %.02f ", bikePercentage);
			System.out.printf("\nVan Percentage is : %.02f ", vanPercentage);
			System.out.println("\n");
		}

	}


}
