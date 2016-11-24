package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by awo on 24/11/16.
 */
public class GameLogicTest {
    Player p1, p2, p3;
    GameLogic game;

    @Before
    public void setUp() throws Exception {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        game = new GameLogic();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void playTurn() throws Exception {

    }

    @Test
    public void hasWon() throws Exception {
        assertFalse(game.hasWon(p1));
        assertFalse(game.hasWon(p2));
        assertFalse(game.hasWon(p3));
        Player.removePlayer(p2);
        Player.removePlayer(p3);
        assertTrue(game.hasWon(p1));
        assertFalse(game.hasWon(p2));
        assertFalse(game.hasWon(p3));
    }

    @Test
    public void nextPlayer() throws Exception {

    }

    @Test
    public void getPlayerTurn() throws Exception {

    }

    @Test
    public void getCurrentPlayer() throws Exception {

    }

    @Test
    public void getDiceCup() throws Exception {

    }

    @Test
    public void getTotalEyes() throws Exception {

    }

}