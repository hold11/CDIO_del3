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

    }

    @Test
    public void getCurrentField() throws Exception {

    }

    @Test
    public void setCurrentField() throws Exception {

    }

    @Test
    public void findPlayer() throws Exception {

    }

    @Test
    public void getPlayersList() throws Exception {

    }

    @Test
    public void reset() throws Exception {

    }

}