package W18104783;

import java.util.Comparator;

import W18104783.Level;
import W18104783.VehicleType;
import W18104783.Vehicle;

public class VehicleComparatorLift  implements Comparator<Vehicle>{
	
	@Override
	public int compare(Vehicle v1, Vehicle v2) {

		try
		{
			return v2.getLevelSevenPriority().compareTo(v1.getLevelSevenPriority());
		}
		catch(Exception e)
		{
			return -1;
		}

	}

}
