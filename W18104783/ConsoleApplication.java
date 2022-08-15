package W18104783;

import java.awt.Color;
import java.util.Date;
import java.util.Scanner;

import W18104783.Car;
import W18104783.DateTime;
import W18104783.Vehicle;
import W18104783.VehicleType;
import W18104783.PettahMultiStoreyCarParkManager;
import W18104783.Elevator;
import W18104783.EntryGate;
import W18104783.ExitGate;
import W18104783.ObjectCreator;

public class ConsoleApplication {

	private static PettahMultiStoreyCarParkManager pettahMultiStoreyCarParkManager = PettahMultiStoreyCarParkManager.getInstance();

	public static void main(String[] args) {

		Runnable groundEntry = new EntryGate(pettahMultiStoreyCarParkManager, 0);
		Runnable groundExit = new ExitGate(pettahMultiStoreyCarParkManager, 0);

		Runnable firstEntry = new EntryGate(pettahMultiStoreyCarParkManager, 1);
		Runnable firstExit = new ExitGate(pettahMultiStoreyCarParkManager, 1);

		Runnable secondEntry = new EntryGate(pettahMultiStoreyCarParkManager, 2);
		Runnable secondExit = new ExitGate(pettahMultiStoreyCarParkManager, 2);

		Runnable thirdEntry = new EntryGate(pettahMultiStoreyCarParkManager, 3);
		Runnable thirdExit = new ExitGate(pettahMultiStoreyCarParkManager, 3);

		Runnable fourthEntry = new EntryGate(pettahMultiStoreyCarParkManager, 4);
		Runnable fourthExit = new ExitGate(pettahMultiStoreyCarParkManager, 4);

		Runnable fifthEntry = new EntryGate(pettahMultiStoreyCarParkManager, 5);
		Runnable fifthExit = new ExitGate(pettahMultiStoreyCarParkManager, 5);
		
		Runnable sixthEntry = new EntryGate(pettahMultiStoreyCarParkManager, 6);
		Runnable sixthExit = new ExitGate(pettahMultiStoreyCarParkManager, 6);

		Runnable elevator = new Elevator(pettahMultiStoreyCarParkManager);

		Thread groundEntryN1 = new Thread(groundEntry, "Ground Entry N1");
		Thread groundEntryN2 = new Thread(groundEntry, "Ground Entry N2");
		Thread groundExitS1 = new Thread(groundExit, "Ground Exit S1");
		Thread groundExitS2 = new Thread(groundExit, "Ground Exit S2");

		Thread firstEntryW1 = new Thread(firstEntry, "First Entry W1");
		Thread firstEntryW2 = new Thread(firstEntry, "First Entry W2");
		Thread firstExitE1 = new Thread(firstExit, "First Exit E1");
		Thread firstExitE2 = new Thread(firstExit, "First Exit E2");

		Thread secondEntryW1 = new Thread(secondEntry, "Second Entry W1");
		Thread secondEntryW2 = new Thread(secondEntry, "Second Entry W2");
		Thread secondExitE1 = new Thread(secondExit, "Second Exit E1");
		Thread secondExitE2 = new Thread(secondExit, "Second Exit E2");

		Thread thirdEntryW1 = new Thread(thirdEntry, "Third Entry W1");
		Thread thirdExitE1 = new Thread(thirdExit, "Third Exit E1");
		
		Thread fourthEntryW1 = new Thread(fourthEntry, "Fourth Entry W1");
		Thread fourthExitE1 = new Thread(fourthExit, "Fourth Exit E1");
		
		Thread fifthEntryW1 = new Thread(fifthEntry, "Fifth Entry W1");
		Thread fifthExitE1 = new Thread(fifthExit, "Fifth Exit E1");
		
		Thread sixthEntryW1 = new Thread(sixthEntry, "Sixth Entry W1");
		Thread sixthExitE1 = new Thread(sixthExit, "Sixth Exit E1");
		
		ThreadGroup liftGroup = new ThreadGroup("Lifts");
		
		Thread liftW1 = new Thread(liftGroup, elevator, "Lift W1");
		Thread liftW2 = new Thread(liftGroup, elevator, "Lift W2");
		Thread liftE1 = new Thread(liftGroup, elevator, "Lift E1");
		Thread liftE2 = new Thread(liftGroup, elevator, "Lift E2");
		
		liftW1.start();
		liftW2.start();
		liftE1.start();
		liftE2.start();

		groundEntryN1.setPriority(Thread.MAX_PRIORITY);
		groundEntryN2.setPriority(Thread.MAX_PRIORITY);

		groundEntryN1.start();
		groundEntryN2.start();
		groundExitS1.start();
		groundExitS2.start();

		firstEntryW1.start();
		firstEntryW2.start();
		firstExitE1.start();
		firstExitE2.start();
		
		secondEntryW1.start();
		secondEntryW2.start();
		secondExitE1.start();
		secondExitE2.start();

		thirdEntryW1.start();
		thirdExitE1.start();
		
		fourthEntryW1.start();
		fourthExitE1.start();
		
		fifthEntryW1.start();
		fifthExitE1.start();
		
		sixthEntryW1.start();
		sixthExitE1.start();

//		Vehicle car = new Car("123", "Hyundai", "EON", new DateTime(new Date()), 4);
//		pettahMultiStoreyCarParkManager.addVehicle(car);
//		
//		Vehicle car1 = new Car("1234", "Hyundai", "EON", new DateTime(new Date()), 4);
//		pettahMultiStoreyCarParkManager.addVehicle(car1);
	
		// Getting the choice from the input
		while (true) {
			System.out.println("Select your Choice : ");
			System.out.println("1. Add Vehicle");
			System.out.println("2. Delete Vehicle");
			System.out.println("3. Print the current available vehicle");
			System.out.println("4. Print statistics");
			System.out.println("5. Vehicles parked in a day.");
			System.out.println("6. Charge for the parking");
			System.out.println("7. Percentage of vehicles");
			System.out.println("8. Exit car park");
			System.out.println(">>>>");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addVehicle();
				break;
			case 2:
				deleteVehicle();
				break;
			case 3:
				printVehicle();
				break;
			case 4:
				printStatistics();
				break;
			case 5:
				parkedByDay();
				break;
			case 6:
				calCharge();
				break;
			case 7:
				vehiclePercentage();
				break;
			case 8:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please enter a valid choice");
			}
		}
	}

	private static void addVehicle() {
		// getting choice from the user
		System.out.println("Select your choice : ");
		System.out.println("******************");
		System.out.println("1. To add a Car.");
		System.out.println("2. To add a Motor Bike.");
		System.out.println("3. To add a Van.");
		System.out.println("4. To add a Mini Bus.");
		System.out.println("5. To add a Mini Lorry.");
		System.out.println("6. To add a Bus.");
		System.out.println("7. To add a Lorry.");
		System.out.println(">>>>");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		VehicleType type = (choice == 1) ? VehicleType.Car
				: (choice == 2) ? VehicleType.Motorbike : (choice == 3) ? VehicleType.Van 
				: (choice == 4) ? VehicleType.MiniBus : (choice == 5) ? VehicleType.MiniLorry
				: (choice == 6) ? VehicleType.Bus : (choice == 7) ? VehicleType.Lorry : null;
		ObjectCreator creater = new ObjectCreator();
		Vehicle vehicle = creater.createVehicle(type);
		//System.out.println(vehicle.getIdPlate());
		pettahMultiStoreyCarParkManager.addVehicle(vehicle);
	}

	private static void deleteVehicle() {
		// getting plate ID from the user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Plate ID :");
		String plateID = input.next();
		pettahMultiStoreyCarParkManager.deleteVehicle(plateID);
	}

	private static void printVehicle() {
		pettahMultiStoreyCarParkManager.printCurrentVehicles();
	}

	private static void printStatistics() {
		pettahMultiStoreyCarParkManager.printLongestPark();
		pettahMultiStoreyCarParkManager.printLatestPark();
	}

	private static void parkedByDay() {
		// getting Date from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Date to Find (DD/MM/YYYY-HH:mm:ss) : ");
		String checkThisTime = sc.next();
		String[] date = checkThisTime.split("-");
		String[] dateString = date[0].split("/");
		String[] timeString = date[1].split(":");
		DateTime givenDate = new DateTime(Integer.parseInt(dateString[0]), Integer.parseInt(dateString[1]),
				Integer.parseInt(dateString[2]), Integer.parseInt(timeString[0]), Integer.parseInt(timeString[1]),
				Integer.parseInt(timeString[2]));
		pettahMultiStoreyCarParkManager.printVehicleByDay(givenDate);
	}

	private static void calCharge() {
		// getting plate ID from the user
		System.out.println("Enter the Plate ID : ");
		Scanner sc = new Scanner(System.in);
		String plateID = sc.next();
		// getting Date from the user
		System.out.println("Enter the leaving time : (DD/MM/YYYY - HH:mm:ss)");
		String leavingTime = sc.next();
		String[] arr1 = leavingTime.split("-");
		String[] dateString = arr1[0].split("/");
		String[] timeString = arr1[1].split(":");

		DateTime currentTime = new DateTime(Integer.parseInt(dateString[0]), Integer.parseInt(dateString[1]),
				Integer.parseInt(dateString[2]), Integer.parseInt(timeString[0]), Integer.parseInt(timeString[1]),
				Integer.parseInt(timeString[2]));
		pettahMultiStoreyCarParkManager.calculateChargers(plateID, currentTime);
	}

	private static void vehiclePercentage() {
		pettahMultiStoreyCarParkManager.printVehiclePercentage();
	}

}
