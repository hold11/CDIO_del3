package fields;

import models.GameBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import models.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by VLC on 22-11-2016.
 */
public class FleetTest {
    Player player1;
    Player player2;
    GameBoard board;
    Fleet testFleet;

    @Before
    public void setUp() throws Exception {
        player1 = new Player();
        player2 = new Player();
        board = new GameBoard();
    }

    @After
    public void tearDown() throws Exception {
        Player.reset();
        Ownable.reset();
    }

    @Test
    public void purchaseField() throws Exception {
        int player1StartBalance = player1.getPlayerAccount().getBalance();
        int player2StartBalance = player2.getPlayerAccount().getBalance();

        // Make var called fleet, set it to "Second Sail" (index 17 in fields in GameBoard).
        Fleet fleet = (Fleet) board.getFields()[17];
        fleet.purchaseField(player1);

        // Test if the price of the fleet has been withdrawn from the player who bought it.
        assertEquals(player1StartBalance - fleet.getPrice(), player1.getPlayerAccount().getBalance());

        // Check if the fleet is actually bought
        assertTrue(fleet.isOwned());

        // Check if another player can buy an already bought fleet
        fleet.purchaseField(player2);
        assertEquals(player1, fleet.owner);
        assertEquals(player2StartBalance, player2.getPlayerAccount().getBalance());

        // Check if the owner of a fleet can buy the same fleet again
        fleet.purchaseField(player1);
        assertEquals(player1StartBalance - fleet.getPrice(), player1.getPlayerAccount().getBalance());

        // The multiplier of the rent gets tested in the getRent() test down below.
    }

    /**
     * Tests if the same player buys all fleets, if the rent then is correct
     * @throws Exception
     */
    @Test
    public void getRentOnePlayerAll() throws Exception {
        Fleet fl1 = ((Fleet) board.getFields()[17]);
        Fleet fl2 = ((Fleet) board.getFields()[18]);
        Fleet fl3 = ((Fleet) board.getFields()[19]);
        Fleet fl4 = ((Fleet) board.getFields()[20]);

        assertEquals(0, fl1.getRent());

        fl1.purchaseField(player1);
        assertEquals(500, fl1.getRent());
        assertEquals(0  , fl2.getRent());
        assertEquals(0  , fl3.getRent());
        assertEquals(0  , fl4.getRent());

        fl2.purchaseField(player1);
        assertEquals(1000, fl1.getRent());
        assertEquals(1000, fl2.getRent());
        assertEquals(0   , fl3.getRent());
        assertEquals(0   , fl4.getRent());

        fl3.purchaseField(player1);
        assertEquals(2000, fl2.getRent());
        assertEquals(2000, fl2.getRent());
        assertEquals(2000, fl3.getRent());
        assertEquals(0   , fl4.getRent());


        fl4.purchaseField(player1);
        assertEquals(4000, fl2.getRent());
        assertEquals(4000, fl2.getRent());
        assertEquals(4000, fl3.getRent());
        assertEquals(4000, fl4.getRent());
    }

    /**
     * Tests if different people buys different amount of fleets, if the rent then is correct
     * @throws Exception
     */
    @Test
    public void getRentDifferentPlayers() throws Exception {
        Fleet fl1 = ((Fleet) board.getFields()[17]);
        Fleet fl2 = ((Fleet) board.getFields()[18]);
        Fleet fl3 = ((Fleet) board.getFields()[19]);
        Fleet fl4 = ((Fleet) board.getFields()[20]);

        assertEquals(0, fl1.getRent());
        assertEquals(0, fl2.getRent());
        assertEquals(0, fl3.getRent());
        assertEquals(0, fl4.getRent());

        fl1.purchaseField(player1);
        fl2.purchaseField(player1);
        fl3.purchaseField(player2);

        assertEquals(1000, fl1.getRent());
        assertEquals(1000, fl2.getRent());
        assertEquals(500 , fl3.getRent());
    }

    @Test
    public void landOnField() throws Exception {
        Fleet fleet = ((Fleet) board.getFields()[17]);
        fleet.purchaseField(player1);

        int player1StartBalance = player1.getPlayerAccount().getBalance();
        int player2StartBalance = player2.getPlayerAccount().getBalance();

        fleet.landOnField(player2);
        assertEquals(player2StartBalance - fleet.getRent(), player2.getPlayerAccount().getBalance());

        fleet.landOnField(player1);
        assertEquals(player1StartBalance, player1.getPlayerAccount().getBalance());

    }
}