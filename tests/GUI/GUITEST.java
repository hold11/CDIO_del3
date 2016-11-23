package GUI;

import GUI.backend.Car;
import GUI.fields.*;
import GUI.resources.GUI;
import models.GameBoard;
import models.Player;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by twast on 23/11/2016.
 */
public class GUITEST {
    public static void main(String[] args) {
        Player p = new Player();
        GameBoard g = new GameBoard();

        ArrayList<Field> list = new ArrayList<Field>();

        list.add(new Tax.Builder())

        list.add(new Refuge.Builder()
                .setTitle("Walled City")
                .setSubText("Walled City")
                .setPicture("art/Walled_City.jpg")
                .build());

        list.add(new Refuge.Builder()
                .setTitle("Monastary")
                .setSubText("Monastary")
                .setPicture("art/Monastary.jpg")
                .build());

        list.add(new Shipping.Builder()
                .setSubText("Second Sail")
                .setTitle("Second Sail")
                .setRent("1000")
                .setPicture("art/Second_Sail.png")
                .build());

        list.add(new Shipping.Builder()
                .setSubText("Sea Grover")
                .setTitle("Sea Grover")
                .setRent("2000")
                .setPicture("art/Sea_Grover.png")
                .build());

        list.add(new Shipping.Builder()
                .setSubText("The Buccaneers")
                .setTitle("The Buccaneers")
                .setRent("3000")
                .setPicture("art/The_Buccaneers.png")
                .build());

        list.add(new Shipping.Builder()
                .setSubText("Private Armada")
                .setTitle("Private Armada")
                .setRent("4000")
                .setPicture("art/Private_Armada.png")
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
