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

    }

    @Test
    public void landOnField() throws Exception {

    }

    @Test
    public void getRent1() throws Exception {

    }

    @Test
    public void getRent2() throws Exception {

    }

    @Test
    public void isOwned() throws Exception {

    }

    @Test
    public void purchaseField() throws Exception {

    }

    @Test
    public void landOnField1() throws Exception {

    }

}