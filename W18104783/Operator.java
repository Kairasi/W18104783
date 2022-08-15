package W18104783;

import java.util.PriorityQueue;
import java.util.Queue;

import W18104783.VehicleComparator;
import W18104783.VehicleComparatorLift;

public class Operator {
	
	private Queue<Vehicle> entryVehicleList = new PriorityQueue<Vehicle>(100, new VehicleComparator());
	private Queue<Vehicle> exitVehicleList = new PriorityQueue<Vehicle>();

	private Queue<Vehicle> firstEntryVehicleList = new PriorityQueue<Vehicle>(100, new VehicleComparator());
	private Queue<Vehicle> exitFirstVehicleList = new PriorityQueue<Vehicle>();

	private Queue<Vehicle> secondEntryExitVehicleList = new PriorityQueue<Vehicle>(100, new VehicleComparatorLift());

	public Queue<Vehicle> getEntryVehicleList() {
		return entryVehicleList;
	}

	public void setEntryVehicleList(Queue<Vehicle> entryVehicleList) {
		this.entryVehicleList = entryVehicleList;
	}

	public Queue<Vehicle> getExitVehicleList() {
		return exitVehicleList;
	}

	public void setExitVehicleList(Queue<Vehicle> exitVehicleList) {
		this.exitVehicleList = exitVehicleList;
	}

	public Queue<Vehicle> getFirstEntryVehicleList() {
		return firstEntryVehicleList;
	}

	public void setFirstEntryVehicleList(Queue<Vehicle> firstEntryVehicleList) {
		this.firstEntryVehicleList = firstEntryVehicleList;
	}

	public Queue<Vehicle> getExitFirstVehicleList() {
		return exitFirstVehicleList;
	}

	public void setExitFirstVehicleList(Queue<Vehicle> exitFirstVehicleList) {
		this.exitFirstVehicleList = exitFirstVehicleList;
	}

	public Queue<Vehicle> getSecondEntryExitVehicleList() {
		return secondEntryExitVehicleList;
	}

	public void setSecondEntryExitVehicleList(Queue<Vehicle> secondEntryExitVehicleList) {
		this.secondEntryExitVehicleList = secondEntryExitVehicleList;
	}


}
