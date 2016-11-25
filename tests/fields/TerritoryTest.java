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
    public void landOnField() throws Exception {
        int startBalance1 = testPlayer1.getPlayerAccount().getBalance();
        int startBalance2 = testPlayer2.getPlayerAccount().getBalance();
        Territory currentTerritory1 = (Territory) testBoard.getFields()[0];

        //this section tests that you don't pay for landing on an unowned territory.
        currentTerritory1.landOnField(testPlayer1);
        assertEquals(startBalance1, testPlayer1.getPlayerAccount().getBalance());

        //this section tests that the owner doesn't pay for landing on his own fields.
        currentTerritory1.purchaseField(testPlayer1);
        currentTerritory1.landOnField(testPlayer1);
        assertEquals(startBalance1 - currentTerritory1.getPrice(), testPlayer1.getPlayerAccount().getBalance());

        //this section tests that player 2 pays for landing on a field owned by player1
        currentTerritory1.landOnField(testPlayer2);
        assertEquals(startBalance2-currentTerritory1.getRent(), testPlayer2.getPlayerAccount().getBalance());
    }

    @Test
    public void purchaseField() throws Exception {
        int startBalance1 = testPlayer1.getPlayerAccount().getBalance();
        int startBalance2 = testPlayer2.getPlayerAccount().getBalance();
        Territory currentTerritory = (Territory) testBoard.getFields()[0];

        //This section tests if players pay the right amount for fields and tests if they get assigned as owner.
        currentTerritory.purchaseField(testPlayer1);
        assertEquals(startBalance1-currentTerritory.getPrice(), testPlayer1.getPlayerAccount().getBalance());
        assertEquals(testPlayer1, currentTerritory.getOwner());

        //This section tests if player 2 can purchase a field owned by player 1, and tests if he pays (even if he can't)
        currentTerritory.purchaseField(testPlayer2);
        assertEquals(testPlayer1, currentTerritory.getOwner());
        assertEquals(testPlayer2.getPlayerAccount().getBalance(), startBalance2);

        //This section tests if player 1 can purchase a field he already owns and if he pays for it (even if he can't).
        currentTerritory.purchaseField(testPlayer1);
        assertEquals(startBalance1-currentTerritory.getPrice(), testPlayer1.getPlayerAccount().getBalance());

        //This section tests the territory is ownable
        assertTrue(currentTerritory.isOwned());
    }
}