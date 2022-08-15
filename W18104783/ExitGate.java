package W18104783;

import java.util.Queue;

import W18104783.Vehicle;
import W18104783.PettahMultiStoreyCarParkManager;

public class ExitGate implements Runnable {

	private PettahMultiStoreyCarParkManager carParkMangerSlot;
	private int level;
	private Queue<Vehicle> exitVehicleList;

	public ExitGate(PettahMultiStoreyCarParkManager carParkMangerSlot, int level) {
		super();
		this.carParkMangerSlot = carParkMangerSlot;
		this.level = level;

		if (level == 0) {
			exitVehicleList = carParkMangerSlot.operator.getExitVehicleList();
		} else {
			exitVehicleList = carParkMangerSlot.operator.getExitFirstVehicleList();
		}
	}

	@Override
	public void run() {
		while (true) {
			synchronized (exitVehicleList) {
				if (exitVehicleList.size() > 0) {
					Vehicle vehicle = exitVehicleList.poll();
					if (vehicle != null) {
						carParkMangerSlot.depart(vehicle, level);
					}
				}
			}
		}

	}

}
