package GUI;

import GUI.backend.Mover;
import GUI.board.BoardController;
import GUI.fields.*;
import GUI.fields.Field;
import GUI.fields.Fleet;
import GUI.fields.LaborCamp;
import GUI.fields.Refuge;
import GUI.fields.Tax;
import GUI.fields.Territory;
import com.sun.xml.internal.ws.api.addressing.OneWayFeature;
import fields.*;
import models.Player;
import strings.Lang;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameGUI {
    private Mover[] movers = new Mover[6];

    public GameGUI() {
        createPlayers();
        createBoardWithFields();
    }

    private void initMovers() {
        movers[0] = new Mover.Builder()
                .troldeTanja()
                .primaryColor(new Color(22, 154,255))
                .secondaryColor(new Color(255, 21, 208))
                .overlayDualColor()
                .build();
        movers[1] = new Mover.Builder()
                .troldeTanja()
                .primaryColor(Color.GREEN)
                .secondaryColor(Color.WHITE)
                .overlayDualColor()
                .build();
        movers[2] = new Mover.Builder()
                .troldeTanja()
                .primaryColor(Color.WHITE)
                .secondaryColor(Color.RED)
                .overlayDualColor()
                .build();
        movers[3] = new Mover.Builder()
                .troldeTanja()
                .primaryColor(Color.YELLOW)
                .secondaryColor(Color.GREEN)
                .overlayDualColor()
                .build();
        movers[4] = new Mover.Builder()
                .troldeTanja()
                .primaryColor(Color.BLUE)
                .secondaryColor(Color.ORANGE)
                .overlayDualColor()
                .build();
        movers[5] = new Mover.Builder()
                .troldeTanja()
                .primaryColor(Color.WHITE)
                .secondaryColor(new Color(22, 154,255))
                .overlayDualColor()
                .build();
    }

    private void createBoardWithFields() {
        ArrayList<Field> list = new ArrayList<>();

        //Field #1
        list.add(new Territory.Builder()
                .setTitle("Tribe Encampment")
                .setPicture("src/GUI/art/fields/territories/tribalEncampment.png")
                .setRent("100")
                .setPrice("1000")
                .build());

        //Field #2
        list.add(new Territory.Builder()
                .setTitle("Crater")
                .setPicture("src/GUI/art/fields/territories/crater.png")
                .setRent("300")
                .setPrice("1500")
                .build());

        //Field #3
        list.add(new Territory.Builder()
                .setTitle("Mountain")
                .setPicture("src/GUI/art/fields/territories/mountain.png")
                .setRent("500")
                .setPrice("2000")
                .build());

        //Field #4
        list.add(new Territory.Builder()
                .setTitle("Cold Desert")
                .setPicture("src/GUI/art/fields/territories/coldDesert.png")
                .setRent("700")
                .setPrice("3000")
                .build());

        //Field #5
        list.add(new Territory.Builder()
                .setTitle("Black Cave")
                .setPicture("src/GUI/art/fields/territories/blackCave.png")
                .setRent("1000")
                .setPrice("4000")
                .build());

        //Field #6
        list.add(new Territory.Builder()
                .setTitle("The Werewall")
                .setPicture("src/GUI/art/fields/territories/werewall.png")
                .setRent("1300")
                .setPrice("4300")
                .build());

        //Field #7
        list.add(new Territory.Builder()
                .setTitle("Mountain Village")
                .setPicture("src/GUI/art/fields/territories/mountainVillage.png")
                .setRent("1600")
                .setPrice("4750")
                .build());

        //Field #8
        list.add(new Territory.Builder()
                .setTitle("South Citadel")
                .setPicture("src/GUI/art/fields/territories/southCitadel.png")
                .setRent("2000")
                .setPrice("5000")
                .build());

        //Field #9
        list.add(new Territory.Builder()
                .setTitle("Palace Gates")
                .setPicture("src/GUI/art/fields/territories/palaceGates.png")
                .setRent("2600")
                .setPrice("5500")
                .build());

        //Field #10
        list.add(new Territory.Builder()
                .setTitle("Tower")
                .setPicture("src/GUI/art/fields/territories/tower.png")
                .setRent("3200")
                .setPrice("6000")
                .build());

        //Field #11
        list.add(new Territory.Builder()
                .setTitle("Castle")
                .setPicture("src/GUI/art/fields/territories/castle.png")
                .setRent("4000")
                .setPrice("8000")
                .build());

        //Field #12
        list.add(new Refuge.Builder()
                .setTitle("Walled City")
                .setPicture("src/GUI/art/Fields/refuge/walledCity.png")
                .setBonus("5000")
                .build());

        //Field #13
        list.add(new Refuge.Builder()
                .setTitle("Monastery")
                .setPicture("src/GUI/art/Fields/refuge/monastery.png")
                .setBonus("500")
                .build());

        //Field #14
        list.add(new LaborCamp.Builder()
                .setTitle("Huts in the Mountain")
                .setPicture("src/GUI/art/Fields/laborCamp/hutsInTheMountain.png")
                .setRent("dice x100")  //TODO: Should this maybe display the rent a player has to pay to the owner as well?
                .setPrice("2500")
                .build());

        //Field #15
        list.add(new LaborCamp.Builder()
                .setTitle("The Pit")
                .setPicture("src/GUI/art/Fields/laborCamp/thePit.png")
                .setRent("dice x100")  //TODO: Should this maybe display the rent a player has to pay to the owner as well?
                .setPrice("2500")
                .build());

        //Field #16
        list.add(new Tax.Builder()
                .setTitle("Goldmine")
                .setPicture("src/GUI/art/Fields/tax/goldmine.png")
                .setTax("2000")
                .build());

        //Field #17
        list.add(new Tax.Builder()
                .setTitle("Caravan")
                .setPicture("src/GUI/art/Fields/tax/caravan.png")
                .setTax("10% or 4000")   //TODO: Maybe have it show what 10% means for current player
                .build());

        //Field #18
        list.add(new Fleet.Builder()
                .setTitle("Second Sail")
                .setPicture("src/GUI/art/Fields/fleet/secondSail.png")
                .setRent("1000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        //Field #19
        list.add(new Fleet.Builder()
                .setTitle("Sea Grover")
                .setPicture("src/GUI/art/Fields/fleet/seaGrover.png")
                .setRent("2000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        //Field #20
        list.add(new Fleet.Builder()
                .setTitle("The Buccaneers")
                .setPicture("src/GUI/art/Fields/fleet/theBuccaneers.png")
                .setRent("3000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        //Field #21
        list.add(new Fleet.Builder()
                .setTitle("Privateer Armada")
                .setPicture("src/GUI/art/Fields/fleet/privateerArmada.png")
                .setRent("4000")  //TODO: Make it actually show the correct value according to the rules
                .setPrice("4000")
                .build());

        GUI.create(list);
    }

    private void createPlayers() {
        initMovers();

        for (int i = 0; i > Player.getPlayersList().size(); i++) {
            GUI.addPlayer(Player.getPlayersList().get(i), movers[i]);
        }
    }

    private void showDiceRoll(Player player) {
        GUI.setDice(player.getDiceCup().getResultArr()[0], player.getDiceCup().getResultArr()[1]);
    }

    private void moveMovers(Player player) {
        int results = player.getDiceCup().getTotalEyes();

        if (player.getCurrentField() == 0) {
            for(int i = 0 ; i < results ; i++)
                GUI.setMover(i, player);
        } else {
            for(int i = 0; i < results ; i++)
                if ((player.getCurrentField() + 1) == 22) {
                    GUI.setMover(1, player);
                } else {
                    GUI.setMover((player.getCurrentField() + 1), player);
            }
        }
    }

    private void updateBalance(Player player) {

    }

    private void playerRoll(Player player) {
        GUI.getUserButtonPressed(player.getPlayerName() + "! Roll for adventure and glory!", "Roll!");
        player.getDiceCup().roll();
    }

    private void wannaPurchase(Player player) {
        if (GUI.getUserButtonPressed("Wanna purchase the field you've landed on?", "yes", "no").equals("yes")) {

        }
    }

    private void testSetOwner(int fieldID, models.Player player) {
            GUI.setOwner(fieldID, player);
        GUI.setOwner(fieldID, player);
    }

   private void showDescriptionCardBuy(Field fieldnr) {

        //switch()



        GUI.displayChanceCard(Lang.msg("desc_buy_TheWerewall"));
        sleep(1200);
        GUI.displayChanceCard(Lang.msg("desc_rent_TheWerewall"));
        sleep(1200);
        GUI.displayChanceCard(Lang.msg("desc_buy_BlackCave"));
        sleep(1200);
        GUI.displayChanceCard(Lang.msg("desc_rent_BlackCave"));
        sleep(1200);
        GUI.displayChanceCard(Lang.msg("desc_buy_ColdDesert"));
        sleep(1200);
        GUI.displayChanceCard(Lang.msg("desc_rent_ColdDesert"));
        sleep(1200);
        GUI.displayChanceCard(Lang.msg("desc_buy_TribeEncampment"));
        sleep(1200);
        GUI.displayChanceCard(Lang.msg("desc_rent_TribeEncampment"));
    }
   private void showDescriptionCardRent(Field fieldnr) {

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

    private static void sleep(int n) {
        long t0, t1;
        t0 = System.currentTimeMillis();
        do{
            t1 = System.currentTimeMillis();
        }
        while((t1 - t0) < (n));
    }
}
