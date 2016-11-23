package fields;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by VLC on 23-11-2016.
 */
public class TerritoryTest {

    GameBoard testBoard;
    Player testPlayer1;
    Player testPlayer2;
    @Before
    public void setUp() throws Exception {
        testPlayer1 = new Player();
        testPlayer2 = new Player();
        testBoard = new GameBoard();
    }

    @After
    public void tearDown() throws Exception {
        Player.reset();
    }

    @Test
    public void getRent() throws Exception {
        assertEquals(100,((Territory) testBoard.getFields()[0]).getRent());
    }

    @Test
    public void landOnField() throws Exception {

    }


    @Test // Tests if the right amount is withdrawn, also tests isOwned, if another player can buy an owned field, and if they owner can buy it multiple times.
    public void purchaseField() throws Exception {
        int startbalance1 = testPlayer1.getPlayerAccount().getBalance();
        int startbalance2 = testPlayer2.getPlayerAccount().getBalance();
        Territory currentTerritory = (Territory) testBoard.getFields()[0];
        currentTerritory.purchaseField(testPlayer1);

        assertEquals(testPlayer1.getPlayerAccount().getBalance(), startbalance1-currentTerritory.getPrice());
        assertEquals(testPlayer1, currentTerritory.getOwner());
        currentTerritory.purchaseField(testPlayer2);
        assertEquals(testPlayer1, currentTerritory.getOwner());
        assertEquals(testPlayer2.getPlayerAccount().getBalance(), startbalance2);



    }

}