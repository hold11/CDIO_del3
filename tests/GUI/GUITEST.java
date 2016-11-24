package GUI;

import GUI.backend.Mover;
import GUI.fields.*;
import GUI.resources.GUI;

import java.awt.*;
import java.util.ArrayList;

public class GUITEST {
    public static void main(String[] args) {

        ArrayList<Field> list = new ArrayList<Field>();

        list.add(new Territory.Builder()
                .setTitle("Tribe Encampment")
                .setSubText("Tribe Encampment")
                .setPicture("src/GUI/resources/art/Tribe_Encampment.jpg")
                .setRent("100")
                .setPrice("1000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Crater")
                .setSubText("Crater")
                .setPicture("src/GUI/resources/art/Crater.jpg")
                .setRent("300")
                .setPrice("1500")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Mountain")
                .setSubText("Mountain")
                .setPicture("src/GUI/resources/art/Mountain.jpg")
                .setRent("500")
                .setPrice("2000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Cold Desert")
                .setSubText("Cold Desert")
                .setPicture("src/GUI/resources/art/Cold_Desert.jpg")
                .setRent("700")
                .setPrice("3000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Black Cave")
                .setSubText("Black Cave")
                .setPicture("src/GUI/resources/art/Black_Cave.jpg")
                .setRent("1000")
                .setPrice("4000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("The Werewall")
                .setSubText("The Werewall")
                .setPicture("src/GUI/resources/art/The_Werewall.jpg")
                .setRent("1300")
                .setPrice("4300")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Mountain Village")
                .setSubText("Mountain Village")
                .setPicture("src/GUI/resources/art/Mountain_Village.jpg")
                .setRent("1600")
                .setPrice("4750")
                .build());

        list.add(new Territory.Builder()
                .setTitle("South Citadel")
                .setSubText("South Citadel")
                .setPicture("src/GUI/resources/art/South_Citadel.jpg")
                .setRent("2000")
                .setPrice("5000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Palace Gates")
                .setSubText("Palace Gates")
                .setPicture("src/GUI/resources/art/Palace_Gates.jpg")
                .setRent("2600")
                .setPrice("5500")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Tower")
                .setSubText("Tower")
                .setPicture("src/GUI/resources/art/Tower.jpg")
                .setRent("3200")
                .setPrice("6000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Castle")
                .setSubText("Castle")
                .setPicture("src/GUI/resources/art/Castle.jpg")
                .setRent("4000")
                .setPrice("8000")
                .build());

        list.add(new Refuge.Builder()
                .setTitle("Walled City")
                .setSubText("Walled City")
                .setPicture("src/GUI/resources/art/Walled_City.jpg")
                .setBonus("5000")
                .build());

        list.add(new Refuge.Builder()
                .setTitle("Monastary")
                .setSubText("Monastary")
                .setPicture("src/GUI/resources/art/Monastary.jpg")
                .setBonus("500")
                .build());

        list.add(new LaborCamp.Builder()
                .setTitle("Huts in the Mountain")
                .setSubText("Huts in the Mountain")
                .setPicture("src/GUI/resources/art/Mountain_Hut.jpg")
                .setRent("dice x100")  //TODO: Should this maybe display the rent a player has to pay to the owner as well?
                .setPrice("2500")
                .build());

        list.add(new LaborCamp.Builder()
                .setTitle("The Pit")
                .setSubText("The Pit")
                .setPicture("src/GUI/resources/art/The_Pit.jpg")
                .setRent("dice x100")  //TODO: Should this maybe display the rent a player has to pay to the owner as well?
                .setPrice("2500")
                .build());

        list.add(new Tax.Builder()
                .setTitle("Goldmine")
                .setSubText("Goldmine")
                .setPicture("src/GUI/resources/art/Goldmine.jpg")
                .setTax("2000")
                .build());

        list.add(new Tax.Builder()
                .setTitle("Caravan")
                .setSubText("Caravan")
                .setPicture("src/GUI/resources/art/Caravan.jpg")
                .setTax("10% or 4000")   //TODO: Maybe have it show what 10% means for current player
                .build());

        list.add(new Fleet.Builder()
                .setTitle("Second Sail")
                .setSubText("Second Sail")
                .setPicture("src/GUI/resources/art/Second_Sail.png")
                .setRent("1000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        list.add(new Fleet.Builder()
                .setTitle("Sea Grover")
                .setSubText("Sea Grover")
                .setPicture("src/GUI/resources/art/Sea_Grover.png")
                .setRent("2000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        list.add(new Fleet.Builder()
                .setTitle("The Buccaneers")
                .setSubText("The Buccaneers")
                .setPicture("src/GUI/resources/art/The_Buccaneers.png")
                .setRent("3000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        list.add(new Fleet.Builder()
                .setTitle("Private Armada")
                .setSubText("Private Armada")
                .setPicture("src/GUI/resources/art/Private_Armada.png")
                .setRent("4000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());


        Field[] fields = new Field[list.size()];
        for(int i = 0; i < fields.length; i++) fields[i] = list.get(i);

        GUI.create(fields);


        Mover car1 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steen", 30000, car1);

        Mover car2 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeen", 30000, car2);

        Mover car3 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeen", 30000, car3);

        Mover car4 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeeen", 30000, car4);

        Mover car5 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeeeen", 30000, car5);

        Mover car6 = new Mover.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeeeeen", 30000, car6);
    }
}
