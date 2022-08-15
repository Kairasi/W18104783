package W18104783;

import java.util.Queue;

import W18104783.Vehicle;
import W18104783.PettahMultiStoreyCarParkManager;

public class EntryGate implements Runnable{
	
	private PettahMultiStoreyCarParkManager carParkMangerSlot;
	private int level;
	Queue<Vehicle> entryVehicleList;

	public EntryGate(PettahMultiStoreyCarParkManager carParkMangerSlot, int level) {
		super();
		this.carParkMangerSlot = carParkMangerSlot;
		this.level = level;

		if (level == 0) {
			entryVehicleList = carParkMangerSlot.operator.getEntryVehicleList();
		} else {
			entryVehicleList = carParkMangerSlot.operator.getFirstEntryVehicleList();
		}
	}

	@Override
	public void run() {
		while (true) {
			synchronized (entryVehicleList) {
				if (entryVehicleList.size() > 0) {
					Vehicle vehicle = entryVehicleList.poll();
					if (vehicle != null) {
						carParkMangerSlot.arrive(vehicle, level);
					}
				}
			}
		}
	}

}
