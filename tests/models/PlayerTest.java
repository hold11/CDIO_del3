package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by VLC on 22-11-2016.
 */
public class PlayerTest {
    Player testPlayer1;
    Player testPlayer2;

    @Before
    public void setUp() throws Exception {
        testPlayer1 = new Player();
        testPlayer2 = new Player();
    }

    @After
    public void tearDown() throws Exception {
        Player.reset();
    }

    @Test
    public void getPlayerAccount() throws Exception {
        int testincrementer = 200;
        testPlayer2.getPlayerAccount().deposit(testincrementer);
        assertEquals(30000, testPlayer1.getPlayerAccount().getBalance());
        assertEquals(30000+testincrementer, testPlayer2.getPlayerAccount().getBalance());
    }

    @Test
    public void getPlayerID() throws Exception {
        assertEquals(1, testPlayer1.getPlayerID());
        assertEquals(2, testPlayer2.getPlayerID());
        assertEquals(2, Player.getPlayersList().size());
    }

    @Test
    public void getPlayerName() throws Exception {
        Player testPlayer3 = new Player("bobdylan");
        assertTrue("bobdylan" == testPlayer3.getPlayerName());
        assertFalse("bobdylan" == testPlayer1.getPlayerName());
    }

//    @Test
//    public void moveCurrentField() throws Exception {
//        GameBoard testBoard = new GameBoard();
//        testPlayer1.moveCurrentField(testBoard.getFields()[2]);
//        assertEquals(testBoard.getFields()[2], testPlayer1.getCurrentField());
//    }


    @Test
    public void moveCurrentField() throws Exception {
        // For this we'll test following data:
        // Field count = 21
        // Player on   = 18
        // Rolls       = 10

        // Supposed to land on field number 7 (index 6).
        testPlayer1.setCurrentField(18);
        int diceRoll = 10;
        testPlayer1.moveCurrentField(diceRoll);
        assertEquals(6, testPlayer1.getCurrentField());

    }

    @Test
    public void findPlayer() throws Exception {
        assertEquals(testPlayer1, Player.findPlayer(1));
    }
}