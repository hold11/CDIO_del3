package GUI;

import GUI.backend.Mover;
import GUI.fields.*;

import java.awt.*;
import java.util.ArrayList;

public class GUITEST {

    public static void main(String[] args) {
        GUITEST test = new GUITEST();

        test.CreateBoardWithFields();
        test.createPlayers();
        test.testSetOwner();
        //test.realExampleGame();
    }

    private void CreateBoardWithFields() {
        ArrayList<Field> list = new ArrayList<Field>();

        //Field #1
        list.add(new Territory.Builder()
                .setTitle("Tribe Encampment")
                // // .setSubtext("Tribe Encampment")
                .setPicture("src/GUI/art/fields/territories/tribalEncampment.png")
                .setRent("100")
                .setPrice("1000")
                .build());

        //Field #2
        list.add(new Territory.Builder()
                .setTitle("Crater")
                // .setSubtext("Crater")
                .setPicture("src/GUI/art/fields/territories/crater.png")
                .setRent("300")
                .setPrice("1500")
                .build());

        //Field #3
        list.add(new Territory.Builder()
                .setTitle("Mountain")
                // .setSubtext("Mountain")
                .setPicture("src/GUI/art/fields/territories/mountain.png")
                .setRent("500")
                .setPrice("2000")
                .build());

        //Field #4
        list.add(new Territory.Builder()
                .setTitle("Cold Desert")
                // .setSubtext("Cold Desert")
                .setPicture("src/GUI/art/fields/territories/coldDesert.png")
                .setRent("700")
                .setPrice("3000")
                .build());

        //Field #5
        list.add(new Territory.Builder()
                .setTitle("Black Cave")
                // .setSubtext("Black Cave")
                .setPicture("src/GUI/art/fields/territories/blackCave.png")
                .setRent("1000")
                .setPrice("4000")
                .build());

        //Field #6
        list.add(new Territory.Builder()
                .setTitle("The Werewall")
                // .setSubtext("The Werewall")
                .setPicture("src/GUI/art/fields/territories/werewall.png")
                .setRent("1300")
                .setPrice("4300")
                .build());

        //Field #7
        list.add(new Territory.Builder()
                .setTitle("Mountain Village")
                // .setSubtext("Mountain Village")
                .setPicture("src/GUI/art/fields/territories/mountainVillage.png")
                .setRent("1600")
                .setPrice("4750")
                .build());

        //Field #8
        list.add(new Territory.Builder()
                .setTitle("South Citadel")
                // .setSubtext("South Citadel")
                .setPicture("src/GUI/art/fields/territories/southCitadel.png")
                .setRent("2000")
                .setPrice("5000")
                .build());

        //Field #9
        list.add(new Territory.Builder()
                .setTitle("Palace Gates")
                // .setSubtext("Palace Gates")
                .setPicture("src/GUI/art/fields/territories/palaceGates.png")
                .setRent("2600")
                .setPrice("5500")
                .build());

        //Field #10
        list.add(new Territory.Builder()
                .setTitle("Tower")
                // .setSubtext("Tower")
                .setPicture("src/GUI/art/fields/territories/tower.png")
                .setRent("3200")
                .setPrice("6000")
                .build());

        //Field #11
        list.add(new Territory.Builder()
                .setTitle("Castle")
                // .setSubtext("Castle")
                .setPicture("src/GUI/art/fields/territories/castle.png")
                .setRent("4000")
                .setPrice("8000")
                .build());

        //Field #12
        list.add(new Refuge.Builder()
                .setTitle("Walled City")
                // .setSubtext("Walled City")
                .setPicture("src/GUI/art/Fields/Walled_City.jpg")
                .setBonus("5000")
                .build());

        //Field #13
        list.add(new Refuge.Builder()
                .setTitle("Monastery")
                //// .setSubtext("Monastary")
                .setPicture("src/GUI/art/Fields/Monastery.jpg")
                .setBonus("500")
                .build());

        //Field #14
        list.add(new LaborCamp.Builder()
                .setTitle("Huts in the Mountain")
                //// .setSubtext("Huts in the Mountain")
                .setPicture("src/GUI/art/Fields/Mountain_Hut.jpg")
                .setRent("dice x100")  //TODO: Should this maybe display the rent a player has to pay to the owner as well?
                .setPrice("2500")
                .build());

        //Field #15
        list.add(new LaborCamp.Builder()
                .setTitle("The Pit")
                //// .setSubtext("The Pit")
                .setPicture("src/GUI/art/Fields/The_Pit.jpg")
                .setRent("dice x100")  //TODO: Should this maybe display the rent a player has to pay to the owner as well?
                .setPrice("2500")
                .build());

        //Field #16
        list.add(new Tax.Builder()
                .setTitle("Goldmine")
                //// .setSubtext("Goldmine")
                .setPicture("src/GUI/art/Fields/Goldmine.jpg")
                .setTax("2000")
                .build());

        //Field #17
        list.add(new Tax.Builder()
                .setTitle("Caravan")
                // .setSubtext("Caravan")
                .setPicture("src/GUI/art/Fields/Caravan.jpg")
                .setTax("10% or 4000")   //TODO: Maybe have it show what 10% means for current player
                .build());

        //Field #18
        list.add(new Fleet.Builder()
                .setTitle("Second Sail")
                // .setSubtext("Second Sail")
                .setPicture("src/GUI/art/Fields/Second_Sail.png")
                .setRent("1000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        //Field #19
        list.add(new Fleet.Builder()
                .setTitle("Sea Grover")
                // .setSubtext("Sea Grover")
                .setPicture("src/GUI/art/Fields/Sea_Grover.png")
                .setRent("2000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        //Field #20
        list.add(new Fleet.Builder()
                .setTitle("The Buccaneers")
                // .setSubtext("The Buccaneers")
                .setPicture("src/GUI/art/Fields/The_Buccaneers.png")
                .setRent("3000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        //Field #21
        list.add(new Fleet.Builder()
                .setTitle("Private Armada")
                // .setSubtext("Private Armada")
                .setPicture("src/GUI/art/Fields/Private_Armada.png")
                .setRent("4000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());


//        Field[] fields = new Field[list.size()];
//        for(int i = 0; i < fields.length; i++) fields[i] = list.get(i);

        GUI.create(list);
    }
    private void createPlayers() {
        Mover mover1 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steen", 30000, mover1);

        Mover mover2 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.GREEN)
                .secondaryColor(Color.BLACK)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeen", 30000, mover2);

        Mover mover3 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.WHITE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeen", 30000, mover3);

        Mover mover4 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.BLACK)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeeen", 30000, mover4);

        Mover mover5 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.BLACK)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeeeen", 30000, mover5);

        Mover mover6 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.WHITE)
                .secondaryColor(Color.BLUE)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeeeeen", 30000, mover6);
    }
    private void testSetOwner() {
        for (int i = 1 ; i < 3 ; i++) {
            GUI.setOwner(i, "Steen");
        }
        for (int i = 3 ; i < 5 ; i++) {
            GUI.setOwner(i, "Steeen");
        }
        for (int i = 5 ; i < 7 ; i++) {
            GUI.setOwner(i, "Steeeen");
        }
        for (int i = 7 ; i < 9 ; i++) {
            GUI.setOwner(i, "Steeeeen");
        }
        for (int i = 9 ; i < 11 ; i++) {
            GUI.setOwner(i, "Steeeeeen");
        }
        for (int i = 11 ; i < 12 ; i++) {
            GUI.setOwner(i, "Steeeeeeen");
        }
        GUI.setOwner(14, "steen");
        GUI.setOwner(15, "steeen");
        GUI.setOwner(18, "steeeen");
        GUI.setOwner(19, "steeeeen");
        GUI.setOwner(20, "steeeeeen");
        GUI.setOwner(21, "steeeeeeen");
    }
    private void realExampleGame(){

        GUI.setMover(1, "Steen");
        sleep(1200);
        GUI.setMover(1, "Steeeeeeen");

        sleep(1200);
        GUI.setDice(1, 2);
        sleep(1200);
        GUI.removeAllMovers("Mads");
        GUI.setMover(2, "Mads");
        sleep(1200);
        GUI.removeAllMovers("Mads");
        GUI.setMover(3, "Mads");
        sleep(1200);
        GUI.removeAllMovers("Mads");
        GUI.setMover(4, "Mads");
        sleep(1200);
        GUI.setBalance("Mads", 28000);
        GUI.setOwner(4, "Mads");
        sleep(1200);
        GUI.displayChanceCard("De har vundet vild med dans og skifter navn til Allan!");
    }
    private static void sleep(int n) {
        long t0, t1;
        t0 = System.currentTimeMillis();
        do{
            t1 = System.currentTimeMillis();
        }
        while((t1 - t0) < (n));
    }
    private void testSetTexts() {
        int fieldNr = 0;
        String desc = "description";
        String sub = "subtext";
        String title = "title";
        // Start - 1
        fieldNr = 1;
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
}