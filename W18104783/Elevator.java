package W18104783;

import java.util.Queue;

import W18104783.Vehicle;
import W18104783.PettahMultiStoreyCarParkManager;

public class Elevator implements Runnable {
	
	private PettahMultiStoreyCarParkManager carParkMangerSlot;
	private Queue<Vehicle> liftVehicleList;

	public Elevator(PettahMultiStoreyCarParkManager carParkMangerSlot) {
		super();
		this.carParkMangerSlot = carParkMangerSlot;
		liftVehicleList = carParkMangerSlot.operator.getSecondEntryExitVehicleList();
	}

	@Override
	public void run() {
		while (true) {
			synchronized (liftVehicleList) {
				if (liftVehicleList.size() > 0) {
					Vehicle vehicle = liftVehicleList.poll();
					if (vehicle != null) {
						if (vehicle.isExit()) {
							carParkMangerSlot.depart(vehicle, 2);
						} else {
							carParkMangerSlot.arrive(vehicle, 2);
						}
					}
				}
			}
		}
	}


}
