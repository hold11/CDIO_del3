package GUI;

import GUI.backend.Car;
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
                .setPicture("art/Tribe_Encampment.jpg")
                .setRent("100")
                .setPrice("1000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Crater")
                .setSubText("Crater")
                .setPicture("art/Crater.jpg")
                .setRent("300")
                .setPrice("1500")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Mountain")
                .setSubText("Mountain")
                .setPicture("art/Mountain.jpg")
                .setRent("500")
                .setPrice("2000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Cold Desert")
                .setSubText("Cold Desert")
                .setPicture("art/Cold_Desert.jpg")
                .setRent("700")
                .setPrice("3000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Black Cave")
                .setSubText("Black Cave")
                .setPicture("art/Black_Cave.jpg")
                .setRent("1000")
                .setPrice("4000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("The Werewall")
                .setSubText("The Werewall")
                .setPicture("art/The_Werewall.jpg")
                .setRent("1300")
                .setPrice("4300")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Mountain Village")
                .setSubText("Mountain Village")
                .setPicture("art/Mountain_Village.jpg")
                .setRent("1600")
                .setPrice("4750")
                .build());

        list.add(new Territory.Builder()
                .setTitle("South Citadel")
                .setSubText("South Citadel")
                .setPicture("art/South_Citadel.jpg")
                .setRent("2000")
                .setPrice("5000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Palace Gates")
                .setSubText("Palace Gates")
                .setPicture("art/Palace_Gates.jpg")
                .setRent("2600")
                .setPrice("5500")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Tower")
                .setSubText("Tower")
                .setPicture("art/Tower.jpg")
                .setRent("3200")
                .setPrice("6000")
                .build());

        list.add(new Territory.Builder()
                .setTitle("Castle")
                .setSubText("Castle")
                .setPicture("art/Castle.jpg")
                .setRent("4000")
                .setPrice("8000")
                .build());

        list.add(new Refuge.Builder()
                .setTitle("Walled City")
                .setSubText("Walled City")
                .setPicture("art/Walled_City.jpg")
                .setBonus("5000")
                .build());

        list.add(new Refuge.Builder()
                .setTitle("Monastary")
                .setSubText("Monastary")
                .setPicture("art/Monastary.jpg")
                .setBonus("500")
                .build());

        list.add(new LaborCamp.Builder()
                .setTitle("Huts in the Mountain")
                .setSubText("Huts in the Mountain")
                .setPicture("art/Mountain_Hut.jpg")
                .setRent("dice x100")  //TODO: Should this maybe display the rent a player has to pay to the owner as well?
                .setPrice("2500")
                .build());

        list.add(new LaborCamp.Builder()
                .setTitle("The Pit")
                .setSubText("The Pit")
                .setPicture("art/The_Pit.jpg")
                .setRent("dice x100")  //TODO: Should this maybe display the rent a player has to pay to the owner as well?
                .setPrice("2500")
                .build());

        list.add(new Tax.Builder()
                .setTitle("Goldmine")
                .setSubText("Goldmine")
                .setPicture("art/Goldmine.jpg")
                .setTax("2000")
                .build());

        list.add(new Tax.Builder()
                .setTitle("Caravan")
                .setSubText("Caravan")
                .setPicture("art/Caravan.jpg")
                .setTax("10% or 4000")   //TODO: Maybe have it show what 10% means for current player
                .build());

        list.add(new Fleet.Builder()
                .setTitle("Second Sail")
                .setSubText("Second Sail")
                .setPicture("art/Second_Sail.png")
                .setRent("1000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        list.add(new Fleet.Builder()
                .setTitle("Sea Grover")
                .setSubText("Sea Grover")
                .setPicture("art/Sea_Grover.png")
                .setRent("2000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        list.add(new Fleet.Builder()
                .setTitle("The Buccaneers")
                .setSubText("The Buccaneers")
                .setPicture("art/The_Buccaneers.png")
                .setRent("3000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        list.add(new Fleet.Builder()
                .setTitle("Private Armada")
                .setSubText("Private Armada")
                .setPicture("art/Private_Armada.png")
                .setRent("4000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());


        Field[] fields = new Field[list.size()];
        for(int i = 0; i < fields.length; i++) fields[i] = list.get(i);

        GUI.create(fields);
        Car car1 = new Car.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steen", 30000, car1);

        Car car2 = new Car.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeen", 30000, car2);

        Car car3 = new Car.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeen", 30000, car3);

        Car car4 = new Car.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeeen", 30000, car4);

        Car car5 = new Car.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeeeen", 30000, car5);

        Car car6 = new Car.Builder()
                .typeRacecar()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.RED)
                .patternDiagonalDualColor()
                .build();
        GUI.addPlayer("Steeeeeeen", 30000, car6);
    }
}