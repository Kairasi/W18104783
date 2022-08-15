package W18104783;

import W18104783.DateTime;
import W18104783.VehicleType;

public class Car extends Vehicle {
	
	// Car Properties
		private int doors;

		// Constructor
		public Car(String idPlate, String brand, String model, DateTime entryTime, int doors) {
			super(idPlate, brand, model, entryTime, VehicleType.Car, 10, 5, 10, 10);
		}

		public int getDoors() {
			return doors;
		}

		public void setDoors(int doors) {
			this.doors = doors;
		}

//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + ((color == null) ? 0 : color.hashCode());
//			result = prime * result + doors;
//			return result;
//		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Car other = (Car) obj;
//			if (color == null) {
//				if (other.color != null)
//					return false;
//			} else if (!color.equals(other.color))
//				return false;
			if (doors != other.doors)
				return false;
			return true;
		}

}
