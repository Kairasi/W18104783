package W18104783;

import W18104783.PettahMultiStoreyCarParkManager;
import W18104783.Elevator;
import W18104783.EntryGate;
import W18104783.ExitGate;
import W18104783.ObjectCreator;

public class Main {

	public static void main(String[] args) {
		PettahMultiStoreyCarParkManager pettahMultiStoreyCarParkManager = PettahMultiStoreyCarParkManager.getInstance();

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

		new ObjectCreator().createDummyVehicleObjects(pettahMultiStoreyCarParkManager);

	}

}
