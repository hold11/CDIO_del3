package fields;

import models.GameBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import models.Player;


import static org.junit.Assert.*;

/**
 * Created by VLC on 22-11-2016.
 */
public class FleetTest {
    Player p1;
    GameBoard gameBoard;
    @Before
    public void setUp() throws Exception {
        p1 = new Player();
        gameBoard = new GameBoard();
    }

    @After
    public void tearDown() throws Exception {
        Player.reset();
    }

    @Test
    public void purchaseField() throws Exception {
        Field testFleet = gameBoard.getFields()[17];

    }

    @Test
    public void setMultiplier() throws Exception {

    }

    @Test
    public void getRent() throws Exception {

    }

    @Test
    public void landOnField() throws Exception {

    }

    @Test
    public void getRent1() throws Exception {

    }

    @Test
    public void purchaseField1() throws Exception {

    }

}