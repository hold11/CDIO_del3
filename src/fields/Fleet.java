package fields;

import models.Player;

/**
 * Created by tjc on 21/11/16.
 */
public class Fleet extends Ownable
{
    private int RENT_1 = 500;
    private int RENT_2 = 1000;
    private int RENT_3 = 2000;
    private int RENT_4 = 4000;

    @Override
    public int getRent() {
        return 0;
    }

    @Override
    public void landOnField(Player player) {

    }
}
