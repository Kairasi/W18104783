package W18104783;

import java.util.Comparator;

import W18104783.Level;
import W18104783.VehicleType;
import W18104783.Vehicle;

public class VehicleComparator  implements Comparator<Vehicle>{
	
	@Override
	public int compare(Vehicle v1, Vehicle v2) {

		try
		{
			if (v1.getVehicleType() == VehicleType.Motorbike) {
				if (Level.getLevel(v1.getLevel()) % 3 == 0) {
					return v2.getPriority().compareTo(5);
				} else {
					return v2.getPriority().compareTo(3);
				}
	
			} else {
				return v2.getPriority().compareTo(v1.getPriority());
			}
		}
		catch(Exception e)
		{
			return -1;
		}
	}

}
