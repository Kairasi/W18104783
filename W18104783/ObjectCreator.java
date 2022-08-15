package W18104783;

import java.awt.Color;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import W18104783.Car;
import W18104783.DateTime;
import W18104783.MotorBike;
import W18104783.Van;
import W18104783.Vehicle;
import W18104783.VehicleType;
import W18104783.PettahMultiStoreyCarParkManager;
import W18104783.VehicleComparator;

public class ObjectCreator {

	public Vehicle createVehicle(VehicleType type) {

		Vehicle obj = null;
		Scanner sc = new Scanner(System.in); // Question
		System.out.println("Enter Plate ID :");
		String plateID = sc.next();
		System.out.println("Enter the Brand :");
		String brand = sc.next();
		System.out.println("Enter the model :");
		String model = sc.next();

		System.out.println("Enter the date and time (DD/MM/YYYY-HH:mm:ss)");
		String dateTime = sc.next();
		// adding the data in to a string array
		String[] arr = dateTime.split("-");
		String[] dateString = arr[0].split("/");
		String[] timeString = arr[1].split(":");

		DateTime entryTime = new DateTime(Integer.parseInt(dateString[0]), Integer.parseInt(dateString[1]),
				Integer.parseInt(dateString[2]), Integer.parseInt(timeString[0]), Integer.parseInt(timeString[1]),
				Integer.parseInt(timeString[2]));

		switch (type) {
		case Car:
			System.out.println("Enter number of Doors : ");
			int numDoors = sc.nextInt();

			obj = new Car(plateID, brand, model, entryTime, numDoors);
			break;

		case Van:
			System.out.println("Enter the Cargo Capacity : ");
			double cargoCapacity = sc.nextDouble();

			obj = new Van(plateID, brand, model, entryTime, cargoCapacity);
			break;

		case Motorbike:
			System.out.println("Enter the Engine Size : ");
			String engineSize = sc.next();

			obj = new MotorBike(plateID, brand, model, entryTime, engineSize);
			break;
			
		case MiniBus:
			System.out.println("Enter the Passenger Count : ");
			int passengerCount = sc.nextInt();

			obj = new MiniBus(plateID, brand, model, entryTime, passengerCount);
			break;
			
		case MiniLorry:
			System.out.println("Enter the number of Wheels : ");
			int wheelCount = sc.nextInt();

			obj = new MiniLorry(plateID, brand, model, entryTime, wheelCount);
			break;
			
		case Bus:
			System.out.println("Enter the Passenger Count : ");
			int passengerCount1 = sc.nextInt();

			obj = new Bus(plateID, brand, model, entryTime, passengerCount1);
			break;
			
		case Lorry:
			System.out.println("Enter the number of Wheels : ");
			int wheelCount1 = sc.nextInt();

			obj = new Lorry(plateID, brand, model, entryTime, wheelCount1);
			break;

		default:
			System.out.println("Invalid Choice");

		}
		return obj;
	}

	public void createDummyVehicleObjects(PettahMultiStoreyCarParkManager carParkManager) {

		// arrival
		for (int i = 0; i < 10; i++) {

			Vehicle van = new Van("456" + i, "Toyota", "HiAce", new DateTime(new Date()), 1000);
			carParkManager.addVehicle(van);

			Vehicle car = new Car("123" + i, "Hyundai", "EON", new DateTime(new Date()), 4);
			carParkManager.addVehicle(car);

			Vehicle bike = new MotorBike("789" + i, "Honda", "Benly", new DateTime(new Date()), "1000 CC");
			carParkManager.addVehicle(bike);
			
			Vehicle miniBus = new MiniBus("111" + i, "Toyota", "Hilux", new DateTime(new Date()), 12);
			carParkManager.addVehicle(miniBus);
			
			Vehicle miniLorry = new MiniLorry("222" + i, "Ford", "RAM", new DateTime(new Date()), 8);
			carParkManager.addVehicle(miniLorry);
			
			Vehicle bus = new Bus("333" + i, "Mercedes", "Donno", new DateTime(new Date()), 30);
			carParkManager.addVehicle(bus);
			
			Vehicle lorry = new Lorry("444" + i, "Honda", "Grace", new DateTime(new Date()), 16);
			carParkManager.addVehicle(lorry);

		}

		// departure
		for (int i = 0; i < 1; i++) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException t) {
			}

			// 10 slots
			carParkManager.deleteVehicle("123" + i);
			carParkManager.deleteVehicle("456" + i);
			carParkManager.deleteVehicle("789" + i);
			carParkManager.deleteVehicle("111" + i);
			carParkManager.deleteVehicle("222" + i);
			carParkManager.deleteVehicle("333" + i);
			carParkManager.deleteVehicle("444" + i);
			
		}

		//testPriorityQueues();

	}

	// a method to test comparator
	public void testPriorityQueues() {
		Queue<Vehicle> testList = new PriorityQueue<Vehicle>(5, new VehicleComparator());

		for (int i = 0; i < 5; i++) {

			Vehicle bike = new MotorBike("789" + i, "Honda", "Benly", new DateTime(new Date()), "1000 CC");
			bike.setLevel(2);
			testList.offer(bike);

			Vehicle van = new Van("456" + i, "Toyota", "HiAce", new DateTime(new Date()), 1000);
			van.setLevel(2);
			testList.offer(van);

			Vehicle car = new Car("123" + i, "Hyundai", "EON", new DateTime(new Date()), 4);
			car.setLevel(2);
			testList.offer(car);

			Vehicle miniBus = new MiniBus("111" + i, "Toyota", "Hilux", new DateTime(new Date()), 12);
			miniBus.setLevel(2);
			testList.offer(miniBus);
			
			Vehicle miniLorry = new MiniLorry("222" + i, "Ford", "RAM", new DateTime(new Date()), 8);
			miniLorry.setLevel(2);
			testList.offer(miniLorry);
			
			Vehicle bus = new Bus("333" + i, "Mercedes", "Donno", new DateTime(new Date()), 30);
			bus.setLevel(2);
			testList.offer(bus);
			
			Vehicle lorry = new Lorry("444" + i, "Honda", "Grace", new DateTime(new Date()), 16);
			lorry.setLevel(2);
			testList.offer(lorry);			
			
		}

		while (testList.size() != 0) {
			Vehicle s = testList.poll();
			System.out.println(s.getVehicleType() + "--" + s.getIdPlate() + "--" + s.getLevel());
		}

	}
	
}
