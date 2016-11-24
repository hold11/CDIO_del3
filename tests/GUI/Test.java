package GUI;

import java.awt.Color;
import GUI.backend.Mover;
import GUI.resources.GUI;

public class Test {
	
	public static void main(String[] args) {
		Test test = new Test();
		test.setDiceAngleAndCoordinates();
		test.testClose();
		// GUI.create("C:\\Users\\Ronnie\\Desktop\\fields.txt");
		test.testSetText();
		test.testSetTexts();
		test.testAddPlayer();
		test.testSetBalance();
		test.testSetDice();
		test.testInput();
		test.testSetNextChanceCardText();
		test.testSetCar();
		test.testSetOwner();
		test.testSetDiceAngleAndCoordinatesMultipleTimes();
		test.testSetDiceAllAngles();
		test.testRemoveCar();
		test.testRemoveOwner();
		try {
			Thread.sleep(2000);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		// System.exit(0);
	}
	
	private void setDiceAngleAndCoordinates() {
		GUI.setDice(6, 0, 1, 1, 6, 90, 2, 1);
	}
	private void testInput() {
		System.out.println("testInput:"
			+ GUI.getUserSelection("Vælg en grund", "Hvidovrevej", "Rødovrevej", "Peters vej",
				"Oskars vej") + ".");
		// System.out.println(GUI.getUserLeftButtonPressed("Vil du gå fallit?", "Yes", "No"));
		// System.out.println("testInput:" + GUI.getUserButtonPressed("Vælg en grund",
		// "Hvidovrevej", "Rødovrevej", "Peters vej", "Oskars vej") + ".");
		// int returInt = GUI.getUserInteger("Indtast tal [0-999999999]");
		// int returInt = GUI.getUserInteger("Indtast tal [2-22]", 2, 22);
		// String retur = GUI.getUserString("222");
		// System.out.println("Retur fra getUserInteger: " + returInt);
		// GUI.showMessage("HEJ");
	}
	private void testClose() {
		GUI.setTitleText(4, "TestingClose");
		GUI.close();
	}
	private void testSetText() {
		GUI.setTitleText(3, "Ocean Blv.");
		GUI.setSubText(3, "Price: 1 mio.");
		GUI.setDescriptionText(
			3,
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac libero lorem. Aliquam ligula mauris, luctus interdum malesuada non, adipiscing ut mauris.");
		GUI.setTitleText(34, "Start");
		GUI.setSubText(1, "Daniel2");
		GUI.setDescriptionText(
			1,
			"Daniel3Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac libero lorem. Aliquam ligula mauris, luctus interdum malesuada non, adipiscing ut mauris.");
	}
	private void testSetTexts() {
		int fieldNr = 0;
		String desc = "description";
		String sub = "subtext";
		String title = "title";
		// Start - 1
		fieldNr = 34;
		GUI.setDescriptionText(fieldNr, desc + fieldNr);
		GUI.setSubText(fieldNr, sub + fieldNr);
		GUI.setTitleText(fieldNr, title + fieldNr);
		// LaborCamp - 13
		fieldNr = 13;
		GUI.setDescriptionText(fieldNr, desc + fieldNr);
		GUI.setSubText(fieldNr, sub + fieldNr);
		GUI.setTitleText(fieldNr, title + fieldNr);
		// Chance - 3
		fieldNr = 3;
		GUI.setDescriptionText(fieldNr, desc + fieldNr);
		GUI.setSubText(fieldNr, sub + fieldNr);
		GUI.setTitleText(fieldNr, title + fieldNr);
		// Refuge - 21
		fieldNr = 21;
		GUI.setDescriptionText(fieldNr, desc + fieldNr);
		GUI.setSubText(fieldNr, sub + fieldNr);
		GUI.setTitleText(fieldNr, title + fieldNr);
		// Fleet - 6
		fieldNr = 6;
		GUI.setDescriptionText(fieldNr, desc + fieldNr);
		GUI.setSubText(fieldNr, sub + fieldNr);
		GUI.setTitleText(fieldNr, title + fieldNr);
		// Territory - 2
		fieldNr = 2;
		GUI.setDescriptionText(fieldNr, desc + fieldNr);
		GUI.setSubText(fieldNr, sub + fieldNr);
		GUI.setTitleText(fieldNr, title + fieldNr);
		// Tax - 5
		fieldNr = 5;
		GUI.setDescriptionText(fieldNr, desc + fieldNr);
		GUI.setSubText(fieldNr, sub + fieldNr);
		GUI.setTitleText(fieldNr, title + fieldNr);
	}
	private void testAddPlayer() {
		GUI.addPlayer("Arthur Dent", 1000);
		
		Mover car;
		
		car = new Mover.Builder()
			.primaryColor(Color.MAGENTA)
			.secondaryColor(Color.BLUE)
			.typeTractor()
			.patternDotted()
			.build();
		GUI.addPlayer("Ford Prefect", 1000, car);
		
		car = new Mover.Builder()
			.primaryColor(Color.BLACK)
			.secondaryColor(Color.RED)
			.typeUfo()
			.patternZebra()
			.build();
		GUI.addPlayer("Zaphod Beeblebrox", 100000, car);
		
		car = new Mover.Builder()
			.primaryColor(Color.DARK_GRAY)
			.secondaryColor(Color.CYAN)
			.typeRacecar()
			.patternHorizontalLine()
			.build();
		GUI.addPlayer("Tricia McMillan", 100000, car);
		
		car = new Mover.Builder()
			.primaryColor(new Color(160, 32, 240))
			.secondaryColor(Color.YELLOW)
			.patternHorizontalGradiant()
			.build();
		GUI.addPlayer("Marvin", 1000, car);
		
		car = new Mover.Builder()
			.primaryColor(Color.BLACK)
			.secondaryColor(Color.WHITE)
			.patternCheckered()
			.build();
		GUI.addPlayer("Slartibartfast", 100000, car);
		
		GUI.addPlayer("Deep Thought", 100000);
	}
	private void testSetBalance() {
		GUI.setBalance("Ford Prefect", 100);
	}
	private void testSetDice() {
		// int d1 = (int)(Math.random()*6+1);
		// int d2 = (int)(Math.random()*6+1);
		// GUI.setDice(d1, d2);
		GUI.setDice(2, 3);
	}
	private void testSetDiceAllAngles() {
		for(int a = 0; a <= 360; a++) {
			GUI.setDice(5, a, 1, 1, 6, 359 - a, 2, 1);
			try {
				Thread.sleep(5);
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	private void testSetDiceAngleAndCoordinatesMultipleTimes() {
		for(int y = -1; y <= 11; y++) {
			for(int x = -1; x <= 11; x++) {
				int d1 = (int) (Math.random() * 6 + 1);
				int a1 = (int) (Math.random() * 360);
				int d2 = (int) (Math.random() * 6 + 1);
				int a2 = (int) (Math.random() * 360);
				GUI.setDice(d1, a1, 2, 2, d2, a2, x, y);
				try {
					Thread.sleep(25);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	private void testSetNextChanceCardText() {
		GUI.displayChanceCard("De har modtaget Bjørne Bandit - legatet og fængsles!");
	}
	private void testSetCar() {
		for(int i = 1; i <= 10; i++) {
			GUI.setMover(i, "Zaphod Beeblebrox");
		}
		for(int i = 11; i <= 20; i++) {
			GUI.setMover(i, "Tricia McMillan");
			GUI.setMover(i, "Ford Prefect");
		}
		for(int i = 21; i <= 30; i++) {
			GUI.setMover(i, "Arthur Dent");
			GUI.setMover(i, "Marvin");
			GUI.setMover(i, "Slartibartfast");
		}
		for(int i = 31; i <= 40; i++) {
			GUI.setMover(i, "Tricia McMillan");
			GUI.setMover(i, "Zaphod Beeblebrox");
			GUI.setMover(i, "Arthur Dent");
			GUI.setMover(i, "Ford Prefect");
			GUI.setMover(i, "Marvin");
			GUI.setMover(i, "Slartibartfast");
		}
	}
	private void testRemoveCar() {
		GUI.removeAllMovers("Zaphod Beeblebrox");
		GUI.removeAllMovers("Tricia McMillan");
		GUI.removeAllMovers("Ford Prefect");
		GUI.removeAllMovers("Arthur Dent");
		GUI.removeAllMovers("Marvin");
		GUI.removeAllMovers("Slartibartfast");
		
		GUI.removeAllMovers("Tricia McMillan");
		GUI.removeAllMovers("Zaphod Beeblebrox");
		GUI.removeAllMovers("Arthur Dent");
		GUI.removeAllMovers("Ford Prefect");
		GUI.removeAllMovers("Marvin");
		GUI.removeAllMovers("Slartibartfast");
	}
	private void testSetOwner() {
		for(int i = 1; i <= 10; i++) {
			GUI.setOwner(i, "Ford Prefect");
		}
		for(int i = 11; i <= 20; i++) {
			GUI.setOwner(i, "Slartibartfast");
		}
		for(int i = 21; i <= 30; i++) {
			GUI.setOwner(i, "Arthur Dent");
		}
	}
	private void testRemoveOwner() {
		for(int i = 1; i <= 5; i++) {
			GUI.removeOwner(i);
		}
		for(int i = 11; i <= 15; i++) {
			GUI.removeOwner(i);
		}
		for(int i = 21; i <= 25; i++) {
			GUI.removeOwner(i);
		}
	}
}
